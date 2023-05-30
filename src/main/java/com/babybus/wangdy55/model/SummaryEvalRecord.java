package com.babybus.wangdy55.model;

import com.babybus.common.model.EvalRecord;
import com.babybus.common.model.user.Student;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SummaryEvalRecord extends EvalRecord {
//    Sum summary;
    Student student;
}
