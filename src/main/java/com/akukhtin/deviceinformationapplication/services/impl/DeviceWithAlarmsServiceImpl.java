package com.akukhtin.deviceinformationapplication.services.impl;

import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.dto.util.Converter;
import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import com.akukhtin.deviceinformationapplication.repository.DeviceWithAlarmsRepository;
import com.akukhtin.deviceinformationapplication.services.DeviceWithAlarmsService;
import java.util.Optional;
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
  public Optional<DeviceWithAlarms> create(DeviceWithAlarmsDto deviceWithAlarmsDto) {
    DeviceWithAlarms deviceWithAlarms =
            getConverterDeviceWithAlarmsDtoToDeviceWithAlarms(deviceWithAlarmsDto);
    log.info("Start processing with save to data base");
    DeviceWithAlarms saveNewDeviceWithAlarms = getSave(deviceWithAlarms);
    log.info("Save was successful");
    return Optional.of(saveNewDeviceWithAlarms);
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
