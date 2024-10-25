package com.assignment;

import java.util.Scanner;

public class GameController {
    private static GameConsole console = new GameConsole();

    public static boolean gameStart() throws Exception {


            int type = console.printConsole();


            switch (type) {
                case 1:
                   console.setGame();
                   break;

                case 2:
                    console.gameLog();
                    break;
                case 3:
                   return console.exit();
                default:
                    System.out.println("잘못된 입력입니다.");
            }

            return false;
    }

}
