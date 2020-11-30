package com.akukhtin.deviceinformationapplication.repository;

import com.akukhtin.deviceinformationapplication.entity.Device;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
  Device findBySerialNumber(Integer serialNumber);

  List<Device> findAllBySerialNumberAndDateOfLastContactBefore(
          Integer serialNumber, LocalDateTime dateOfLastContact);

  List<Device> findAllBySerialNumberAndCurrentVolumeIndicatorsIsLessThan(
          Integer serialNumber, Double currentVolumeIndicators);
}
