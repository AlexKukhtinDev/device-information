package com.akukhtin.deviceinformationapplication.services.impl;

import com.akukhtin.deviceinformationapplication.dto.DeviceDto;
import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.dto.util.Converter;
import com.akukhtin.deviceinformationapplication.entity.Device;
import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import com.akukhtin.deviceinformationapplication.repository.DeviceRepository;
import com.akukhtin.deviceinformationapplication.repository.DeviceWithAlarmsRepository;
import com.akukhtin.deviceinformationapplication.services.DeviceService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {

  private final DeviceRepository deviceRepository;
  private final DeviceWithAlarmsRepository deviceWithAlarmsRepository;
  @Value(value = "${alarm}")
  private String alarm;

  public DeviceServiceImpl(DeviceRepository deviceRepository,
                           DeviceWithAlarmsRepository deviceWithAlarmsRepository) {
    this.deviceRepository = deviceRepository;
    this.deviceWithAlarmsRepository = deviceWithAlarmsRepository;
  }


  @Override
  public DeviceDto findBySerialNumber(Integer serialNumber) {
    Device device = deviceRepository.findBySerialNumber(serialNumber);
    return Converter.converterDeviceToDeviceDto(device);
  }

  @Override
  public List<DeviceDto> findAllBySerialNumberAndDateOfLastContactBefore(
          Integer serialNumber, LocalDateTime dateOfLastContact) {
    List<Device> lastContactBefore =
            deviceRepository
                    .findAllBySerialNumberAndDateOfLastContactBefore(
                            serialNumber, LocalDateTime.now());

    List<DeviceDto> alarm = lastContactBefore.stream().map(device -> {
      device.setAlarm("Alarm");
      return Converter.converterDeviceToDeviceDto(device);
    }).collect(Collectors.toList());

    iterateList(alarm);
    return alarm;
  }

  private void iterateList(List<DeviceDto> alarm) {
    for (DeviceDto deviceDto : alarm) {
      DeviceWithAlarmsDto deviceWithAlarmsDto =
              Converter.converterDeviceDtoToDeviceWithAlarms(deviceDto);
      DeviceWithAlarms deviceWithAlarms =
              Converter.converterDeviceWithAlarmsDtoToDeviceWithAlarms(deviceWithAlarmsDto);
      saveIntoDbWithAlarms(deviceWithAlarms);
    }
  }

  private void saveIntoDbWithAlarms(DeviceWithAlarms deviceWithAlarms) {
    deviceWithAlarmsRepository.save(deviceWithAlarms);
  }

  @Override
  public List<DeviceWithAlarmsDto> findAllBySerialNumberAndCurrentVolumeIndicatorsIsLessThan(
          Integer serialNumber, Double currentVolumeIndicators) {
    List<Device> isLessThan =
            deviceRepository
                    .findAllBySerialNumberAndCurrentVolumeIndicatorsIsLessThan(
                            serialNumber, currentVolumeIndicators);

    List<DeviceWithAlarmsDto> deviceWithAlarmsDtos = isLessThan.stream().map(device -> {
      DeviceDto deviceDto = Converter.converterDeviceToDeviceDto(device);
      return Converter.converterDeviceDtoToDeviceWithAlarms(deviceDto);
    }).collect(Collectors.toList());

    for (DeviceWithAlarmsDto deviceWithAlarmsDto : deviceWithAlarmsDtos) {
      DeviceWithAlarms deviceWithAlarms =
              Converter.converterDeviceWithAlarmsDtoToDeviceWithAlarms(deviceWithAlarmsDto);
      saveIntoDbWithAlarms(deviceWithAlarms);
    }
    return deviceWithAlarmsDtos;
  }

  @Scheduled(fixedDelay = 3600000)
  private void checkConnectionEveryHours() {
    List<DeviceWithAlarms> allByAlarm = deviceWithAlarmsRepository.findAllByAlarm(alarm);
    List<DeviceWithAlarmsDto> deviceWithAlarmsDtos = null;
    List<DeviceDto> deviceDtos = null;
    for (DeviceWithAlarms deviceWithAlarms : allByAlarm) {
      deviceWithAlarmsDtos = doCheckCurrentVolume(deviceWithAlarms);
      deviceDtos = doCheckTime(deviceWithAlarms);
    }
    if (deviceWithAlarmsDtos != null) {
      List<DeviceWithAlarms> deviceWithAlarms = deviceWithAlarmsDtos.stream()
              .map(Converter::converterDeviceWithAlarmsDtoToDeviceWithAlarms)
              .collect(Collectors.toList());
      for (DeviceWithAlarms deviceWithAlarm : deviceWithAlarms) {
        deviceWithAlarmsRepository.save(deviceWithAlarm);
      }
    }
    List<DeviceWithAlarmsDto> withAlarmsDtos = deviceDtos != null ? deviceDtos.stream()
            .map(Converter::converterDeviceDtoToDeviceWithAlarms)
            .collect(Collectors.toList()) : null;

    if (withAlarmsDtos != null) {
      for (DeviceWithAlarmsDto withAlarmsDto : withAlarmsDtos) {
        DeviceWithAlarms deviceWithAlarms =
                Converter.converterDeviceWithAlarmsDtoToDeviceWithAlarms(withAlarmsDto);
        deviceWithAlarmsRepository.save(deviceWithAlarms);
      }
    }
  }

  private List<DeviceDto> doCheckTime(DeviceWithAlarms deviceWithAlarms) {
    return findAllBySerialNumberAndDateOfLastContactBefore(
            deviceWithAlarms.getSerialNumber(), LocalDateTime.now());
  }

  private List<DeviceWithAlarmsDto> doCheckCurrentVolume(DeviceWithAlarms deviceWithAlarms) {
    return findAllBySerialNumberAndCurrentVolumeIndicatorsIsLessThan(
            deviceWithAlarms.getSerialNumber(), deviceWithAlarms.getCurrentVolumeIndicators());
  }

}
