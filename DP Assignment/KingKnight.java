package com.bayviewglen.assignment;

public class KingKnight {
	public static void main(String[] args) {
		int size = 100;
		int[] start = { 0, 0 };
		int[] end = { 0, 99 };
		int moves = 50;
		System.out.println(countPaths(size, moves, start, end));

	}

	private static int countPaths(int size, int moves, int[] start, int[] end) {
		int[][][] board = new int[size][size][moves];
		// list all king-knight moves
		int[][] allMoves = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
				{ 2, 1 }, { 1, 2 }, { -2, 1 }, { 2, -1 }, { -2, -1 }, { -1, 2 }, { -1, -2 }, { 1, -2 } };

		int numMoves = 16;
		board[start[0]][start[1]][0] = 1;

		for (int i = 1; i <= moves; i++) {
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					for (int j = 0; j < numMoves; j++) {
						// king-knight's new row after move
						int newRow = r + allMoves[j][0];
						// king-knight's new column after move
						int newColumn = c + allMoves[j][1];
						// Check if the piece is still on the board after the
						// move
						if (newRow >= 0 && newRow < size && newColumn >= 0 && newColumn < size) {
							board[newRow][newColumn][i] += board[r][c][i - 1];
						}
					}
				}
			}
		}
		return board[end[0]][end[1]][moves];
	}

}
