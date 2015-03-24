package com.draw.Commands;

import com.draw.Board;

/**
 * Created by Kmilov on 23/03/15.
 */
public class Square implements Command {
    private Board board;
    private int x1, y1, x2, y2;

    // Set our coordinates, a bit ugly
    public Square(Board c, String[] args) {
        this.board = c;
        try {
            this.x1 = Integer.parseInt(args[1]);
            this.y1 = Integer.parseInt(args[2]);
            this.x2 = Integer.parseInt(args[3]);
            this.y2 = Integer.parseInt(args[4]);
        }catch (Exception e) {
            System.out.println("Please only  use numbers.");
            return;
        }
    }

    @Override
    public boolean exec() {
        try{
            // In case we have hax0rs out there
            if(this.x2 < this.x1 || this.y2 < this.y1)
                return false;

            int i,j;

            // Draw only the horizontal/vertical lines, we could use the methods
            // in the Line command, but is quiet the same, for the challenge and I don't want to separate
            // the commands implementation.
            for(j = this.x1; j <= this.x2; j++){
                this.board.drawPixel(j, this.y1, 'X');
                this.board.drawPixel(j, this.y2, 'X');
            }
            for(j = this.y1; j <= this.y2; j++){
                this.board.drawPixel(this.x1, j, 'X');
                this.board.drawPixel(this.x2, j, 'X');
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
