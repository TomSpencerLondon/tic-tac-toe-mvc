import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

  private static Board board = new Board();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    printBoard(board.current());

    while (true) {
      playerTurn(scanner);
      if (isGameFinished(board)){
        break;
      }
      printBoard(board.current());

      computerTurn();
      if (isGameFinished(board)){
        break;
      }
      printBoard(board.current());
    }
    scanner.close();
  }


  private static boolean isGameFinished(Board board) {
    if (board.hasContestantWon('X')) {
      printBoard(board.current());
      System.out.println("Player wins!");
      return true;
    }

    if (board.hasContestantWon('O')) {
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


  private static void computerTurn() {
    Random rand = new Random();
    int computerMove;
    while (true) {
      computerMove = rand.nextInt(9) + 1;
      if (board.isValidMove(Integer.toString(computerMove))) {
        break;
      }
    }
    System.out.println("Computer chose " + computerMove);
    board.placeMove(Integer.toString(computerMove), 'O');
  }


  private static void playerTurn(Scanner scanner) {
    String userInput;
    while (true) {
      System.out.println("Where would you like to play? (1-9)");
      userInput = scanner.nextLine();
      if (board.isValidMove(userInput)){
        break;
      } else {
        System.out.println(userInput + " is not a valid move.");
      }
    }
    board.placeMove(userInput, 'X');
  }


  private static void printBoard(char[][] board) {
    System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
    System.out.println("-+-+-");
    System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
    System.out.println("-+-+-");
    System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
  }
}

