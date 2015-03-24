package com.draw;

/**
 * Our Board!
 * Created by Kmilov on 22/03/15.
 */
public class Board {
    // our only instance, Singleton pattern
    private static Board boardInstance = new Board();
    public char[][] board;
    private int cols = 0;
    private  int rows = 0;

    private void Canvas() {}

    /**
     * Singleton Pattern!
     * @return
     */
    public static Board getBoard() {
        return boardInstance;
    }

    /**
     * Show our Canvas to the world!
     */
    public void render(){
        int i,j;

        if(!this.boardReady())
            return;

        for(i=0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                System.out.print(this.board[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Set a pixel on a given X,Y
     * @param x
     * @param y
     * @param c
     * @throws ArrayIndexOutOfBoundsException no H4x0rs pls
     */
    public void drawPixel(int x, int y, char c) throws ArrayIndexOutOfBoundsException{
        try{
            // save our borders
            this.board[y][x] = c;
        }catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Return a pixel on an specific X,Y position
     * @param x
     * @param y
     * @return
     * @throws ArrayIndexOutOfBoundsException
     */
    public char getPixel(int x, int y) throws ArrayIndexOutOfBoundsException {
        try {
            return this.board[y][x];
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Create our empty board
     */
    public  void createBoard() {
        int i,j;

        this.board = new char[this.rows][this.cols];

        // Set blank spaces for every coordinates in the map
        for(i=0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {

                // Can be uglier? here we draw our borders
                if(i == 0 || (i+1) == this.rows)
                    this.board[i][j] = '-';
                else if(j == 0 || (j+1) == this.cols)
                    this.board[i][j] = '|';
                else
                    this.board[i][j] = ' ';
            }
        }
    }

    /**
     * Nothing special, set the Cols
     * @param c
     */
    public void setCols(Integer c) {
        // save something for the borders
        this.cols = c + 2;
    }

    /**
     * Nothing special, set the Rows
     * @param r
     */
    public void setRows(Integer r) {
        // save something for the borders
        this.rows = r + 2;
    }

    /**
     * Get the current cols for the board
     * @return
     */
    public int getCols() {
        // Save our borders
        return this.cols - 2;
    }

    /**
     * Get the current rows for the board
     * @return
     */
    public int getRows() {
        // Save our borders
        return this.rows - 2;
    }

    /**
     * we dont want NPE's when we don't have a board
     * @return
     */
    public  boolean boardReady() {
        return (this.board == null) ? false : true;
    }
}