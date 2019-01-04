package com.company;


import java.util.Scanner;

// TODO LIST:
// Clean up the user input validation
// Implement the GET command
// Implement the PUT command
// Comment the functions

public class Main {

    public static final int GRID_SIZE = 4;

    public static void main(String[] args) {

        introduction();
        boolean gameOver = false;
        int[][] gameboard = new int[GRID_SIZE][GRID_SIZE];
        boolean playerOneTurn = true; // true is player one, false is player two


        String command;
        Scanner userInput= new Scanner(System.in);

        while(!gameOver) {
            // get the users input
            if(playerOneTurn) {
                System.out.println("Player One's Turn");

            } else {
                System.out.println("Player Two's Turn");
            }
            System.out.print("Enter a command: ");
            command = userInput.nextLine();
            //System.out.println("You entered String "+ choice);


            if (command.equals("BOARD")) {
                showBoard(gameboard);
            } else if (command.equals("EXIT")) {
                exitGame();
            } else if (command.equals("GET")) {
                System.out.println("GETEM!!!!!");
            } else if (command.substring(0, 3).equals("PUT")) { // the first 4 characters are PUT followed by space

                // validate that the command is followed by a space and number
                if (command.length() <= 4) {
                    System.out.println("Please enter PUT followed by a space and a number.\n");
                    continue;
                }

                // validate and ensure the 3rd index is a space
                if(command.charAt(3) != ' ') {
                    System.out.println("Command must contain a space after PUT.\n");
                    continue;
                }

                // Grab all of the tokens the user inputted
                String tokens[] = command.split(" ");

                // validate allow user to only enter two tokens PUT [number]
                if (tokens.length > 2) {
                    System.out.println("Please enter a command as follows: PUT [number]\n");
                    continue;
                }

                // validate that the 2nd token is a number
                if(!isNumeric(tokens[1])) {
                    System.out.println("Value after the PUT command must be a number\n");
                    continue;
                }

                int numberValue = Integer.parseInt(tokens[1]);

                // validate a number between 1 to GRID_SIZE
                if (numberValue < 1 || numberValue > GRID_SIZE) {
                    System.out.println("Please enter a value that is between 1 and " + GRID_SIZE
                            + " after the PUT command.\n");
                    continue;
                }

                // DO ALL OF THE GARBAGE STUFF AND CHANGE THE PLAYER TO PLAYER TWO
                System.out.println(command);
            } else {
                System.out.println("Invalid command, try again. \n");
            }

        }
    }

    public static void introduction() {
        System.out.println("Welcome to DropToken!");
        System.out.println("A 2 player game where players take turn dropping tokens until");
        System.out.println("four tokens align either vertically, diagonally or horizonally.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Directions:");
        System.out.println("Each turn the player is allowed to use 4 commands:");
        System.out.println("COMMAND key : Explanation");
        System.out.println("PUT <column> : OK | ERROR | WIN | DRAW");
        System.out.println("GET : List of columns that have been successfully put to.");
        System.out.println("BOARD : a 4x4 matrix that shows the state of the board.");
        System.out.println("EXIT : ends the game.");
        System.out.println("----------------------------------------------------------------------\n \n");


    }

    public static void exitGame() {
        System.out.println("Thank you for playing!");
        System.exit(0);
    }

    public static void showBoard(int[][] gameboard) {
        for(int i = 0; i < gameboard.length; i++) {
            System.out.print("| ");
            for (int j=0; j < gameboard.length; j++) {
                System.out.print(gameboard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("+--------");
    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public static boolean hasWon() {
        // checks if the user has one of not
        return true;
    }


}
