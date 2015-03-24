package com.draw;

import com.draw.Commands.Command;
import com.draw.Commands.Create;

import java.util.ArrayList;
import java.util.List;

/**
 * Command pattern here! store Command instances
 * and execute them trough their exec method!
 *
 * Created by Kmilov on 22/03/15.
 */
public class CommandManager {
    // List of commands here, this works like a FIFO , easy to implement the undo method (in case we have time ;))
    private List<Command> cmdList = new ArrayList<Command>();
    private Board board;

    public  CommandManager(Board b) {
        // This is our Board trough all the execution
        this.board = b;
    }

    /**
     * Sometimes you can execute several Commands, at the moment
     * we will push and run just one command
     * @param command
     */
    public void draw(Command command){
        // no allow actions in an empty board
        if(!(command instanceof Create) && !(this.board.boardReady()))
            System.out.println("Please create a board with the C command first.");
        else
            this.cmdList.add(command);

    }

    public void run() {
        for(Command command : cmdList){
            // Magic happens, every Command instance have a
            // exec method that we can execute, if we got false, assume that the command didn't  run well.
            if(!command.exec()){
                System.out.println("Invalid command syntax");
            }
        }

        // Render the board with the changes
        this.board.render();
        this.cmdList.clear();
    }
}
