package com.assignment;

import java.util.regex.Pattern;

public class Validation {
    private static final String NUMBER_REG = "^[0-9]*$";
    private static final String DIFFICULTY_REG = "^[3-5]*$";


    public int validateDifficulty(String difficulty) throws Exception {
        if (!Pattern.matches(DIFFICULTY_REG, difficulty)) {
            throw new BadInputException("3 ~ 5 의 숫자만 입력해 주세요 !");
        }

        return Integer.parseInt(difficulty);
    }


    public void validateTryNumber(String tryNum, int difficulty) throws Exception {
        //문자를 입력했을때 오류
        for (String numbers : tryNum.split("")) {
            if (!Pattern.matches(NUMBER_REG, numbers)) {
                throw new BadInputException("숫자를 입력해 주세요 !");
            }
        }

        //자리수가 다를때 오류
        if (tryNum.length() != difficulty) {
            throw new BadInputException(difficulty + " 자릿수의 수를 입력해 주세요 !");
        }

        //0이 포함되어 있을때 오류
        if (tryNum.contains("0")) {
            throw new BadInputException("0은 입력하실 수 없습니다 !");
        }

        //중복값이 있을때 오류
        StringBuilder str = new StringBuilder(tryNum);
        for (String c : tryNum.split("")) {
            str.deleteCharAt(str.indexOf(c));  //첫 문자를 삭제한 후 삭제한 문자와 같은 값이 있는지 비교
            if (str.indexOf(c) != -1) {
                throw new BadInputException("중복된 값을 입력하셨습니다 !");
            }

        }
    }
}