package me.fru1t.whatever;

import java.util.ArrayList;

public class PreVsPostIncrementDecrementTest {
	private static final int TEST_ITERATIONS = 1000;
	private static final int COMPOUND_ITERATIONS = 1000000;
	
	public static void main(String[] args) {
		/**
		 * This program tests the difference between {pre, post} {increment, decrement}.
		 * The main take away is to see if pre or post is faster (regardless of incrementing or decrementing).
		 */
		
		long startTime = 0;
		long endTime = 0;
	
		// As a single increment or decrement takes too little time to calculate by itself, I use
		// compoundIteration to do sum a number of increment/decrements and record that value.
		int testIteration, compoundIteration, testSubject;
		
		
		// Pre testing
		System.out.println("Pre decrement test");
		ArrayList<Long> preDecrementResults = new ArrayList<>();
		for (testIteration = 0; testIteration < TEST_ITERATIONS; testIteration++) {
			startTime = System.nanoTime();
			for (compoundIteration = 0; compoundIteration < COMPOUND_ITERATIONS; compoundIteration++) {
				for (testSubject = Integer.MAX_VALUE; testSubject > 0; --testSubject) {} // <-- test for loop pre-decrements
			}
			endTime = System.nanoTime();
			preDecrementResults.add(endTime - startTime);
		}
		
		System.out.println("Pre increment test");
		ArrayList<Long> preIncrementResults = new ArrayList<>();
		for (testIteration = 0; testIteration < TEST_ITERATIONS; testIteration++) {
			startTime = System.nanoTime();
			for (compoundIteration = 0; compoundIteration < COMPOUND_ITERATIONS; compoundIteration++) {
				for (testSubject = 0; testSubject < Integer.MAX_VALUE; ++testSubject) {} // <-- test for loop pre-increments
			}
			endTime = System.nanoTime();
			preIncrementResults.add(endTime - startTime);
		}
		
		// Post testing
		System.out.println("Post decrement test");
		ArrayList<Long> postDecrementResults = new ArrayList<>();
		for (testIteration = 0; testIteration < TEST_ITERATIONS; testIteration++) {
			startTime = System.nanoTime();
			for (compoundIteration = 0; compoundIteration < COMPOUND_ITERATIONS; compoundIteration++) {
				for (testSubject = Integer.MAX_VALUE; testSubject > 0; testSubject--) {} // <-- test for loop post-decrements
			}
			endTime = System.nanoTime();
			postDecrementResults.add(endTime - startTime);
		}
		
		System.out.println("Post increment test");
		ArrayList<Long> postIncrementResults = new ArrayList<>();
		for (testIteration = 0; testIteration < TEST_ITERATIONS; testIteration++) {
			startTime = System.nanoTime();
			for (compoundIteration = 0; compoundIteration < COMPOUND_ITERATIONS; compoundIteration++) {
				for (testSubject = 0; testSubject < Integer.MAX_VALUE; testSubject++) {} // <-- test for loop post-increments
			}
			endTime = System.nanoTime();
			postIncrementResults.add(endTime - startTime);
		}
		
		
		// Results

		System.out.println();
		double result = 0;
		
		result = 0;
		for (long l : preDecrementResults) {
			result += 1.0 * l / preDecrementResults.size();
		}
		System.out.println("pre decrement average:\t" + result + "ns for " + COMPOUND_ITERATIONS + " calculations");

		result = 0;
		for (long l : postDecrementResults) {
			result += 1.0 * l / postDecrementResults.size();
		}
		System.out.println("post decrement average:\t" + result + "ns for " + COMPOUND_ITERATIONS + " calculations");
		
		System.out.println();
		
		result = 0;
		for (long l : preIncrementResults) {
			result += 1.0 * l / preIncrementResults.size();
		}
		System.out.println("pre increment average:\t" + result + "ns for " + COMPOUND_ITERATIONS + " calculations");
		
		result = 0;
		for (long l : postIncrementResults) {
			result += 1.0 * l / postIncrementResults.size();
		}
		System.out.println("post increment average:\t" + result + "ns for " + COMPOUND_ITERATIONS + " calculations");
	}
	
}
