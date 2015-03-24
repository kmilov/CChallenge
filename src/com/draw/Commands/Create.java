package com.draw.Commands;

import com.draw.Board;

/**
 * Created by Kmilov on 23/03/15.
 */
public class Create implements Command {
    private Board board;
    private int cols;
    private  int rows;

    /**
     * Set cols and rows to use when the manager call us!
     * @param b
     * @param args
     */
    public Create(Board b, String[] args){
        this.board = b;
        this.cols  = Integer.parseInt(args[1]);
        this.rows = Integer.parseInt(args[2]);
    }

    /**
     * Runnable function by the Manager
     * @return
     */
    @Override
    public boolean exec() {
        // We don't want small boards, check and set!
        if(this.cols <= 2 || this.rows <= 2) {
            System.out.println("No enough space");
            return  false;
        }

        // Call board methods to set the map size
        this.board.setCols(this.cols);
        this.board.setRows(this.rows);

        this.board.createBoard();
        System.out.println("new board created ("+this.cols+"x"+this.rows+")");

        return true;
    }

    @Override
    public void undo() {
        // Not implemented because of time :(
    }
}
