import java.util.Scanner;

public class KalevitchAndChess {

	private int getPossibleNumberOfStrokes(char[][] chessBoard) {
		int possbleNumberOfStrokes = 0;

		for (int i = 0; i < chessBoard.length; i++) {

			char firstCharH = chessBoard[i][0], firstCharV = chessBoard[0][i];

			boolean isHStroke = firstCharH == 'B' ? true : false, 
					  isVStroke = firstCharV == 'B' ? true: false;
			if(isHStroke)
			for (int j = 1; j < chessBoard[i].length; j++) {
				if (firstCharH != chessBoard[i][j]) {
					isHStroke = false;
					break;
				}
			}

			if(isVStroke)
			for (int j = 1; j < chessBoard[i].length; j++) {
				if (firstCharV != chessBoard[j][i]) {
					isVStroke = false;
					break;
				}
			}

			if (isHStroke)
				possbleNumberOfStrokes++;

			if (isVStroke)
				possbleNumberOfStrokes++;
		}
		if(possbleNumberOfStrokes == 16 )
			possbleNumberOfStrokes /= 2;
		return possbleNumberOfStrokes;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		KalevitchAndChess kalevitchAndChess = new KalevitchAndChess();
		char[][] chessBoard = new char[8][8];

		for (int i = 0; i < 8; i++) {
			String row = sc.next();
			for (int j = 0; j < row.length(); j++)
				chessBoard[i][j] = row.charAt(j);
		}

		System.out.print(kalevitchAndChess
				.getPossibleNumberOfStrokes(chessBoard));
	}
}
