import java.util.Scanner;

public class LittleElephantAndNumbers {

	private boolean hasAtLeastCommonDigit(int d, int number) {
		String dS = String.valueOf(d);
		String numberS = String.valueOf(number);

		for (int i = 0; i < numberS.length(); i++) {
			for (int j = 0; j < dS.length(); j++) {
				if (numberS.charAt(i) == dS.charAt(j))
					return true;
			}
		}
		return false;
	}

	public int getNumberOfDivisors(int x) {
		int numOfDiv = 1;

		if (x == 1)
			return numOfDiv;

		int lastPossibleDivisor = x / 2;
		int endOfTheLoop = (lastPossibleDivisor % 2) == 0 ? lastPossibleDivisor / 2
				: (lastPossibleDivisor / 2) + 1;

		boolean isOdd = (lastPossibleDivisor % 2) == 1;

		for (int i = 1; i <= endOfTheLoop; i++) {

			int ftD = i;
			if (x % ftD == 0) {

				if (hasAtLeastCommonDigit(ftD, x))
					numOfDiv++;
			}

			int sD = (lastPossibleDivisor - (i - 1));
			if (!isOdd || !(i == endOfTheLoop)) {
				if (x % sD == 0)
					if (hasAtLeastCommonDigit(sD, x))
						numOfDiv++;
			}
		}

		return numOfDiv;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LittleElephantAndNumbers littleElephantAndNumbers = new LittleElephantAndNumbers();
		int x = sc.nextInt();
		System.out.println(littleElephantAndNumbers.getNumberOfDivisors(x));
		sc.close();
	}

}
