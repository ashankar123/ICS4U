package com.bayviewglen.daythree;

import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {
		boolean valid = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Sudoku puzzle solution:");
		int[][] sudoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String[] line = scanner.nextLine().split(" ");
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(line[j]);
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int currentValue = sudoku[i][j];
				for (int k = 0; k < 9; k++) {
					if (currentValue == sudoku[i][k] && k != j) {
						valid = false;
					}
				}
				for (int k = 0; k < 9; k++) {
					if (currentValue == sudoku[k][j] && i != k) {
						valid = false;
					}
				}
				int squareNumberX = i / 3;
				int squareNumberY = j / 3;
				int[][] sudokuThreeSquare = new int[3][3];
				int xcount = 0;
				int ycount = 0;
				for (int x = squareNumberX * 3; x < squareNumberX * 3 + 2; x++) {
					for (int y = squareNumberY * 3; y < squareNumberY * 3 + 2; y++) {
						sudokuThreeSquare[xcount][ycount] = sudoku[x][y];
						ycount++;
						if (ycount > 2) {
							ycount = 0;
						}
					}
					xcount++;
					if (xcount > 2) {
						xcount = 0;
					}
				}
				int hitcount = 0;
				for (int q = 0; q < 3; q++) {
					for (int r = 0; r < 3; r++) {
						if (currentValue == sudokuThreeSquare[q][r]) {
							hitcount++;
						}
					}
				}
				if (hitcount >= 2) {
					valid = false;
				}

			}
		}
		System.out.println(valid);

	}

}