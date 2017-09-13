package com.draw.Commands;

import com.draw.Board;

public class Bucket implements Command {
    private Board board;
    private int x1, y1;
    private char colour;

    /**
     * Build the command configuration, nothing special
     * @param c
     * @param args
     */
    public Bucket(Board c, String[] args) {
        board = c;
        try {
            this.x1 = Integer.parseInt(args[1]);
            this.y1 = Integer.parseInt(args[2]);
            this.colour = args[3].charAt(0);
        }catch (Exception e){
            System.out.println("Please use only numbers.");
            return;
        }

    }

    @Override
    public void undo() {
        // Not implemented because of time :(
    }

    /**
     * Just call the recursive algorithm
     * @return
     */
    @Override
    public boolean exec() {
        this.FloodFill(this.x1, this.y1, this.colour);
        return true;
    }

    /**
     * Recursive Flood fill algorithm!
     * @param x
     * @param y
     * @param color
     */
    public void FloodFill(int x, int y, char color) {
        // Please do not fill with the same color
        if(color == 'X' || color == '-' || color == '|') {
            System.out.println("Use a different color than X, | or - ");
            return;
        }

        if (x < 1)
            return;
        if (y < 1)
            return;

        if(x > this.board.getCols())
            return;

        if(y > this.board.getRows())
            return;

        char pixel =this.board.getPixel(x, y);

        // do not override our previous pixels
        if (color == pixel || pixel != ' ')
            return;

        this.board.drawPixel(x, y, color);

        // Go west on X axe
        this.FloodFill(x - 1, y, color);

        // Go east on X axe
        this.FloodFill(x + 1, y, color);

        // Go west on Y axe
        this.FloodFill(x, y - 1, color);

        // Go east on Y axe
        this.FloodFill(x, y + 1, color);
    }
}
