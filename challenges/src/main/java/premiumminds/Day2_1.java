package premiumminds;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day2_1 {

	public static void main(String[] args) {

		String filePath = "challenges/src/main/resources/day2.txt";

		try (Scanner scanner = new Scanner(new File(filePath))) {

			int safeReports = 0;
			while (scanner.hasNextLine()) {
				List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();

				if (isSafeReport(numbers)) {
					safeReports++;
				}
			}

			System.out.println(safeReports);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean isSafeReport(List<Integer> numbers) {

		int stableCount = 0;
		int pairs = 0;
		boolean differanceCheck = true;

		for (int i = 0; i < numbers.size() - 1; i += 1) {
			int firstNumber = numbers.get(i);
			int secondNumber = numbers.get(i + 1);
			pairs++;

			if (firstNumber > secondNumber) {
				stableCount++;
			} else if (secondNumber > firstNumber) {
				stableCount--;
			}

			final int abs = Math.abs(firstNumber - secondNumber);

			if (abs > 3) {
				differanceCheck = false;
				break;
			}
		}

		return differanceCheck && (stableCount == pairs || stableCount == -pairs);
	}
}