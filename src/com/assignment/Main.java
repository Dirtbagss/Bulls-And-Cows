package com.assignment;


public class Main {
    public static void main(String[] args) throws Exception {
        boolean gameEnded = false;

        while (!gameEnded) {
            gameEnded = GameController.gameStart();
        }

    }
}