public class SudokuSolver{
        public boolean isSafe(char[][] board,int row,int col,int number){
                for(int i=0;i<board.length;i++){
                        if(board[i][col]==(char)(number+'0')){
                                return false;
                        }
                }
                for(int j=0;j<board.length;j++){
                        if(board[row][j]==(char)(number +'0')){
                                return false;
                        }
                }
                int sR=3*(row/3);
                int sC=3*(col/3);
                for(int i=sR;i<sR+3;i++){
                        for (int j=sC;j<sC+3;j++){
                                if(board[i][j]==(char)(number+'0')){
                                        return false;
                                }
                        }
                }
                return true;
        }
        public boolean helper(char board[][],int row,int col){
                if(row==board.length){
                        return true;
                }
                int nrow=0;
                int ncol=0;
                if(col==board.length-1){
                        nrow=row+1;
                        ncol=0;
                }else{
                        nrow=row;
                        ncol=col+1;
                }
                if(board[row][col]!='.'){
                        return (helper(board,nrow,ncol));
                        }else{
                                for(int i=1;i<=9;i++){
                                        if(isSafe(board,row,col,i)){
                                                board[row][col]=(char)(i+'0');
                                                if(helper(board,nrow,ncol)){
                                                        return true;
                                                }else{
                                                        board[row][col]='.';
                                                }
                                        }
                                } 
                        }
                        return false;
                }
                public void solveSudoku(char board[][]){
                        helper(board,0,0);
                }
                public static void printSudoku(char board[][]){
                        for (int i=0;i<9;i++){
                                for (int j=0;j<9;j++){
                                        System.out.print(board[i][j]+ " ");
                                }
                                System.out.println();
                        }
                }
                public static void main(String args[]){
                        char sudokuBoard[][]={
                                {'5','3','.','.','7','.','.','.','.'},
                                {'6','.','.','1','9','5','.','.','.'},
                                {'.','9','8','.','.','.','.','6','.'},
                                {'8','.','.','.','.','.','.','.','3'},
                                {'4','.','.','.','.','.','.','.','1'},
                                {'7','.','.','.','2','.','.','.','6'}, 
                                {'.','6','.','.','.','.','.','.','.'},
                                {'.','.','.','4','1','9','.','.','5'},
                                {'.','.','.','.','8','.','.','7','9'},
                        };
                        SudokuSolver solver=new SudokuSolver();
                        solver.solveSudoku(sudokuBoard);
                        System.out.println("solved sudoku :");
                        printSudoku(sudokuBoard);
                }
}
