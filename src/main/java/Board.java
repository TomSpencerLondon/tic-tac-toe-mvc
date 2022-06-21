public class Board {
  private final char[][] board;

  public Board() {
    board = new char[][]{
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}};
  }

  static boolean isValidMove(String position, char[][] board) {
    switch(position) {
      case "1":
        return (board[0][0] == ' ');
      case "2":
        return (board[0][1] == ' ');
      case "3":
        return (board[0][2] == ' ');
      case "4":
        return (board[1][0] == ' ');
      case "5":
        return (board[1][1] == ' ');
      case "6":
        return (board[1][2] == ' ');
      case "7":
        return (board[2][0] == ' ');
      case "8":
        return (board[2][1] == ' ');
      case "9":
        return (board[2][2] == ' ');
      default:
        return false;
    }
  }

  public char[][] current() {
    return board;
  }

  static void placeMove(char[][] board, String position, char symbol) {
    switch(position) {
      case "1":
        board[0][0] = symbol;
        break;
      case "2":
        board[0][1] = symbol;
        break;
      case "3":
        board[0][2] = symbol;
        break;
      case "4":
        board[1][0] = symbol;
        break;
      case "5":
        board[1][1] = symbol;
        break;
      case "6":
        board[1][2] = symbol;
        break;
      case "7":
        board[2][0] = symbol;
        break;
      case "8":
        board[2][1] = symbol;
        break;
      case "9":
        board[2][2] = symbol;
        break;
      default:
        System.out.println(":(");
    }
  }

  public boolean isWinner(char symbol) {
    return (board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
        (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
        (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||

        (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
        (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
        (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||

        (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
        (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol);
  }
}
