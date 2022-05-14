package Day_00.ex03;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String week = scanner.nextLine();
		long evaluations = 0;
		int counterOfWeeks = 1;
		int minimumRateOfWeek = 1;
		while (!week.equals("42") && counterOfWeeks <= 18) {
			checkInput(week, counterOfWeeks);
			minimumRateOfWeek = ratingAnalysis(scanner);
			evaluations = (evaluations * 10) + minimumRateOfWeek;
			++counterOfWeeks;
			week = scanner.nextLine();
		}
		evaluations = rearrange(evaluations);
		handleEvaluations(evaluations, counterOfWeeks);
	}

	private static void checkInput(String week, int counter) {
		if (!week.equals("Week " + counter)) {
			System.err.println("Illegal Argument");
			System.exit(1);
		}
	}

	private static int ratingAnalysis(Scanner scanner) {
		int minimum = 9, evaluation = 1;
		for (int i = 0; i < 5; ++i) {
			evaluation = scanner.nextInt();
			if (minimum > evaluation) {
				minimum = evaluation;
			}
		}
		scanner.nextLine();
		return minimum;
	}

	private static long rearrange (long evaluations) {
		long number = 0;
		while (evaluations > 0) {
			number = (number * 10) + (evaluations % 10);
			evaluations /= 10;
		}
		return number;
	}

	private static void handleEvaluations(long evaluations, int counterOfWeeks) {
		int digit = 0;
		for (int i = 1; i < counterOfWeeks; ++i) {
			digit = (int) (evaluations % 10);
			System.out.print("Week " + i + " ");
			for (int j = 0; j < digit; ++j) {
				System.out.print("=");
			}
			System.out.println(">");
			evaluations /= 10;
		}
	}
}
