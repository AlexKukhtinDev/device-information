package com.akukhtin.deviceinformationapplication.dto.util;

import com.akukhtin.deviceinformationapplication.dto.DeviceDto;
import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.entity.Device;
import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Converter {

  public static Device converterDeviceDtoToDevice(DeviceDto deviceDto) {
    Device device = new Device();
    if (deviceDto.getId() != null) {
      device.setId(deviceDto.getId());
    }
    device.setSerialNumber(deviceDto.getSerialNumber());
    device.setManufacturerType(deviceDto.getManufacturerType());
    device.setDeviceType(deviceDto.getDeviceType());
    device.setDateOfLastContact(formatDate(deviceDto.getDateOfLastContact()));
    device.setCurrentVolumeIndicators(deviceDto.getCurrentVolumeIndicators());
    return device;
  }

  public static DeviceDto converterDeviceToDeviceDto(Device device) {
    return DeviceDto.builder()
            .id(device.getId())
            .serialNumber(device.getSerialNumber())
            .manufacturerType(device.getManufacturerType())
            .deviceType(device.getDeviceType())
            .dateOfLastContact(formatDate(device.getDateOfLastContact()))
            .currentVolumeIndicators(device.getCurrentVolumeIndicators())
            .build();
  }

  public static DeviceWithAlarms converterDeviceWithAlarmsDtoToDeviceWithAlarms(
          DeviceWithAlarmsDto deviceWithAlarmsDto) {
    DeviceWithAlarms deviceWithAlarms = new DeviceWithAlarms();
    deviceWithAlarms.setDateOfLastContact(deviceWithAlarmsDto.getDateOfLastContact());
    deviceWithAlarms.setCurrentVolumeIndicatorsDifferent(
            deviceWithAlarmsDto.getCurrentVolumeIndicatorsDifferent());
    return deviceWithAlarms;
  }

  public static DeviceWithAlarmsDto converterDeviceWithAlarmsToDeviceWithAlarmsDto(
          DeviceWithAlarms deviceWithAlarms) {
    return DeviceWithAlarmsDto
            .builder()
            .dateOfLastContact(deviceWithAlarms.getDateOfLastContact())
            .currentVolumeIndicatorsDifferent(
                    deviceWithAlarms.getCurrentVolumeIndicatorsDifferent())
            .build();
  }

  private static String formatDate(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
    LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
    return localDateTime.format(formatter);
  }

}
