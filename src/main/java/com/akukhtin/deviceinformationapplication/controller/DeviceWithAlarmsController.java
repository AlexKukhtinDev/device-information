package com.akukhtin.deviceinformationapplication.controller;

import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import com.akukhtin.deviceinformationapplication.services.DeviceWithAlarmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device-with-alarms/")
public class DeviceWithAlarmsController {

  private final DeviceWithAlarmsService deviceWithAlarmsService;

  public DeviceWithAlarmsController(DeviceWithAlarmsService deviceWithAlarmsService) {
    this.deviceWithAlarmsService = deviceWithAlarmsService;
  }

  @PostMapping("devices-with-alarms")
  public ResponseEntity<DeviceWithAlarms> create(
          @RequestBody DeviceWithAlarmsDto deviceWithAlarmsDto) {
    return ResponseEntity.ok(deviceWithAlarmsService.create(deviceWithAlarmsDto));
  }
}
