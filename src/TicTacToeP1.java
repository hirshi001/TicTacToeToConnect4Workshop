import java.util.Scanner;

public class TicTacToeP1 {


    /*
        1. create char[][] board, initializeBoard(), and printBoard() methods first.
        2. then create char playerOne, playerTwo.
        3. create main loop, row = getNextNumber()-1, getNextNumber() method header, Scanner scanner, getNextNumber() body
        4. col = getNextNumber()-1, then test it by setting the board[row][col] to playerOne.
        5. create checks on row and col using do while loops (do while loops which surround them)

        6. create isPlayerOneTurn variable, update the setting of board[row][col], isPlayerOneTurn = !isPlayerOneTurn.
        7. checkPlayerWon(char player) method
        8. checkHorizontalWin method
        9. let them try to make checkVerticalWin method

     */

    static char[][] board = new char[3][3];;
    static char playerOne = 'X', playerTwo = 'O';
    static boolean isPlayerOneTurn = true;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        initializeBoard();

        while(true){

            printBoard();

            int row, col;
            do {
                //get row
                do {
                    System.out.println("Pick a valid row from 1-3");
                    row = getNextNumber()-1;
                } while (!(row >= 0 && row < 3));

                //get col
                do {
                    System.out.println("Pick a valid col from 1-3");
                    col = getNextNumber()-1;
                } while (!(col >= 0 && col < 3));

            } while(board[row][col]!='.');

            System.out.println("You Picked: "+ row+1 + ", "+ col+1);

            if(isPlayerOneTurn){
                board[row][col] = playerOne;
                if(checkPlayerWon(row, col)){
                    System.out.println("Player one Won");
                    return;
                }

            }
            else{
                board[row][col] = playerTwo;
                if(checkPlayerWon(row, col)){
                    System.out.println("Player two won");
                    return;
                }
            }


            isPlayerOneTurn = !isPlayerOneTurn;
        }

    }




    static boolean checkPlayerWon(int row, int col){
        return checkHorizontalWin(row, col) || checkVerticalWin(row, col);
    }


    static boolean checkHorizontalWin(int row, int col){
        //keep row constant, increase/decrease col

        char token = board[row][col];
        int c;
        for(c=0;c<3;c++){
            if(board[row][c]!=token) return false;
        }
        return true;
    }


    static boolean checkVerticalWin(int row, int col){
        //keep row constant, increase/decrease col
        char token = board[row][col];
        int r;
        for(r=0;r<3;r++){
            if(board[r][col]!=token) return false;
        }
        return true;

    }


    static int getNextNumber(){
        while(!scanner.hasNextInt()){
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    static void initializeBoard(){
        int row, col;
        for(row=0;row<board.length;row++){
            for(col = 0; col<board[row].length;col++){
                board[row][col] = '.';
            }
        }
    }


    static void printBoard(){

        int row, col;
        for(row=0;row<board.length;row++){
            for(col = 0; col<board[row].length;col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }

    }
}
