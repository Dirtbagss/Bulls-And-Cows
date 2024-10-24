package com.assignment;

import java.util.Scanner;

public class GameController {
    private static GameConsole console = new GameConsole();

    public static boolean gameStart() throws Exception {
        Scanner sc = new Scanner(System.in);


        boolean result = false;


            System.out.println("<< 환영합니다! 원하시는 번호를 입력해주세요 ! >>");
            System.out.println("( 1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기 )");
            int type = sc.nextInt();


            switch (type) {
                case 1:
                    System.out.print("<< 난이도를 설정해주세요. >>");
                    int difficulty = sc.nextInt();
                    int[] answers = console.createAnswer(difficulty);
                    System.out.println( "\n <<" + difficulty + " 자릿수 게임을 시작합니다. >>");


                    while(!result) {
                        int[] tryNums = console.typeNum(difficulty);
                        result = console.playGame(answers, tryNums);
                    }
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
