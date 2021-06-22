package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private boolean botStatus = true;
    private boolean botIsOnline = true;
    private List<String> answer = new ArrayList<>();


    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        Scanner in = new Scanner(System.in);
        List<String> rsl = Files.readAllLines(Paths.get(botAnswers));
        while (botStatus) {
            String askFromUser = in.nextLine();
            String tempAnswers = botLogic(rsl);
            switch (askFromUser) {
                case (STOP):
                    answer.add(askFromUser);
                    System.out.println("Я, пожалуй, отойду ...");
                    botIsOnline = false;
                    break;
                case (CONTINUE):
                    answer.add(askFromUser);
                    System.out.println("Я снова тут.");
                    botIsOnline = true;
                    break;
                case (OUT):
                    answer.add(askFromUser);
                    botStatus = false;
                    break;
                default:
                    if (botIsOnline) {
                        answer.add(askFromUser + " " + tempAnswers);
                        System.out.println(tempAnswers);
                    }
            }
        }
        answerList(answer);
    }


    public void answerList(List<String> answer) {
        try (PrintWriter writeToLog = new PrintWriter(path)) {
            for (String s : answer) {
                writeToLog.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String botLogic(List<String> botAnswer) {
        return botAnswer.get(ThreadLocalRandom.current().nextInt(0, botAnswer.size()));
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("./botTest.txt", "./botAnswer.txt");
        cc.run();
    }
}
