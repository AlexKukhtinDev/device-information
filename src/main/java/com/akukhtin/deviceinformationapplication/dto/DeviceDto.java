package com.akukhtin.deviceinformationapplication.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {
  private Integer serialNumber;
  private Integer manufacturerType;
  private Integer deviceType;
  private LocalDate dateOfLastContact;
  private Double currentVolumeIndicators;
}
