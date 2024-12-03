package premiumminds;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Day3_1 {

	public static void main(String[] args) {

		String filePath = "challenges/src/main/resources/day3.txt";

		try (Scanner scanner = new Scanner(new File(filePath))) {

			final AtomicInteger result = new AtomicInteger();

			scanner.findAll("mul\\((\\d{1,3}),(\\d{1,3})\\)").forEach(match -> {
				result.addAndGet(Integer.parseInt(match.group(1)) * Integer.parseInt(match.group(2)));
			});

			System.out.println(result.get());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
