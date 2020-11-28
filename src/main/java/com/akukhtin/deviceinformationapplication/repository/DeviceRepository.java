package com.akukhtin.deviceinformationapplication.repository;

import com.akukhtin.deviceinformationapplication.entity.Device;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
  Optional<Device> findById(Long id);
}
