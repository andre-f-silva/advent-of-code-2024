package premiumminds;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Day4_1 {

	public static void main(String[] args) {

		String filePath = "challenges/src/main/resources/day4.txt";

		try (Scanner scanner = new Scanner(new File(filePath))) {

			final AtomicInteger result = new AtomicInteger();

			ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				ArrayList<Character> row = new ArrayList<>();
				for (int i = 0; i < line.length(); i++) {
					row.add(line.charAt(i));
				}
				matrix.add(row);
			}

			for (int i = 0; i < matrix.size(); i++) {
				for (int j = 0; j < matrix.get(i).size(); j++) {
					 Character c = matrix.get(i).get(j);
					 if (c == 'X') {
						 result.addAndGet(searchXMAS(i, j, matrix));
					 }
				}
			}

			System.out.println(result.get());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int searchXMAS(int i, int j, ArrayList<ArrayList<Character>> matrix) {

		final String xmas = "XMAS";
		return Arrays.stream(DIRECTION.values()).map(direction -> searchXMAS(i, j, direction, matrix, xmas)).reduce(
			Integer::sum).orElseThrow();
	}

	private static int searchXMAS(int i, int j, DIRECTION direction, ArrayList<ArrayList<Character>> matrix, String remainingLetters) {

		if (remainingLetters.isEmpty()) {
			return 1;
		}

		try {
			final Character currentLetter = matrix.get(i).get(j);
			if (!currentLetter.equals(remainingLetters.charAt(0))) {
				return 0;
			}
		} catch (IndexOutOfBoundsException e) {
			return 0;
		}

		return switch (direction) {
			case UP_LEFT -> searchXMAS(i - 1, j - 1, direction, matrix, remainingLetters.substring(1));
			case UP -> searchXMAS(i - 1, j, direction, matrix, remainingLetters.substring(1));
			case UP_RIGHT -> searchXMAS(i - 1, j + 1, direction, matrix, remainingLetters.substring(1));
			case RIGHT -> searchXMAS(i, j + 1, direction, matrix, remainingLetters.substring(1));
			case DOWN_RIGHT -> searchXMAS(i + 1, j + 1, direction, matrix, remainingLetters.substring(1));
			case DOWN -> searchXMAS(i + 1, j, direction, matrix, remainingLetters.substring(1));
			case DOWN_LEFT -> searchXMAS(i + 1, j - 1, direction, matrix, remainingLetters.substring(1));
			case LEFT -> searchXMAS(i, j - 1, direction, matrix, remainingLetters.substring(1));
		};
	}

	enum DIRECTION {
		UP_LEFT, UP, UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT
	}

}
