package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(10) + 1;
        int userNumber = -1;
        int playAgain = 1;
        String userGuessedText = "";
        String isNumberGreaterText = "";
        boolean isNotNumberEntered = false;
        String isNotNumberEnteredText = "Вы ввели не число! Игра начнется заново!";
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Загадано число от 1 до 10. Угадайте его.");
            for (int i = 0; i < 3; i++) {
                System.out.println("У вас попытка " + (i+1) + ".");

                try {
                    if (isNotNumberEntered) {
                        isNotNumberEntered = false;
                        sc.close();
                        sc = new Scanner(System.in);
                    }
                    userNumber = sc.nextInt();
                }
                catch (Exception e) {
                    System.out.println(isNotNumberEnteredText);
                    isNotNumberEntered = true;
                    break;
                }

                if (userNumber == number) {
                    userGuessedText = "угадали!";
                    break;
                }
                else {
                    isNumberGreaterText = (userNumber > number) ? "больше" : "меньше";
                    System.out.println("Вы не угадали! Ваше число " + isNumberGreaterText + " чем загаданное!");
                    userGuessedText = "не угадали!";
                }
            }

            if (isNotNumberEntered) {
                playAgain = 1;
            }
            else {
                System.out.println("Вы " + userGuessedText + " Число " + number + "!");
                System.out.println("Повторить игру еще раз? 1 - да / 0 - нет.");

                try {
                    playAgain = sc.nextInt();
                }
                catch (Exception e) {
                    System.out.println(isNotNumberEnteredText);
                    playAgain = 1;
                }

            }

        } while (playAgain==1);
        sc.close();


    }
}
