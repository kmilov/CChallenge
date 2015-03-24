package com.draw.Commands;

import com.draw.Board;

/**
 * Created by Kmilov on 23/03/15.
 */
public class Line implements Command {
    private Board board;
    private int x1, y1, x2, y2;

    public Line(Board board, String[] args) {
        this.board = board;

        try {
            this.x1 = Integer.parseInt(args[1]);
            this.y1 = Integer.parseInt(args[2]);
            this.x2 = Integer.parseInt(args[3]);
            this.y2 = Integer.parseInt(args[4]);
        }catch (Exception e) {
            System.out.println("Please only  use numbers for coordinates.");
            return;
        }

    }

    @Override
    public boolean exec(){
        int j;

        try
        {
            // Not allow weird "lines"
            if(this.x2 < this.x1 || this.y2 < this.y1)
                return false;

            // Lets draw an horizontal line!
            if(this.x1 == this.x2) {
                for(j = this.y1; j <= this.y2; j++){
                    this.board.drawPixel(this.x1, j, 'X');
                }
            }
            // Lets draw a vertical line!
            else if(this.y1 == this.y2){
                for(j = this.x1; j <= this.x2; j++){
                    this.board.drawPixel(j, this.y1, 'X');
                }
            }
            else {
                System.out.println("Only vertical and Horizontal lines available.");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Your board is smaller.");
        }
        return true;
    }

    @Override
    public void undo() {
        // Not implemented because of time :(
    }
}
