package com.akukhtin.deviceinformationapplication.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceWithAlarmsDto {
  @NotNull
  @NotEmpty
  private Integer serialNumber;
  @NotNull
  @NotEmpty
  private Integer manufacturerType;
  @NotNull
  @NotEmpty
  private Integer deviceType;
  @NotNull
  @NotEmpty
  private LocalDateTime dateOfLastContact;
  @NotNull
  @NotEmpty
  private Double currentVolumeIndicators;
  @NotNull
  @NotEmpty
  private String alarm;
}
