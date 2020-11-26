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

@Entity(name = "device_with_alarms")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceWithAlarms {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "date_Of_Last_Contact")
  private LocalDate dateOfLastContact;
  @Column(name = "current_Volume_Indicators_Different")
  private Double currentVolumeIndicatorsDifferent;
}
