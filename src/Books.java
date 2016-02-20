import java.util.Arrays;
import java.util.Scanner;

public class Books {

	long getMaxNumOfBooks(long t, long Ai[]) {
		long maxNumOfBooks = 0;
		Arrays.sort(Ai);
		int i = 0;
		long timeConsumed = 0;
		while ((i < Ai.length) && (t >= (Ai[i] + timeConsumed))) {
			timeConsumed += Ai[i];
			maxNumOfBooks++;
			i++;
		}
		return maxNumOfBooks;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long t = sc.nextLong();

		long Ai[] = new long[n];

		for (int i = 0; i < n; i++)
			Ai[i] = sc.nextLong();

		Books books = new Books();
		System.out.println(books.getMaxNumOfBooks(t, Ai));

	}

}
