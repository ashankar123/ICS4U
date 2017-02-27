package com.bayviewglen.assignment;

public class ZigZag {
	public static void main(String[] args) {
		int[] seq = { 10, 50, 900, 201, 201, 150, 378 };

		int longestZigZag = runZigZag(seq);
		System.out.println(longestZigZag);
	}

	private static int runZigZag(int[] seq) {
		if (seq.length <= 2) {
			return seq.length;
		}

		// creating an array for increasing numbers and decreasing numbers
		int[] inc = new int[seq.length];
		int[] dec = new int[seq.length];
		boolean ascending = false;
		inc[0] = 1;
		inc[1] = 2;
		dec[0] = 1;
		dec[1] = 2;

		// Determine which array to use
		if (seq[0] < seq[1]) {
			ascending = false;
		} else if (seq[0] > seq[1]) {
			ascending = true;
		}

		for (int i = 2; i < seq.length; ++i) {
			if (ascending) {
				if (seq[i] > seq[i - 1]) {
					inc[i] = Math.max(inc[i - 1], dec[i - 1]) + 1;
					dec[i] = inc[i];
					ascending = false;
				} else if (seq[i] <= seq[i - 1]) {
					inc[i] = Math.max(inc[i - 1], dec[i - 1]);
					dec[i] = Math.max(inc[i - 1], dec[i - 1]);
				}
			} else if (!ascending) {
				if (seq[i] >= seq[i - 1]) {
					dec[i] = Math.max(inc[i - 1], dec[i - 1]);
					inc[i] = Math.max(inc[i - 1], dec[i - 1]);
				} else if (seq[i] < seq[i - 1]) {
					dec[i] = Math.max(inc[i - 1], dec[i - 1]) + 1;
					inc[i] = dec[i];
					ascending = true;
				}
			}
		}
		//return whichever seq length greater
		return Math.max(inc[inc.length - 1], dec[dec.length - 1]);
	}

}
