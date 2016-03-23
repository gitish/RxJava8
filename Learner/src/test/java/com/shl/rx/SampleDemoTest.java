package com.shl.rx;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SampleDemoTest {

	List<String> counting = Arrays.asList("one","two","three","four","five","six","seven","eight","nine","ten");
	
	@Test
	public void itterateArrayListUsingRxJava() {
		System.out.println("Running by simple Observable");
		SampleDemo sampleDemo=new SampleDemo();
		sampleDemo.itterateArrayListUsingRxJava(counting);
	}
	
	@Test
	public void itterateArrayListUsingRxJava8() {
		System.out.println("Running by lambda expression");
		SampleDemo sampleDemo=new SampleDemo();
		sampleDemo.ittrateArrayUsingRxJava8(counting);
	}

}
