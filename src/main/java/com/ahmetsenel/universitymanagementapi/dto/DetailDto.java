package com.ahmetsenel.universitymanagementapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DetailDto {

    private Long id;

    private LocalDateTime createdAt;
}
