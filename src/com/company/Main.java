package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question("Czy Polska leży w Europie", true));
        questionList.add(new Question("2+2=4?", true));
        questionList.add(new Question("Is dog a fish?", false));
        questionList.add(new Question("Is Java OOP language?", true));

        int score = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer yes or no: \n");

        for(Question question: questionList){
            System.out.println(question.getContent());
            String answer = scanner.nextLine();
            if((answer.equals("yes") && question.isCorrect()) || (answer.equals("no") && !question.isCorrect())){
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Sorry, wrong answer!");
            }
        }
        System.out.println("**********");
        System.out.println("Your final score is: " + score + "/4");

    }
}
