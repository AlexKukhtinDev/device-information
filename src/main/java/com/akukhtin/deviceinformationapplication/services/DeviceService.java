package com.akukhtin.deviceinformationapplication.services;

import com.akukhtin.deviceinformationapplication.dto.DeviceDto;
import com.akukhtin.deviceinformationapplication.entity.Device;

public interface DeviceService {
  Device create (DeviceDto deviceDto);
  DeviceDto findById(Long id);
}
