import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int i = 0; i < 3; i++){
            Arrays.fill(board[i], '_');
        }

        char player = 'x';
        boolean gameOver = false;
        Scanner input  = new Scanner(System.in);

        int fill = 0;
        while (!gameOver){
            if(fill == 9){
                System.out.println("Board filled"+" "+"replay!");
                break;
            }
            printBoard(board);
            System.out.println("player"+player+"Enter : ");
            int row = input.nextInt();
            int col = input.nextInt();

            if(board[row][col] == '_'){
                fill++;
                board[row][col] = player;
                gameOver = haveWon(board, row, col, player);
                if(!gameOver){
                    player = (player == 'x') ? 'o' : 'x';
                }
                else System.out.println("player "+player+" has won");
            }
            else System.out.println("Wrong move! try again");
        }
        printBoard(board);
    }

    private static void printBoard(char[][] board) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean haveWon(char[][] board, int row, int col, char player) {
        //check rows
        int i = row-1;
        int j = col;
        int count = 0;
        while(i >= 0){
            if(board[i][j] != player) break;
            else count++;
            i--;
        }
        i = row+1;
        while(i < 3){
            if(board[i][j] != player) break;
            else count++;
            i++;
        }
        if(count == 2) return true;
        i = row;
        j = col-1;
        count = 0;
        //col
        while(j >= 0){
            if(board[i][j] != player) break;
            else count++;
            j--;
        }
        j = col+1;
        while(j < 3){
            if(board[i][j] != player) break;
            else count++;
            j++;
        }
        j = col;
        if(count == 2) return true;
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }
}













