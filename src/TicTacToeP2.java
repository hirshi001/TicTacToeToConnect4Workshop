import java.util.Scanner;

public class TicTacToeP2 {


    /*
        1. create static int HEIGHT, WIDTH
        2. update board = new char[HEIGHT][WIDTH]
        3. update constraints on row, col
        4. update constraints on checkHorizontalWin, checkVerticalWin
     */

    static final int  HEIGHT = 6, WIDTH = 7;

    static char[][] board = new char[HEIGHT][WIDTH];
    static char playerOne = 'X', playerTwo = 'O';
    static boolean isPlayerOneTurn = true;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        initializeBoard();
        printBoard();

        while(true){


            int row, col;
            do {
                //get row
                do {
                    System.out.println("Pick a valid row from 1-3");
                    row = getNextNumber()-1;
                } while (!(row >= 0 && row < HEIGHT));

                //get col
                do {
                    System.out.println("Pick a valid col from 1-3");
                    col = getNextNumber()-1;
                } while (!(col >= 0 && col < WIDTH));
            } while(board[row][col]!='.');

            System.out.println("You Picked: "+ row+1 + ", "+ col+1);

            if(isPlayerOneTurn){
                board[row][col] = playerOne;
                printBoard();
                if(checkPlayerWon(row, col)){
                    System.out.println("Player one Won");
                    return;
                }

            }
            else{
                board[row][col] = playerTwo;
                printBoard();
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
        for(c=0;c<WIDTH;c++){
            if(board[row][c]!=token) return false;
        }
        return true;

    }
    static boolean checkVerticalWin(int row, int col){
        //keep row constant, increase/decrease col
        char token = board[row][col];
        int r;
        for(r=0;r<HEIGHT;r++){
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
