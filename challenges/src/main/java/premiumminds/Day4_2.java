package premiumminds;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Day4_2 {

	public static void main(String[] args) {

		String filePath = "challenges/src/main/resources/day4.txt";

		try (Scanner scanner = new Scanner(new File(filePath))) {

			final AtomicInteger result = new AtomicInteger();

			// parse character matrix without knowing the dimensions
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
					 if (c == 'A') {
						 result.addAndGet(searchCrossedXMAS(i, j, matrix));
					 }
				}
			}

			System.out.println(result.get());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int searchCrossedXMAS(int i, int j, ArrayList<ArrayList<Character>> matrix) {

		if ((protectedSearch(matrix,i - 1,j - 1, 'M') && protectedSearch(matrix,i + 1,j + 1, 'S') ||
			protectedSearch(matrix,i - 1,j - 1, 'S') && protectedSearch(matrix,i + 1,j + 1, 'M')) &&
			(protectedSearch(matrix,i - 1,j + 1, 'M') && protectedSearch(matrix,i + 1,j - 1, 'S') ||
			 protectedSearch(matrix,i - 1,j + 1, 'S') && protectedSearch(matrix,i + 1, j - 1, 'M')))
		{
			return 1;
		} else {
			return 0;
		}
	}

	private static boolean protectedSearch(ArrayList<ArrayList<Character>> matrix, int i, int j, char m) {
		try {
			final Character currentLetter = matrix.get(i).get(j);
			return currentLetter.equals(m);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
}
