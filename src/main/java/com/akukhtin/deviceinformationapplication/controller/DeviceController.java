package com.akukhtin.deviceinformationapplication.controller;

import com.akukhtin.deviceinformationapplication.dto.DeviceDto;
import com.akukhtin.deviceinformationapplication.entity.Device;
import com.akukhtin.deviceinformationapplication.services.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device/")
public class DeviceController {
  private final DeviceService deviceService;

  public DeviceController(DeviceService deviceService) {
    this.deviceService = deviceService;
  }

  @PostMapping("devices")
  public ResponseEntity<Device> create(@RequestBody DeviceDto deviceDto) {
    return ResponseEntity.ok(deviceService.create(deviceDto));
  }
}
