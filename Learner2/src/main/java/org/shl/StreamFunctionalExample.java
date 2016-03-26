package org.shl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * To understand Functional Programming we will take two example 
 * 	<li> find prime number </li>
 *  <li> Find the double of first even number grater than 3 </li>
 *  
 *  In this example we will show you to solve a problem in various way. 
 *  You yourself will be figure out which is the best way to do ...
 * @author sshail
 *
 */
public class StreamFunctionalExample {

	/**
	 * Legacy way to find prime number
	 * Imperative - Saying how & mutability
	 * @param number
	 * @return
	 */
	public static boolean isPrimeImperative(final int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return number > 1;
	}
	/**
	 * Declarative - Saying what
	 * Immutability
	 * @param number
	 * @return
	 */
	public static boolean isPrimeDeclarative(final int number) {
		return number > 1
				&& IntStream.range(2, number)
							.noneMatch(index -> number % index == 0);
	}

	/**
	 * Declarative - Saying what
	 * Lexical scoping
	 * @param number
	 * @return
	 */
	public static boolean isPrimeLexicalScoping(final int number) {
		IntPredicate isDivisible = divisor -> number % divisor == 0;
		return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);

	}

	/*
	 * Lets take another example to understand lambda expression Scenario is ::
	 * Find the double of first even number grater than 3
	 */
	public static int doubleOfFirstEvenGT3Traditional(List<Integer> values) {
		// Traditional way
		int result = 0;
		for (int e : values) {
			if (e > 3 && e % 2 == 0) {
				result = e * 2;
				break;
			}
		}
		return result;
	}
	
	
	/**
	 * See below example which demonstrate step by step approach to find a particular number
	 * @param values
	 * @return
	 */
	public static int doubleOfFirstEvenGT3Functional(List<Integer> values) {
		// functional style
		Optional<Integer> optionalResult = values.stream()
												.filter(e -> e > 3)
												.filter(e -> e % 2 == 0)
												.map(e -> e * 2).findFirst();
		return optionalResult.get();
	}

	public static boolean isGraterThan3(int number) {
		System.out.println("isGraterThan");
		return number > 3;
	}

	public static boolean isEven(int number) {
		System.out.println("isEven");
		return number % 2 == 0;
	}

	public static int doubleIt(int number) {
		System.out.println("doubleIt");
		return 2 * number;
	}
	/**
	 * More readable way to solve above situation, check why it is called lazy 
	 * because it is not mandatory that all above functional will be called for all number
	 * @param values
	 * @return
	 */
	public static int doubleOfFirstEvenGT3LazyFunctional(List<Integer> values) {
		// Higher order function
		// lazy && composition
		Optional<Integer> optionalResult = values.stream()
				.filter(StreamFunctionalExample::isGraterThan3)
				.filter(StreamFunctionalExample::isEven)
				.map(StreamFunctionalExample::doubleIt).findFirst();
		return optionalResult.get();
	}

	/**
	 * Example of stream
	 * 
	 * @param datas
	 * @return
	 */
	public long getEmptyElementCount(List<String> datas) {
		return datas.stream()
				    .filter(s -> s.isEmpty())
				    .count();
	}

	/**
	 * Example of parallel stream
	 * 
	 * @param datas
	 * @param match
	 * @return
	 */
	public long getCountOfStringWithMatchesString(List<String> datas,
			String match) {
		return datas.parallelStream()
				.filter(s -> s.toLowerCase().contains(match.toLowerCase()))
				.count();
	}

	/**
	 * Another example on parallel stream and filter
	 * 
	 * @param datas
	 * @return
	 */
	public String concatenateNonEmptyString(List<String> datas) {
		return datas.parallelStream()
				.filter(s -> !s.isEmpty())
				.collect(Collectors.joining(","));
	}

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(1, 2, 3, 5, 4, 6, 7);
		System.out.println(doubleOfFirstEvenGT3LazyFunctional(input));
	}

}
