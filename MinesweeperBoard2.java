
/**
 * Write a description of class Minesweeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[][] board;
    int rows;
    int columns;

    boolean number = false;
    public MinesweeperBoard2(int row, int column, int bomb){
        //Put the constructor here.
        this.rows = row;
        this.columns = column;
        board = new Cell[rows][columns];
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());

        addBombs(bomb);
        /*
        addNums();
         */
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public MinesweeperBoard2(){
        this(10, 10, 50);
    }

    public void addBombs(int bombs) {//throws Exception{

        for(int i = 0; i < bombs; i++){
            int x = (int)(Math.random() * (rows));
            int y = (int)(Math.random() * (columns));
            while (board[x][y].isBomb() == true){
                x = (int)(Math.random() * (rows));
                y = (int)(Math.random() * (columns));
            }
            board[x][y].setBomb();
        }
    }

    public void addNums(){
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++){
                if (board[r][c].isBomb()){
                    //Left
                    if (c-1 >= 0 && !board[r][c-1].isBomb()){
                        board[r][c-1].numAdd();
                    }
                    //Right
                    if (c + 1 < columns && !board[r][c+1].isBomb()){
                        board[r][c+1].numAdd();
                    }
                    //Top
                    if (r-1 >= 0 && !board[r-1][c].isBomb()){
                        board[r-1][c].numAdd();
                    }
                    //Bottom
                    if (r+1 < rows && !board[r+1][c].isBomb()){
                        board[r+1][c].numAdd();
                    }
                    //Top Left Corner
                    if (r-1 >= 0 && c-1 >= 0 && !board[r-1][c-1].isBomb()){
                        board[r-1][c-1].numAdd();
                    }
                    //Top Right Corner
                    if (r-1 >= 0 && c+1 < columns && !board[r-1][c+1].isBomb()){
                        board[r-1][c+1].numAdd();
                    }
                    //Bottom Left Corner
                    if (r+1 < rows && c-1 >= 0 && !board[r+1][c-1].isBomb()){
                        board[r+1][c-1].numAdd();
                    }
                    //Bottom Right Corner
                    if (r+1 < rows && c+1 < columns && !board[r+1][c+1].isBomb()){
                        board[r+1][c+1].numAdd();
                    }
                }
            }
        }

        /*
        if(!number){
        for (int i = 0; i < ((rows)*(columns)); i++){
        if(board[i].getValue() == -1){
        if(i < columns){
        if((i % columns) == 0){
        if(board[i + 1].getValue() == -1){}
        else{board[i + 1].numAdd();
        }
        if(board[i + columns].getValue() == -1){}
        else{board[i + columns].numAdd();
        }
        if(board[(i + 1) + columns].getValue() == -1){}
        else{board[(i + 1) + columns].numAdd();
        }
        }
        else if((i % columns) == (columns - 1)){
        if(board[i - 1].getValue() == -1){}
        else{board[i - 1].numAdd();
        }
        if(board[i + columns].getValue() == -1){}
        else{board[i + columns].numAdd();
        }
        if(board[(i - 1) + columns].getValue() == -1){}
        else{board[(i - 1) + columns].numAdd();
        }
        }

        else{
        if(board[i + 1].getValue() == -1){}
        else{board[i + 1].numAdd();
        }
        if(board[i + columns].getValue() == -1){}
        else{board[i + columns].numAdd();
        }
        if(board[(i + 1) + columns].getValue() == -1){}
        else{board[(i + 1) + columns].numAdd();
        }
        if(board[i - 1].getValue() == -1){}
        else{board[i - 1].numAdd();
        }
        if(board[(i - 1) + columns].getValue() == -1){}
        else{board[(i - 1) + columns].numAdd();
        }
        }
        }
        else if(i >= (rows*columns) - columns){
        if((i % columns) == 0){
        if(board[i + 1].getValue() == -1){}
        else{board[i + 1].numAdd();
        }
        if(board[i - columns].getValue() == -1){}
        else{board[i - columns].numAdd();
        }
        if(board[(i + 1) - columns].getValue() == -1){}
        else{board[(i + 1) - columns].numAdd();
        }
        }
        else if((i % columns) == (columns - 1)){
        if(board[i - 1].getValue() == -1){}
        else{board[i - 1].numAdd();
        }
        if(board[i - columns].getValue() == -1){}
        else{board[i - columns].numAdd();
        }
        if(board[(i - 1) - columns].getValue() == -1){}
        else{board[(i - 1) - columns].numAdd();
        }
        }

        else{
        if(board[i + 1].getValue() == -1){}
        else{board[i + 1].numAdd();
        }
        if(board[i - columns].getValue() == -1){}
        else{board[i - columns].numAdd();
        }
        if(board[(i + 1) - columns].getValue() == -1){}
        else{board[(i + 1) - columns].numAdd();
        }
        if(board[i - 1].getValue() == -1){}
        else{board[i - 1].numAdd();
        }
        if(board[(i - 1) - columns].getValue() == -1){}
        else{board[(i - 1) - columns].numAdd();
        }
        }
        }
        else{
        if((i % columns) == 0){
        if(board[i + 1].getValue() == -1){}
        else{board[i + 1].numAdd();
        }
        if(board[i - columns].getValue() == -1){}
        else{board[i - columns].numAdd();
        }
        if(board[(i + 1) - columns].getValue() == -1){}
        else{board[(i + 1) - columns].numAdd();
        }
        if(board[i + columns].getValue() == -1){}
        else{board[i + columns].numAdd();
        }
        if(board[(i + 1) + columns].getValue() == -1){}
        else{board[(i + 1) + columns].numAdd();
        }
        }
        else if((i % columns) == (columns - 1)){
        if(board[i - 1].getValue() == -1){}
        else{board[i - 1].numAdd();
        }
        if(board[i - columns].getValue() == -1){}
        else{board[i - columns].numAdd();
        }
        if(board[(i - 1) - columns].getValue() == -1){}
        else{board[(i - 1) - columns].numAdd();
        }
        if(board[i + columns].getValue() == -1){}
        else{board[i + columns].numAdd();
        }
        if(board[(i - 1) + columns].getValue() == -1){}
        else{board[(i - 1) + columns].numAdd();
        }
        }

        else{
        if(board[i + 1].getValue() == -1){}
        else{board[i + 1].numAdd();
        }
        if(board[i - 1].getValue() == -1){}
        else{board[i - 1].numAdd();
        }
        if(board[(i + 1) - columns].getValue() == -1){}
        else{board[(i + 1) - columns].numAdd();
        }
        if(board[(i + 1) + columns].getValue() == -1){}
        else{board[(i + 1) + columns].numAdd();
        }
        if(board[i - columns].getValue() == -1){}
        else{board[i - columns].numAdd();
        }
        if(board[(i - 1) - columns].getValue() == -1){}
        else{board[(i - 1) - columns].numAdd();
        }
        if(board[i + columns].getValue() == -1){}
        else{board[i + columns].numAdd();
        }
        if(board[(i - 1) + columns].getValue() == -1){}
        else{board[(i - 1) + columns].numAdd();
        }
        }
        }
        }
        }
        number = true;
        }
        else{

        }
         */

    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        for(int j = 0; j < rows; j++){
            for(int k = 0; k < columns; k++){
                if (board[j][k].getValue() == -1){
                    System.out.print("X ");
                }
                else{
                    System.out.print(board[j][k].getValue() + " ");
                }
            }
            System.out.println();
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows; i++){
            for(int j = 0; j < columns; j++){
                board[i][j]= new Cell();
                panel.add(board[i][j].getButton());
            }
        }
        return panel;
    }

}
