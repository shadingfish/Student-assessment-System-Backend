package com.babybus.wangdy55.model.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SummaryRecordDto extends EvalRecordDto {
    StudentDto student;
}
