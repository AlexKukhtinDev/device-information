package com.akukhtin.deviceinformationapplication.services;

import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import java.time.LocalDateTime;
import java.util.List;

public interface DeviceWithAlarmsService {
  DeviceWithAlarms create(DeviceWithAlarmsDto deviceWithAlarmsDto);

  List<DeviceWithAlarmsDto> findAllByDateOfLastContactBefore(LocalDateTime dateOfLastContact);

  List<DeviceWithAlarmsDto> findAllByCurrentVolumeIndicatorsDifferentLessThan(Double currentVolumeIndicatorsDifferent);
}
