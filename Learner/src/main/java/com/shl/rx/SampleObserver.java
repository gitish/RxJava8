package com.shl.rx;

import rx.Observer;

public class SampleObserver implements Observer<String>{

	public void onCompleted() {
		System.out.println("Completed..");
	}

	public void onError(Throwable e) {
		System.out.println("Error occured..");
	}

	public void onNext(String t) {
		System.out.println(t);
	}

}
