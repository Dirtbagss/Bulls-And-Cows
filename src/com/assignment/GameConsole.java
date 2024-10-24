package com.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameConsole {

    int tryCnt = 0;
    boolean gameOver;

    List<Integer> tryCntList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // 1. 정답 숫자 생성하기
    public int[] createAnswer(int difficulty){

        int[] answers = new int[difficulty];

        Random random = new Random();

        for(int i = 0; i < answers.length; i++) {
            answers[i] = random.nextInt(9) + 1;
            for (int j = 0; j < i; j++) {
                if (answers[i] == answers[j]) {
                    i--;
                }
            }
        }
        for(int i : answers){
            System.out.print(i);
        }

        return answers;
    }

    // 2. 정답을 맞추기 위해 숫자를 입력하기
    public int[] typeNum(int difficulty){

        System.out.print(difficulty + " 자리 숫자를 입력해 주세요. : ");

        int tryNum = sc.nextInt();

        String[] tryNums = String.valueOf(tryNum).split("");
        int[] tryNumArr = new int[tryNums.length];
        for(int i = 0; i<tryNums.length; i++){
            tryNumArr[i] += Integer.parseInt(tryNums[i]);
        }

        return tryNumArr;
    }


    // 3. 결과값 출력 및 게임 로직 적용하기
    public boolean playGame(int[] answers, int[] tryNums){
        int strikeCnt = 0;
        int ballCnt = 0;
        boolean result;

        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < answers.length; j++){
                if(answers[i] == tryNums[j]){
                    if(i == j){
                        strikeCnt++;
                    }else{
                        ballCnt++;
                    }
                }
            }
        }

        tryCnt++;

        if(strikeCnt == 0 && ballCnt == 0){
            System.out.println("Out 입니다.");
            result = true;
        } else if (strikeCnt == answers.length){
            tryCntList.add(tryCnt);
            tryCnt = 0;
            System.out.println("정답입니다 !");

            result = true;

        } else {
            System.out.println(strikeCnt + " 스트라이크 " + ballCnt + " 볼 입니다.");
            result = false;
        }

        return result;
    }
    // 4. 입력값이 유효한지 검사하기

    // 5. 게임 기록 통계

    public void gameLog(){
        System.out.println("\n << 게임 기록을 조회합니다. >>");


        if(tryCntList.isEmpty()){
            System.out.println("------------------------------------------------------");
            System.out.println("게임기록이 없습니다.");
            System.out.println("------------------------------------------------------");
        }else{
        System.out.println("------------------------------------------------------");
        for(int i = 0; i < tryCntList.size(); i++){
            System.out.println((i + 1) + " 번째 게임도전 횟수 : " + tryCntList.get(i));
        }
        System.out.println("------------------------------------------------------");
            }
    }

    public boolean exit(){
        System.out.println("프로그램을 종료합니다.");
        return true;
    }

    // TODO LIST
    //  중복값 예외처리 추가
    //  입력값 유효성 검사

}
