package com.draw;

import com.draw.Commands.*;

import java.util.IllegalFormatCodePointException;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Kmilov on 22/03/15.
 * Let this class to act as front-controller pattern.
 */
public class DrawCtrl {
    private enum avCommands {H, C, L, R, B, Q, S};
    private boolean quit    = false;


    private Board board;
    private CommandManager manager;
    private String command;

    /**
     * Instantiate Board and Command Manager
     */
    public  DrawCtrl() {
        this.board = Board.getBoard();
        this.manager = new CommandManager(this.board);
    }

    /**
     * Start our main loop
     */
    public void start(){
        while(!quit){
            System.out.print("-> enter command: ");
            Scanner sc = new Scanner(System.in);
            command = sc.nextLine();
            mapArgs(command);
        };
    }

    /**
     * Map a command from the console to a Board Command
     * @param command String argument
     */
    private void mapArgs(String command){
        String[] chunks = command.split(" ");

        try {
            avCommands cmd = avCommands.valueOf(chunks[0]);

            if(cmd == avCommands.Q){
                this.quit = true;
            }
            else {
                // I would want to use a hash  to map a
                // command to a runnable Command, no enough time
                switch (cmd){
                    case H:
                        this.help();
                        break;
                    case C:
                        this.manager.draw(new Create(this.board, chunks));
                        break;
                    case L:
                        this.manager.draw(new Line(this.board, chunks));
                        break;
                    case R:
                        this.manager.draw(new Square(this.board, chunks));
                        break;
                    case B:
                        this.manager.draw(new Bucket(this.board, chunks));
                        break;
                    case S:
                        this.manager.draw(new Render(this.board));
                        break;
                    default:
                        handleCommandException(new IllegalFormatCodePointException(0));
                        break;
                }

                // Run the command!
                this.manager.run();
            }
        }
        catch (IllegalArgumentException e){
            handleCommandException(e);
        }
    }

    /**
     * Do not go out of the borders
     * @param err
     */
    private void handleCommandException(IllegalArgumentException err){
        System.out.println("invalid command");
    }


    /**
     * Some help..
     */
    private void help() {
        System.out.println("Available commands.");
        System.out.println("C <w> <h>\t Create a new board with the given size width and height");
        System.out.println("L <x1> <y1> <x2> <y2>\t Draw a Line from point x1,y1 to x2,y2, only accept Horizontal or Vertical lines");
        System.out.println("R <x1> <y1> <x2> <y2>\t Draw a Square from point x1,y1 to x2,y2");
        System.out.println("B <x1> <y1> <char>\t Bucket tool, fill an area connected to x1 and y1 using color <char> (X, - and |, not allowed) ");
        System.out.println("S\tShow the Board");
    }
}