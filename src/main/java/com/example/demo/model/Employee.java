package com.example.demo.model;

import lombok.Data;

//@Dataはlombokのアノテーション。getterやsetter,toStringのメゾッド等を自動で生成してくれる
@Data
public class Employee {
	private String employeeId;
	private String employeeName;
	private int employeeAge;

}
