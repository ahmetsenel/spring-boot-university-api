package com.ahmetsenel.universitymanagementapi.dto.student;

import com.ahmetsenel.universitymanagementapi.dto.SummaryDto;
import lombok.Data;

@Data
public class StudentSummary extends SummaryDto {

    private String firstName;

    private String lastName;

    private String studentNumber;
}
