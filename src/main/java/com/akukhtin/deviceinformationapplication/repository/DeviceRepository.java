package com.akukhtin.deviceinformationapplication.repository;

import com.akukhtin.deviceinformationapplication.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
