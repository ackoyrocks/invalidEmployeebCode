package com.lowes.bfcode.batch.processor;


import org.springframework.batch.item.ItemProcessor;

import com.lowes.bfcode.batch.model.EmpBenefitCode;
public class BenefitCodeDBUpdItemProcessor implements ItemProcessor<EmpBenefitCode, EmpBenefitCode> {
int count=0;
	@Override
	public EmpBenefitCode process(EmpBenefitCode result) throws Exception {
			
			count++;
			System.out.println("Records : " + count);
			System.out.println("Updating DB , record for : "+ result);
		
			System.out.println();
			System.out.println();
			
			
			
		
			return result;
		}
	
}
