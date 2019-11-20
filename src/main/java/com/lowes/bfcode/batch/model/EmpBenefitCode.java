package com.lowes.bfcode.batch.model;

public class EmpBenefitCode {
private Integer usersId;
private String empNumber;

public Integer getUsersId() {
	return usersId;
}
public void setUsersId(Integer usersId) {
	this.usersId = usersId;
}
public String getEmpNumber() {
	return empNumber;
}
public void setEmpNumber(String empNumber) {
	this.empNumber = empNumber;
}
@Override
public String toString() {
	return "EmpBenefitCode [usersId=" + usersId + ", empNumber=" + empNumber + "]";
}
}
