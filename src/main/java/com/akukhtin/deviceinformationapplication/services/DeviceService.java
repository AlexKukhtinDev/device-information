package com.akukhtin.deviceinformationapplication.services;

import com.akukhtin.deviceinformationapplication.dto.DeviceDto;
import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import java.time.LocalDateTime;
import java.util.List;

public interface DeviceService {
  DeviceDto findBySerialNumber(Integer serialNumber);

  List<DeviceDto> findAllBySerialNumberAndDateOfLastContactBefore(
          Integer serialNumber, LocalDateTime dateOfLastContact);

  List<DeviceWithAlarmsDto> findAllBySerialNumberAndCurrentVolumeIndicatorsIsLessThan(
          Integer serialNumber, Double currentVolumeIndicators);
}
