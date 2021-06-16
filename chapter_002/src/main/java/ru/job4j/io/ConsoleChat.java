package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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


    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (PrintWriter writeToLog = new PrintWriter(path)) {
            Scanner in = new Scanner(System.in);
           while (botStatus) {
               String askFromUser = in.nextLine();
               String tempAnswers = botLogic();
               switch (askFromUser) {
                   case (STOP):
                       writeToLog.println(askFromUser);
                       System.out.println("Я, пожалуй, отойду ...");
                       botIsOnline = false;
                       break;
                   case (CONTINUE):
                       writeToLog.println(askFromUser);
                       System.out.println("Я снова тут.");
                       botIsOnline = true;
                       break;
                   case (OUT):
                       writeToLog.println(askFromUser);
                       botStatus = false;
                       break;
                   default:
                       if (botIsOnline) {
                           writeToLog.println(askFromUser + " " + tempAnswers);
                           System.out.println(tempAnswers);
                       }
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
           }


    public String botLogic() throws IOException {
       List<String> rsl = Files.readAllLines(Paths.get(botAnswers));
      return rsl.get(ThreadLocalRandom.current().nextInt(0, rsl.size()-1));
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./botTest.txt", "./botAnswer.txt");
        cc.run();
    }
}
