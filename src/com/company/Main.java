package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame {

    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestion;

    public Main(){ //konstruktor
        super("Milionerzy"); //ustawia tytuł
        setSize(500,500); //ustawia wielkość okna
        setDefaultCloseOperation(1); //sprawia, że działa przycisk exit
        setVisible(true); //pokazuje okno
        buttonYes = new JButton("TAK");
        buttonNo = new JButton("NIE");
        labelQuestion = new JLabel("Czy Polska lezy w Europie",0);
        add(labelQuestion);
        add(buttonYes);
        add(buttonNo);
        setLayout(new GridLayout(3,1));

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
            }
        });

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
