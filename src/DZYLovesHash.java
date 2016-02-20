import java.util.Scanner;

public class DZYLovesHash {

	public int determineConflictPos(int p, int Xi[]) {

		int hashTable[] = new int[p];

		for (int i = 0; i < p; i++)
			hashTable[i] = -1;

		for (int i = 0; i < Xi.length; i++) {
			int pos = Xi[i] % p;
			if (hashTable[pos] != -1)
				return i + 1;
			else
				hashTable[pos] = 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DZYLovesHash DZYLovesHash = new DZYLovesHash();
		int p = sc.nextInt();
		int numberSize = sc.nextInt();
		int Xi[] = new int[numberSize];

		for (int i = 0; i < numberSize; i++)
			Xi[i] = sc.nextInt();

		System.out.println(DZYLovesHash.determineConflictPos(p, Xi));
		sc.close();
	}
}
