package com.akukhtin.deviceinformationapplication.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceWithAlarmsDto {

  private LocalDate dateOfLastContact;
  private Double currentVolumeIndicatorsDifferent;
}
