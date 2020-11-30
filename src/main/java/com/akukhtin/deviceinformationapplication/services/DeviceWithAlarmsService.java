package com.akukhtin.deviceinformationapplication.services;

import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import java.util.List;

public interface DeviceWithAlarmsService {
  List<DeviceWithAlarmsDto> findAllByAlarm(String alarmEnum);
}
