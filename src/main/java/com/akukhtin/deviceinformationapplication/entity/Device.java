package com.akukhtin.deviceinformationapplication.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "serial_number")
  private Integer serialNumber;
  @Column(name = "manufacturer_type")
  private Integer manufacturerType;
  @Column(name = "device_type")
  private Integer deviceType;
  @Column(name = "date_Of_Last_Contact")
  private String dateOfLastContact;
  @Column(name = "current_Volume_Indicators")
  private Double currentVolumeIndicators;
}
