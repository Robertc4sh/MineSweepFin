
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
    Cell[] board;
    int rows;
    int columns;
    
    boolean number = false;
    public MinesweeperBoard2(int row, int column, int bomb){
        //Put the constructor here.
        this.rows = row;
        this.columns = column;
        board = new Cell[rows*columns];
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());
        addBombs(bomb);
        addNums();
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public MinesweeperBoard2(){
        this(10, 10, 50);
    }

    public void addBombs(int bombs) {//throws Exception{

        for(int i = 0; i < bombs; i++){
            int x = (int)(Math.random() * (rows*columns));
            while (board[x].getValue() != 0){
                x = (int)(Math.random() * (rows*columns));
            }
            board[x].setBomb();
        }

    }

    public void addNums(){
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
                    else if(i >= (rows*columns) - rows){
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
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int index = 0;
        int x = 0;
        for (int i = 0; i < (rows*columns); i++){

            if (x == columns){
                System.out.println();
                x = 0;
            }
            if (board[index].getValue() == -1){
                System.out.print("X ");
            } 
            else{
                System.out.print(board[index].getValue() + " ");
            }
            x++;
            index++;
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
            board[i]= new Cell();
            panel.add(board[i].getButton());
        }
        return panel;
    }

}
