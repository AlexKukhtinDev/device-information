package com.akukhtin.deviceinformationapplication.repository;

import com.akukhtin.deviceinformationapplication.entity.DeviceWithAlarms;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceWithAlarmsRepository extends JpaRepository<DeviceWithAlarms, Long> {
  List<DeviceWithAlarms> findAllByDateOfLastContactBefore(LocalDateTime dateOfLastContact);

  List<DeviceWithAlarms> findAllByCurrentVolumeIndicatorsDifferentLessThan(Double currentVolumeIndicatorsDifferent);

}
