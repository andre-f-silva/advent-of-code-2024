package premiumminds;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Day3_2 {

	public static void main(String[] args) {

		String filePath = "challenges/src/main/resources/day3.txt";

		try (Scanner scanner = new Scanner(new File(filePath))) {

			final AtomicInteger result = new AtomicInteger();
			final boolean[] enable = { true };

			scanner.findAll("(mul\\((\\d{1,3}),(\\d{1,3})\\))|(do\\(\\))|don\\'t\\(\\)").forEach(match -> {

				if(match.group().equals("do()")) {
					enable[0] = true;
				}
				else if(match.group().equals("don't()")) {
					enable[0] = false;
				}
				else if(enable[0]) {
					result.addAndGet(Integer.parseInt(match.group(2)) * Integer.parseInt(match.group(3)));
				}
			});

			System.out.println(result.get());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
