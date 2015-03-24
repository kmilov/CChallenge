# CChallenge
My Code Challenge Drawing Board

This is an implementation of the Code Challenge for the Burguer implemented in Java,
Nothing fancy to look, more than a few patterns and the FloodFill algorithm

## How to run
Should work on any platform (JVM), the code dosen't have nothing special to compile.

## The special thing

The bucket tool was a bit harder, but nothing than a search in Google can do, http://en.wikipedia.org/wiki/Flood_fill

## Patterns used
- Singleton, to only have one instance of the board
- First Controller, to only have an entry point of the program
- Command, To manage the execution of different actions in the board

## TODO
- More drawing tools than a Line, Square and Bucket Tool
- Map input commands to Commands with maps
- Implement ¡undo!
- Inherit Line and Square from Shape :(
- Better way to handle Exceptions
- Networking drawing ?¿