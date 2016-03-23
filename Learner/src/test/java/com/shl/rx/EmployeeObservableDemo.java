package com.shl.rx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.shl.rx.reactive.Employee;
import com.shl.rx.reactive.SalaryCalculation;

public class EmployeeObservableDemo {

	SalaryCalculation sc=new SalaryCalculation();
	
	@Test
	public void testNonReactiveExample() {
		List<Employee> employes=Collections.synchronizedList(new ArrayList<Employee>());
		try {
			sc.nonReactiveExample(employes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReactiveExample() {
		List<Employee> employes=Collections.synchronizedList(new ArrayList<Employee>());
		try {
			sc.reactiveExample(employes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void reactiveExampleUsingObservable() {
		List<Employee> employes=Collections.synchronizedList(new ArrayList<Employee>());
		try {
			sc.reactiveExampleUsingObservable(employes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
