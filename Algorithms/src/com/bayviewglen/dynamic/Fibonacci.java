package com.bayviewglen.dynamic;

public class Fibonacci {
	static long[] solutions;

	public static void main(String[] args) {
		int n = 25;
		solutions = new long[n + 1];

		for (int i = 0; i <= n; ++i) {
			solutions[i] = -1;
		}
		System.out.println(solveFib(n));
	}

	private static long solveFib(int n) {
		if (solutions[n] != -1) {
			return solutions[n];
		}

		if (n == 1 || n == 2) {
			return 1;
		} else {
			solutions[n] = solveFib(n - 1) + solveFib(n - 2);
			return solutions[n];
		}
	}
}