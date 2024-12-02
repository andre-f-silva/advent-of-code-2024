package premiumminds;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day1_2 {

	public static void main(String[] args) {

		String filePath = "challenges/src/main/resources/day1.txt";

		try (Scanner scanner = new Scanner(new File(filePath))) {

			List<Integer> list1 = new ArrayList<>();
			Map<Integer, Integer> list2 = new HashMap<>();

			while (scanner.hasNextLine()) {
				int firstNumber = scanner.nextInt();
				int secondNumber = scanner.nextInt();

				list1.add(firstNumber);

				if (list2.containsKey(secondNumber)) {
					list2.put(secondNumber, list2.get(secondNumber) + 1);
				} else {
					list2.put(secondNumber, 1);
				}
			}

			list1.sort(Integer::compareTo);

			int sum = 0;

			for (int i = 0; i < list1.size(); i++) {
				if (list2.containsKey(list1.get(i))) {
					sum += Math.abs(list1.get(i) * list2.get(list1.get(i)));
				}
			}

			System.out.println(sum);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}