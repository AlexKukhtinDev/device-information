package com.akukhtin.deviceinformationapplication.controller;

import com.akukhtin.deviceinformationapplication.dto.DeviceDto;
import com.akukhtin.deviceinformationapplication.services.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device/")
public class DeviceController {
  private final DeviceService deviceService;

  public DeviceController(DeviceService deviceService) {
    this.deviceService = deviceService;
  }

  @GetMapping("/{serialNumber}")
  public ResponseEntity<DeviceDto> getCurrentDevice(@PathVariable Integer serialNumber) {
    return ResponseEntity.ok(deviceService.findBySerialNumber(serialNumber));
  }
}
