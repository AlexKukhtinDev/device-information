package com.akukhtin.deviceinformationapplication.services.impl;

import com.akukhtin.deviceinformationapplication.dto.DeviceDto;
import com.akukhtin.deviceinformationapplication.dto.util.Converter;
import com.akukhtin.deviceinformationapplication.entity.Device;
import com.akukhtin.deviceinformationapplication.repository.DeviceRepository;

import com.akukhtin.deviceinformationapplication.services.DeviceService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService {

  private final DeviceRepository deviceRepository;

  public DeviceServiceImpl(DeviceRepository deviceRepository) {
    this.deviceRepository = deviceRepository;
  }

  @Override
  public Optional<Device> create(DeviceDto deviceDto) {
    Device converterDeviceDtoToDevice = getConverterDeviceDtoToDevice(deviceDto);
    log.info("Was successful converting DeviceDto to Device ");
    log.info("Start processing with save to data base");
    Device saveDevice = getSave(converterDeviceDtoToDevice);
    log.info("Save was successful");
    return Optional.of(saveDevice);
  }

  private Device getSave(Device converterDeviceDtoToDevice) {
    return deviceRepository.save(converterDeviceDtoToDevice);
  }

  private Device getConverterDeviceDtoToDevice(DeviceDto deviceDto) {
    log.info("Start process with converting DeviceDto to Device ");
    return Converter.converterDeviceDtoToDevice(deviceDto);
  }
}
