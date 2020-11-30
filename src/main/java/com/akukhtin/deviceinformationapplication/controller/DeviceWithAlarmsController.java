package com.akukhtin.deviceinformationapplication.controller;

import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.services.DeviceWithAlarmsService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device-with-alarms")
public class DeviceWithAlarmsController {

  private static final String ALARM = "ALARM";
  private final DeviceWithAlarmsService deviceWithAlarmsService;

  public DeviceWithAlarmsController(DeviceWithAlarmsService deviceWithAlarmsService) {
    this.deviceWithAlarmsService = deviceWithAlarmsService;
  }

  @GetMapping("/")
  public ResponseEntity<List<DeviceWithAlarmsDto>> findAllByAlarms() {
    return ResponseEntity.ok(deviceWithAlarmsService.findAllByAlarm(ALARM));
  }
}
