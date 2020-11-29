package com.akukhtin.deviceinformationapplication.controller;

import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import com.akukhtin.deviceinformationapplication.services.DeviceWithAlarmsService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device-with-alarms")
public class DeviceWithAlarmsController {

  private final DeviceWithAlarmsService deviceWithAlarmsService;

  public DeviceWithAlarmsController(DeviceWithAlarmsService deviceWithAlarmsService) {
    this.deviceWithAlarmsService = deviceWithAlarmsService;
  }

  @GetMapping("/{hours}")
  public ResponseEntity<List<DeviceWithAlarmsDto>> getDevicesWithAlarms(@PathVariable Long hours) {
    return ResponseEntity
            .ok(
                    deviceWithAlarmsService.findAllByDateOfLastContactBefore(
                            LocalDateTime.now().minusHours(hours)));
  }

  @GetMapping("/{currentVolumeIndicators}")
  public ResponseEntity<List<DeviceWithAlarmsDto>>
  findAllByCurrentVolumeIndicatorsDifferentLessThan(
          @PathVariable Double currentVolumeIndicators) {
    return ResponseEntity
            .ok(deviceWithAlarmsService
                    .findAllByCurrentVolumeIndicatorsDifferentLessThan(currentVolumeIndicators));
  }
}
