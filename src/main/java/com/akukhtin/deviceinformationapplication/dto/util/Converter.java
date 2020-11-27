package com.akukhtin.deviceinformationapplication.dto.util;

import com.akukhtin.deviceinformationapplication.dto.DeviceDto;
import com.akukhtin.deviceinformationapplication.dto.DeviceWithAlarmsDto;
import com.akukhtin.deviceinformationapplication.entity.Device;
import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import java.time.LocalDate;

// It is a simple mapper
public class Converter {

  public static Device converterDeviceDtoToDevice(DeviceDto deviceDto) {
    Device newDevice = new Device();
    newDevice.setSerialNumber(deviceDto.getSerialNumber());
    newDevice.setManufacturerType(deviceDto.getManufacturerType());
    newDevice.setDeviceType(deviceDto.getDeviceType());
    newDevice.setDateOfLastContact();
    newDevice.setCurrentVolumeIndicators(deviceDto.getCurrentVolumeIndicators());
    return newDevice;
  }

  public static DeviceWithAlarms converterDeviceWithAlarmsDtoToDeviceWithAlarms(
          DeviceWithAlarmsDto deviceWithAlarmsDto) {
    DeviceWithAlarms newDeviceWithAlarms = new DeviceWithAlarms();
    newDeviceWithAlarms.setDateOfLastContact(deviceWithAlarmsDto.getDateOfLastContact());
    newDeviceWithAlarms.setCurrentVolumeIndicatorsDifferent(
            deviceWithAlarmsDto.getCurrentVolumeIndicatorsDifferent());
    return newDeviceWithAlarms;
  }

}
