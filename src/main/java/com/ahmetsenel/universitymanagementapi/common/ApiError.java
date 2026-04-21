package com.ahmetsenel.universitymanagementapi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<E> {

    private Integer status;

    private String path;

    private String timestamp;

    private E message;
}
