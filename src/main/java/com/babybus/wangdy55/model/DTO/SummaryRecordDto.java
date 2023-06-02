package com.babybus.wangdy55.model.DTO;

import com.babybus.common.model.user.Student;
import com.babybus.wangdy55.model.DTO.EvalRecordDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SummaryRecordDto extends EvalRecordDto {
    Student student;
}
