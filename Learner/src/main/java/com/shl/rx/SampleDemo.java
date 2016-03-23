package com.shl.rx;

import java.util.List;

import rx.Observable;

public class SampleDemo {

	/**
	 * This method demonstrate Observable of RxJava with simple observer. 
	 * There are three term for RxJava 
	 * <li> Observable :: which monitors the stream or resource
 	 * <li> Subscribe  :: subscribe is used to create so that later we can un-subscribe if not required
	 * <li> Observer   :: once event finish then observer has to handle it, it has three method onNext, onError, onComplete
	 */
	public void itterateArrayListUsingRxJava(List<String> itemList) {
		//Using from method we can create Observable object with various data structure
		Observable<String> observableString = Observable.from(itemList);
		observableString.subscribe(new SampleObserver());
	}
	
	/**
	 * This method demonstrate Observable of RxJava with java8 feature 
	 *  <li> functional Interface
	 *  <li> Lambda Expression
	 *  <li> Method reference
	 * @param itemList
	 */
	public void ittrateArrayUsingRxJava8(List<String> itemList){
		Observable<String> observableString = Observable.from(itemList);
		/*
		 * WOW look at below, All actions required for Observable can be metioned using lambda expression in java8
		 */
		observableString.subscribe( 
				System.out::println, //this is method reference in java8 functional interface
				e -> System.out.println("Error.."), //Lambda expression to pass argument
				() -> System.out.println("Completed..") //Lambda expression for non argument method
				);
	}

}
