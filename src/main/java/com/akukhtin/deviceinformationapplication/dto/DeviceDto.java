package com.akukhtin.deviceinformationapplication.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceDto {
  private Long id;
  private Integer serialNumber;
  private Integer manufacturerType;
  private Integer deviceType;
  private String dateOfLastContact;
  private Double currentVolumeIndicators;
}
