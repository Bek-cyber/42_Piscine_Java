package Day_00.ex04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		char[] charArray = line.toCharArray();
		char[] symbolArray = new char[line.length()];
		char[][] barGraph;
		int[] countArray = new int[line.length()];
		int position = -1;
		int j = 0;

		symbolArray[0] = charArray[0];
		++(countArray[0]);
		for (int i = 1; i < charArray.length; ++i) {
			position = symbolIsExist(symbolArray, charArray[i]);
			if (position != -1) {
				++(countArray[position]);
			}
			else {
				++j;
				symbolArray[j] = charArray[i];
				++(countArray[j]);
			}
		}
		sortResult(symbolArray, countArray);
		barGraph = createBarGraph(symbolArray, countArray);
		barGraphOutput(barGraph);
	}

	private static int symbolIsExist(char[] symbolArray, char symbol) {
		for (int i = 0; i < symbolArray.length; ++i) {
			if (symbol == symbolArray[i]) {
				return i;
			}
		}
		return -1;
	}

	private static void sortResult(char[] symbolArray, int[] countArray) {
		int tmpNum, j;
		char tmpChar;
		for (int i = 0; i < countArray.length; ++i) {
			j = i + 1;
			for (; j < countArray.length; ++j) {
				if (countArray[i] != 0 && countArray[i] < countArray[j]) {
					tmpNum = countArray[i];
					countArray[i] = countArray[j];
					countArray[j] = tmpNum;
					tmpChar = symbolArray[i];
					symbolArray[i] = symbolArray[j];
					symbolArray[j] = tmpChar;
				}
			}
		}
	}

	private static char[][] createBarGraph(char[] symbolArray, int[] countArray) {
		int counter = realLength(countArray);
		char[][] barGraph = new char[counter][12];
		for (int i = 0; i < countArray.length; ++i) {
			if (countArray[i] >= 10) {
				barGraph[i][0] = (char) countArray[i];
				barGraph[i][11] = symbolArray[i];
				for (int j = 1; j < 11; ++j) {
					barGraph[i][j] = '#';
				}
			}
			else {
				barGraph[i][12 - countArray[i]] = Character.toChars(countArray[i])[0];
				barGraph[i][11] = symbolArray[i];
				for (int j = 13 - countArray[i]; j < 11; ++j) {
					barGraph[i][j] = '#';
				}
			}
		}
		return barGraph;
	}

	public static int realLength(int[] countArray) {
		int counter = 0;
		for (int tmp: countArray) {
			if (tmp != 0) {
				++counter;
			}
		}
		return counter;
	}

	private static void barGraphOutput(char[][] barGraph) {
		Arrays.stream(barGraph).map(Arrays::toString).forEach(System.out::println);
	}
}
