package com.draw.Commands;

/**
 * Every acition in the board should implement this.
 *
 * Created by Kmilov on 22/03/15.
 */
public interface Command {
    /**
     * Implement on every command to execute a function on a given board
     */
    public abstract boolean exec();

    /**
     * Implement to undo the last command,
     * maybe we will have time for this :P
     */
    public abstract void undo();
}
