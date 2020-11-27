package com.akukhtin.deviceinformationapplication.services;

import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import java.util.Optional;

public interface DeviceWithAlarmsService {
  Optional<DeviceWithAlarms> create(DeviceWithAlarmsDto deviceWithAlarmsDto);
}