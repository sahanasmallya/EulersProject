package com.assessment.eulerproject.sumSquares;

public class SumSquareDifference {

	public static void main(String[] s){
		int n = 100;
		int sum = 0;
		int squareOfSums =  1;
		int sumofSquares = 0;
		for(int i=1;i<=n;i++){
			sum = sum+i;
			sumofSquares = sumofSquares +(i*i);
		}
		squareOfSums =  sum*sum;
		
		System.out.println( squareOfSums - sumofSquares);
	}
}
