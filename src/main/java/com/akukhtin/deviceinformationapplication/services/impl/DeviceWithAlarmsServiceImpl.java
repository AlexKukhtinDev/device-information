package com.akukhtin.deviceinformationapplication.services.impl;

import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.dto.util.Converter;
import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import com.akukhtin.deviceinformationapplication.repository.DeviceWithAlarmsRepository;
import com.akukhtin.deviceinformationapplication.services.DeviceWithAlarmsService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DeviceWithAlarmsServiceImpl implements DeviceWithAlarmsService {

  private final DeviceWithAlarmsRepository deviceWithAlarmsRepository;
  @Value(value = "${alarm}")
  private String alarm;

  public DeviceWithAlarmsServiceImpl(DeviceWithAlarmsRepository deviceWithAlarmsRepository) {
    this.deviceWithAlarmsRepository = deviceWithAlarmsRepository;
  }

  @Override
  public List<DeviceWithAlarmsDto> findAllByAlarm(String alarmEnum) {
    List<DeviceWithAlarms> allByAlarm = deviceWithAlarmsRepository.findAllByAlarm(alarm);
    return allByAlarm
            .stream()
            .map(Converter::converterDeviceWithAlarmsToDeviceWithAlarmsDto)
            .collect(Collectors.toList());
  }
}
