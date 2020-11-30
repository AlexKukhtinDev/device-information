package com.akukhtin.deviceinformationapplication.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "device_with_alarms")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceWithAlarms {
  @Id
  @Column(name = "serial_number")
  private Integer serialNumber;
  @Column(name = "manufacturer_type")
  private Integer manufacturerType;
  @Column(name = "device_type")
  private Integer deviceType;
  @Column(name = "date_Of_Last_Contact")
  private LocalDateTime dateOfLastContact;
  @Column(name = "current_Volume_Indicators")
  private Double currentVolumeIndicators;
  @Column(name = "alarm")
  private String alarm;
}
