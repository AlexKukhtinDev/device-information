package com.akukhtin.deviceinformationapplication.controller;

import com.akukhtin.deviceinformationapplication.dto.DeviceDto;
import com.akukhtin.deviceinformationapplication.entity.Device;
import com.akukhtin.deviceinformationapplication.services.DeviceService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device/")
public class DeviceController {
  @Autowired
  private DeviceService deviceService;

  @PostMapping("devices")
  public ResponseEntity<Optional<Device>> create(@RequestBody DeviceDto deviceDto) {
    Optional<Device> device = deviceService.create(deviceDto);
    return ResponseEntity.ok(device);
  }
}
