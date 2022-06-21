import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

  private static Board board = new Board();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    printBoard(board.current());

    while (true) {
      playerTurn(board.current(), scanner);
      if (isGameFinished(board)){
        break;
      }
      printBoard(board.current());

      computerTurn(board.current());
      if (isGameFinished(board)){
        break;
      }
      printBoard(board.current());
    }
    scanner.close();
  }


  private static boolean isGameFinished(Board board) {
    if (hasContestantWon(board, 'X')) {
      printBoard(board.current());
      System.out.println("Player wins!");
      return true;
    }

    if (hasContestantWon(board, 'O')) {
      printBoard(board.current());
      System.out.println("Computer wins!");
      return true;
    }

    for (int i = 0; i < board.current().length; i++) {
      for (int j = 0; j < board.current()[i].length; j++) {
        if (board.current()[i][j] == ' ') {
          return false;
        }
      }
    }
    printBoard(board.current());
    System.out.println("The game ended in a tie!");
    return true;
  }


  private static boolean hasContestantWon(Board board, char symbol) {
    if (board.isWinner(symbol)) {
      return true;
    }
    return false;
  }


  private static void computerTurn(char[][] board) {
    Random rand = new Random();
    int computerMove;
    while (true) {
      computerMove = rand.nextInt(9) + 1;
      if (Board.isValidMove(Integer.toString(computerMove), board)) {
        break;
      }
    }
    System.out.println("Computer chose " + computerMove);
    Board.placeMove(board, Integer.toString(computerMove), 'O');
  }


  private static void playerTurn(char[][] board, Scanner scanner) {
    String userInput;
    while (true) {
      System.out.println("Where would you like to play? (1-9)");
      userInput = scanner.nextLine();
      if (Board.isValidMove(userInput, board)){
        break;
      } else {
        System.out.println(userInput + " is not a valid move.");
      }
    }
    Board.placeMove(board, userInput, 'X');
  }


  private static void printBoard(char[][] board) {
    System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
    System.out.println("-+-+-");
    System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
    System.out.println("-+-+-");
    System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
  }
}

