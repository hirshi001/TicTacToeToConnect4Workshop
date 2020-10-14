import java.util.Scanner;

public class ConnectFour {


    /*

        1. change get row/get col so it works like connect 4 does

     */

    static final int  HEIGHT = 6, WIDTH = 7;
    static final int PIECES_TOGETHER_WIN = 4;

    static char[][] board = new char[HEIGHT][WIDTH];
    static char playerOne = 'X', playerTwo = 'O';
    static boolean isPlayerOneTurn = true;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        initializeBoard();
        printBoard();

        while(true){


            int row = 0, col;

            //get col
            do {
                System.out.println("Pick a valid col from 1-3");
                col = getNextNumber()-1;
            } while (!(col >= 0 && col < WIDTH) || board[0][col]!='.');


            //get row
            for(int r = HEIGHT-1;r>=0;r--){
                if(board[r][col]=='.'){
                    row = r;
                    break;
                }
            }


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
        return checkHorizontalWin(row, col) || checkVerticalWin(row, col) ||
                checkDiagonalWin(row, col) || checkAntiDiagonalWin(row, col);
    }


    static boolean checkHorizontalWin(int row, int col){
        //keep row constant, increase/decrease col

        int count = 1;

        char token = board[row][col];
        int c;
        for(c=col+1;c<WIDTH;c++){
            if(board[row][c]==token) count++;
            else break;
        }
        for(c=col-1;c>=0;c--){
            if(board[row][c]==token) count++;
            else break;
        }

        return count>=PIECES_TOGETHER_WIN;

    }
    static boolean checkVerticalWin(int row, int col){

        int count = 1;

        char token = board[row][col];
        int r;
        for(r=row+1;r<HEIGHT;r++){
            if(board[r][col]==token) count++;
            else break;
        }
        for(r=row-1;r>=0;r--){
            if(board[r][col]==token) count++;
            else break;
        }

        return count>=PIECES_TOGETHER_WIN;

    }

    static boolean checkDiagonalWin(int row, int col){
        char token = board[row][col];
        int count = 1;

        int r, c;

        for( r=row+1, c=col+1; r<HEIGHT && c<WIDTH; r++, c++){
            if(board[r][c]==token) count++;
            else break;
        }

        for(r=row-1, c=col-1;r>=0 && c>=0;r--, c--){
            if(board[r][c]==token) count++;
            else break;
        }

        return count>=PIECES_TOGETHER_WIN;
    }

    static boolean checkAntiDiagonalWin(int row, int col){
        char token = board[row][col];
        int count = 1;

        int r, c;

        for( r=row+1, c=col-1; r<HEIGHT && c>=0; r++, c--){
            if(board[r][c]==token) count++;
            else break;
        }

        for(r=row-1, c=col+1;r>=0 && c<WIDTH;r--, c++){
            if(board[r][c]==token) count++;
            else break;
        }

        return count>=PIECES_TOGETHER_WIN;
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
