import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player" + " " + player + " " + "Enter:");
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = Won(board, player);
                if (gameOver) {
                    System.out.println("Player" + player + " has won the game");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move.Try again !");
            }
        }
        printBoard(board);
    }
    public static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + "|");
            }
            System.out.println();
        }
    }
    private static boolean Won(char[][] board, char player) {
        for (char[] chars : board) {
            if (chars[0] == player && chars[1] == player && chars[2] == player) {
                return true;
            }
        }
        for(int col=0;col<board.length;col++) {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
                return true;
            }
        }

        if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
            return true;
        }

        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }
}