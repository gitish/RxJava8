package com.shl.rx.reactive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import rx.Observable;

public class SalaryCalculation {
	
	private BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
	private Employee emp= null;
	private String name=null;
	private long salary=0;
	
	/**
	 * This method demonstrate non reactive programming with java8 lambda expression feature
	 * @throws IOException 
	 */
	public void nonReactiveExample(List<Employee> employes) throws IOException{
		System.out.println("Non Reactive::Change is not propgated");
		while(true){
			System.out.println("Enter your name (exit to stop):");
			name=bufferedReader.readLine();
			if(name.equalsIgnoreCase("exit"))break;
			else if(name.isEmpty())continue;
			System.out.println("Enter your salary:");
			try{
				salary=Long.valueOf(bufferedReader.readLine());
			}catch(NumberFormatException e){continue;}
			emp=new Employee(name, salary);
			if(!employes.contains(emp))employes.add(emp);
			//java8 feature to use map and collector
			System.out.println("Total Salary :: " + employes.stream().mapToLong(x->x.getSalary()).sum());
			System.out.println("--------------------");
		}
	}
	
	/**
	 * This method demonstrate reactive programming with java8 features
	 * @throws IOException 
	 */
	public void reactiveExample(List<Employee> employes) throws IOException{
		System.out.println("Reactive::Change get propgated");
		while(true){
			System.out.println("Enter your name (exit to stop):");
			name=bufferedReader.readLine();
			if(name.equalsIgnoreCase("exit"))break;
			else if(name.isEmpty())continue;
			System.out.println("Enter your salary:");
			try{
				salary=Long.valueOf(bufferedReader.readLine());
			}catch(NumberFormatException e){continue;}
			emp=new Employee(name, salary);
			if(!employes.contains(emp))employes.add(emp);
			else employes.get(employes.indexOf(emp)).setSalary(emp.getSalary());
			
			//java8 Stream, lambdaExpression, forEach, flatmap, methodReference feature
			employes.stream() // stream feature
					.map(x -> x.getName() + ":" + x.getSalary()) //flat map and lambda expression
					.forEach(System.out::println); // foreach and method reference
			
			//java8 feature to use map and collector
			System.out.println("Total Salary :: " + employes.stream().mapToLong(x -> x.getSalary()).sum());
			System.out.println("--------------------");
		}
	}
	
	/**
	 * This method demonstrate reactive programming with java8 features
	 * @throws IOException 
	 */
	public void reactiveExampleUsingObservable(List<Employee> employes) throws IOException{
		Observable<Employee> employeeObservable = Observable.from(employes);
		EmployeeObserver employeeObserver = new EmployeeObserver();
		System.out.println("Reactive & RxJava ::Change get propgated");
		while(true){
			System.out.println("Enter your name (exit to stop):");
			name=bufferedReader.readLine();
			if(name.equalsIgnoreCase("exit"))break;
			else if(name.isEmpty())continue;
			System.out.println("Enter your salary:");
			try{
				salary=Long.valueOf(bufferedReader.readLine());
			}catch(NumberFormatException e){continue;}
			emp=new Employee(name, salary);
			if(!employes.contains(emp))employes.add(emp);
			else employes.get(employes.indexOf(emp)).setSalary(emp.getSalary());
			
			//check how this is iterating.. it is happening through RxJava
			employeeObservable.subscribe(employeeObserver);
			
			//java8 feature to use map and collector
			System.out.println("Total Salary :: " + employes.stream().mapToLong(x -> x.getSalary()).sum());
			System.out.println("--------------------");
		}
	}
}
