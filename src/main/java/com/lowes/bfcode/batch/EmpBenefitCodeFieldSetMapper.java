package com.lowes.bfcode.batch;


import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.lowes.bfcode.batch.model.EmpBenefitCode;

public class EmpBenefitCodeFieldSetMapper implements FieldSetMapper<EmpBenefitCode>{

	@Override
	public EmpBenefitCode mapFieldSet(FieldSet fieldSet) throws BindException {
		EmpBenefitCode result = new EmpBenefitCode();
		result.setUsersId(Integer.parseInt(fieldSet.readString(0)));
		result.setEmpNumber(fieldSet.readString(3));
		return result;
	}

}
