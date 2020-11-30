package com.akukhtin.deviceinformationapplication.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "devices")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Device {
  @Id
  @Column(name = "serial_number")
  // @Value(value = "${parameter.serialnumber}")
  private Integer serialNumber;
  @Column(name = "manufacturer_type")
  // @Value(value = "${parameter.manufacturerType}")
  private Integer manufacturerType;
  @Column(name = "device_type")
  // @Value(value = "${parameter.deviceType}")
  private Integer deviceType;
  @Column(name = "date_Of_Last_Contact")
  // @Value(value = "${parameter.dateOfLastContact}")
  private LocalDateTime dateOfLastContact;
  @Column(name = "current_Volume_Indicators")
  // @Value(value = "${parameter.currentVolumeIndicators}")
  private Double currentVolumeIndicators;
  @Column(name = "alarm")
  // @Value(value = "${alarm}")
  private String alarm;
}
