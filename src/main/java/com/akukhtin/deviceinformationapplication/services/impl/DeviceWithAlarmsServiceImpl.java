package com.akukhtin.deviceinformationapplication.services.impl;

import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.dto.util.Converter;
import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import com.akukhtin.deviceinformationapplication.repository.DeviceWithAlarmsRepository;
import com.akukhtin.deviceinformationapplication.services.DeviceWithAlarmsService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeviceWithAlarmsServiceImpl implements DeviceWithAlarmsService {

  private final DeviceWithAlarmsRepository deviceWithAlarmsRepository;

  public DeviceWithAlarmsServiceImpl(DeviceWithAlarmsRepository deviceWithAlarmsRepository) {
    this.deviceWithAlarmsRepository = deviceWithAlarmsRepository;
  }

  @Override
  public DeviceWithAlarms create(DeviceWithAlarmsDto deviceWithAlarmsDto) {
    DeviceWithAlarms deviceWithAlarms =
            getConverterDeviceWithAlarmsDtoToDeviceWithAlarms(deviceWithAlarmsDto);
    log.info("Start processing with save to data base");
    DeviceWithAlarms saveDeviceWithAlarms = getSave(deviceWithAlarms);
    log.info("Save was successful");
    return saveDeviceWithAlarms;
  }

  @Override
  public List<DeviceWithAlarmsDto> findAllByDateOfLastContactBefore(
          LocalDateTime dateOfLastContact) {
    List<DeviceWithAlarms> allByDateOfLastContactBefore =
            getAllByDateOfLastContactBefore(dateOfLastContact);

    return allByDateOfLastContactBefore
            .stream()
            .map(Converter::converterDeviceWithAlarmsToDeviceWithAlarmsDto)
            .collect(Collectors.toList());
  }

  @Override
  public List<DeviceWithAlarmsDto> findAllByCurrentVolumeIndicatorsDifferentLessThan(
          Double currentVolumeIndicatorsDifferent) {
    List<DeviceWithAlarms> deviceWithAlarmsList =
            getAllByCurrentVolumeIndicatorsDifferentLessThan(currentVolumeIndicatorsDifferent);

    return  deviceWithAlarmsList
            .stream()
            .map(Converter::converterDeviceWithAlarmsToDeviceWithAlarmsDto)
            .collect(Collectors.toList());
  }


  private List<DeviceWithAlarms>
  getAllByCurrentVolumeIndicatorsDifferentLessThan(Double currentVolumeIndicatorsDifferent) {
    return deviceWithAlarmsRepository
            .findAllByCurrentVolumeIndicatorsDifferentLessThan(currentVolumeIndicatorsDifferent);
  }

  private List<DeviceWithAlarms> getAllByDateOfLastContactBefore(LocalDateTime dateOfLastContact) {
    return deviceWithAlarmsRepository
            .findAllByDateOfLastContactBefore(dateOfLastContact);
  }

  private DeviceWithAlarms getSave(DeviceWithAlarms deviceWithAlarms) {
    log.info("Start processing with save to data base");
    return deviceWithAlarmsRepository.save(deviceWithAlarms);
  }

  private DeviceWithAlarms getConverterDeviceWithAlarmsDtoToDeviceWithAlarms(
          DeviceWithAlarmsDto deviceWithAlarmsDto) {
    log.info("Start process with converting DeviceDto to Device ");
    return Converter.converterDeviceWithAlarmsDtoToDeviceWithAlarms(deviceWithAlarmsDto);
  }
}
