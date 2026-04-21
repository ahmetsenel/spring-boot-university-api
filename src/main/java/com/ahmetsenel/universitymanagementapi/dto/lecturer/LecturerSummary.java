package com.ahmetsenel.universitymanagementapi.dto.lecturer;

import com.ahmetsenel.universitymanagementapi.dto.SummaryDto;
import lombok.Data;

@Data
public class LecturerSummary extends SummaryDto {

    private String title;

    private String firstName;

    private String lastName;

    private String email;
}
