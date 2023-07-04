package com.babybus.wangdy55.model.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class VolunteerRecordDto extends EvalRecordDto {
    StudentDto student;
}
