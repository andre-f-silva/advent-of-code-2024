package premiumminds;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1_1 {

	public static void main(String[] args) {

		String filePath = "challenges/src/main/resources/day1.txt";

		try (Scanner scanner = new Scanner(new File(filePath))) {

			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();

			while (scanner.hasNextLine()) {
				int firstNumber = scanner.nextInt();
				int secondNumber = scanner.nextInt();

				list1.add(firstNumber);
				list2.add(secondNumber);
			}

			list1.sort(Integer::compareTo);
			list2.sort(Integer::compareTo);

			int sum = 0;

			for (int i = 0; i < list1.size(); i++) {
				sum += Math.abs(list1.get(i) - list2.get(i));
			}

			System.out.println(sum);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}