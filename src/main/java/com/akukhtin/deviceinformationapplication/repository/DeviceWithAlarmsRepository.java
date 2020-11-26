package com.akukhtin.deviceinformationapplication.repository;

import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceWithAlarmsRepository extends JpaRepository<DeviceWithAlarms, Long> {
}
