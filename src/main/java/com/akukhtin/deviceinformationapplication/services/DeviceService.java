package com.akukhtin.deviceinformationapplication.services;

import com.akukhtin.deviceinformationapplication.dto.DeviceDto;
import com.akukhtin.deviceinformationapplication.entity.Device;
import java.util.Optional;

public interface DeviceService {
  Device create (DeviceDto deviceDto);
}
