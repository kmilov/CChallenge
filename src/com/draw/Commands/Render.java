package com.draw.Commands;

import com.draw.Board;

/**
 * Created by h4dd on 23/03/15.
 */
public class Render implements Command {
    private Board board;

    public Render(Board b){
        this.board = b;
    }

    @Override
    public boolean exec() {
        // Do nothing, let the default render option run
        return true;
    }

    @Override
    public void undo() {

    }
}
