package com.akukhtin.deviceinformationapplication.dto.util;

import com.akukhtin.deviceinformationapplication.dto.DeviceDto;
import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.entity.Device;
import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;

public class Converter {

  public static DeviceDto converterDeviceToDeviceDto(Device device) {
    return DeviceDto.builder()
            .serialNumber(device.getSerialNumber())
            .manufacturerType(device.getManufacturerType())
            .deviceType(device.getDeviceType())
            .dateOfLastContact(device.getDateOfLastContact())
            .currentVolumeIndicators(device.getCurrentVolumeIndicators())
            .alarm(device.getAlarm())
            .build();
  }

  public static DeviceWithAlarmsDto converterDeviceDtoToDeviceWithAlarms(DeviceDto deviceDto) {
    return DeviceWithAlarmsDto.builder()
            .serialNumber(deviceDto.getSerialNumber())
            .manufacturerType(deviceDto.getManufacturerType())
            .deviceType(deviceDto.getDeviceType())
            .dateOfLastContact(deviceDto.getDateOfLastContact())
            .currentVolumeIndicators(deviceDto.getCurrentVolumeIndicators())
            .alarm(deviceDto.getAlarm())
            .build();
  }

  public static DeviceWithAlarmsDto converterDeviceWithAlarmsToDeviceWithAlarmsDto(
          DeviceWithAlarms deviceWithAlarms) {
    return DeviceWithAlarmsDto
            .builder()
            .serialNumber(deviceWithAlarms.getSerialNumber())
            .manufacturerType(deviceWithAlarms.getManufacturerType())
            .deviceType(deviceWithAlarms.getDeviceType())
            .dateOfLastContact(deviceWithAlarms.getDateOfLastContact())
            .currentVolumeIndicators(deviceWithAlarms.getCurrentVolumeIndicators())
            .alarm(deviceWithAlarms.getAlarm())
            .build();
  }

  public static DeviceWithAlarms converterDeviceWithAlarmsDtoToDeviceWithAlarms(
          DeviceWithAlarmsDto deviceWithAlarmsDto) {
    DeviceWithAlarms deviceWithAlarms = new DeviceWithAlarms();
    deviceWithAlarms.setSerialNumber(deviceWithAlarmsDto.getSerialNumber());
    deviceWithAlarms.setManufacturerType(deviceWithAlarmsDto.getManufacturerType());
    deviceWithAlarms.setDeviceType(deviceWithAlarmsDto.getDeviceType());
    deviceWithAlarms.setDateOfLastContact(deviceWithAlarmsDto.getDateOfLastContact());
    deviceWithAlarms.setCurrentVolumeIndicators(deviceWithAlarms.getCurrentVolumeIndicators());
    deviceWithAlarms.setAlarm("Alarm");
    return deviceWithAlarms;
  }
}
