package com.bayviewglen.daythree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GPS {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("input/GPS.dat"));
		int a = Integer.parseInt(scanner.nextLine());
		double[][] setPoints = new double[a][2];

		for (int i = 0; i < setPoints.length; ++i) {
			setPoints[i][0] = Double.parseDouble(scanner.nextLine());
			setPoints[i][1] = Double.parseDouble(scanner.nextLine());
		}
		checkPoints(setPoints);
	}

	private static void checkPoints(double[][] setPoints) {
		double shortestDistance = Integer.MAX_VALUE;
		int p1 = -1, p2 = -1;

		for (int i = 0; i < setPoints.length; ++i) {
			for (int j = i + 1; j < setPoints.length - 1; ++j) {

				double x = setPoints[i][0] - setPoints[j][0];
				double y = setPoints[i][1] - setPoints[j][1];

				double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

				if (distance < shortestDistance) {
					shortestDistance = distance;
					p1 = i;
					p2 = j;

				}
			}
		}

		System.out.println("The closest two points are (" + setPoints[p1][0] + ", " + setPoints[p1][1] + ") and ("
				+ setPoints[p2][0] + ", " + setPoints[p2][1] + ")");
	}
}
