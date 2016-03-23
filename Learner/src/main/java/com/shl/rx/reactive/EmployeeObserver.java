package com.shl.rx.reactive;

import rx.Observer;

public class EmployeeObserver implements Observer<Employee>{

	@Override
	public void onCompleted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNext(Employee emp) {
		System.out.println(emp.getName() + " : " + emp.getSalary());
	}

}
