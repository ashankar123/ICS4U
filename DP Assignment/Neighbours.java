package com.bayviewglen.assignment;

public class Neighbours {
	public static void main(String[] args) {
		int[] donations = { 56, 50, 12, 21 };
		System.out.println(getMax(donations));
	}

	private static int getMax(int[] donations) {
		int size = donations.length;
		if (size == 2) {
			return Math.max(donations[0], donations[1]);
		}
		// making both arrays half in length. omit first donation in one array (a),
		// last in the other (b)
		int[] a = new int[size - 1];
		int[] b = new int[size - 1];
		int[] aSum = new int[size - 1];
		int[] bSum = new int[size - 1];

		for (int i = 0; i < size - 1; ++i) {
			a[i] = donations[i + 1];
		}
		for (int i = 0; i < size - 1; ++i) {
			b[i] = donations[i];
		}

		aSum[0] = a[0];
		aSum[1] = Math.max(aSum[0], a[1]);
		bSum[0] = b[0];
		bSum[1] = Math.max(bSum[0], b[1]);

		// Find max sum of the arrays w/out adjacent donations
		for (int i = 2; i < size - 1; i++) {
			aSum[i] = Math.max(aSum[i - 1], aSum[i - 2] + a[i]);
			bSum[i] = Math.max(bSum[i - 1], bSum[i - 2] + b[i]);
		}

		// Get bigger max sum & return
		int maxSum = Math.max(aSum[aSum.length - 1], bSum[bSum.length - 1]);

		return maxSum;

	}
}
