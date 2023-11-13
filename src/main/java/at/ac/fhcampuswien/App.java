package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void oneMonthCalendar(int days, int startingDay) {

        int spaces, cols = 0;

        for (spaces = 1; spaces < startingDay; spaces++) {
            System.out.print("   ");
        }

        cols = spaces;

        for (int i = 1; i <= days; i++) {
            System.out.printf("%2d ", i);

            if ((days == 30 && startingDay == 6 && cols >= 35) || (days == 28 && startingDay == 1 && cols >= 28)) {
                cols -= spaces;
            }


            if (cols % 7 == 0) {
                System.out.println();
            }
            cols++;
        }
        System.out.println();
    }

    public static long[] lcg(long seed) {
        long[] arrayRandom = new long[10];

        long m = (long) Math.pow(2, 31);
        long a = 1103515245;
        short c = 12345;

        for (int i = 0; i < arrayRandom.length; i++) {
            long rand = (a * seed + c) % m;
            arrayRandom[i] = rand;
            seed = rand; // we set seed as the previous result, array[i-1] also possible with i = 1 extra handled
        }

        for (int i = 0; i < arrayRandom.length; i++) {
            System.out.print(arrayRandom[i] + " ");
        }
        return arrayRandom;
    }

    public static void guessingGame(int numberToGuess) {

        Scanner scanner = new Scanner(System.in);

        int guessNumber = 1, userGuess, tries = 1;

        do {
            System.out.print("Guess number " + guessNumber + ": ");
            userGuess = scanner.nextInt();

            if (numberToGuess > userGuess && guessNumber != 10) {
                System.out.println("The number AI picked is higher than your guess.");
                tries++;
            } else if (numberToGuess < userGuess && guessNumber != 10) {
                System.out.println("The number AI picked is lower than your guess.");
                tries++;
            } else if (userGuess == numberToGuess && tries <= 10) {
                System.out.println("You won wisenheimer!");
                break;
            }
            if (guessNumber == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }
            guessNumber++;

        } while (true);

    }

    public static int randomNumberBetweenOneAndHundred() {
        return (int) (Math.random() * 100 + 1);
    }

    public static boolean swapArrays(int[] arrayOne, int[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) {
            return false;
        }
        int temp;

        for (int i = 0; i < arrayOne.length; i++) {
            temp = arrayOne[i];
            arrayOne[i] = arrayTwo[i];
            arrayTwo[i] = temp;
        }

        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));

        return true;
    }

    public static String camelCase(String s) {
        String formatted = "";
        char[] array = s.toCharArray();

        //System.out.println(Arrays.toString(array));

        if (array[0] >= 97 && array[0] <= 122) {
            array[0] -= 32;
        }

        for (int i = 0; i < s.length(); i++) {

            if (i > 0) {
                if (array[i] <= (char) 90 && array[i] >= (char) 65) {
                    if (array[i - 1] != (char) 32) {
                        array[i] += 32;
                    }
                }
                if (array[i] == (char) 32 && array[i + 1] >= 97) {
                    array[i + 1] -= 32;
                }
            }

            formatted = formatted + array[i];

        }

        formatted = formatted.replaceAll("[^a-zA-Z]", "");

        System.out.println(formatted);

        return formatted;

    }


    public static int checkDigit(int[] array) {
        int pruefZiffer, gewichtung, summe = 0, produkte, mod;

        for (int i = 0; i < array.length; i++) {
            gewichtung = i + 2;
            produkte = gewichtung * array[i];
            summe += produkte;
        }
        mod = summe % 11;
        pruefZiffer = 11 - mod;

        if (pruefZiffer == 10) {
            return 0;
        } else if (pruefZiffer == 11) {
            return 5;
        }
        return pruefZiffer;
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        long[] array = new long[]{};

        int[] arrayOne = {3, 9, 1, 5, 8};
        int[] arrayTwo = {41, 34, 233, 435};

        oneMonthCalendar(28, 1);

        System.out.println();

        lcg(43);

        System.out.println();

        guessingGame(randomNumberBetweenOneAndHundred());

        System.out.println();

        swapArrays(arrayOne, arrayTwo);

        String string = "i don nOt I Can do THIS    ???!! woRK";

        camelCase(string);

        System.out.println(checkDigit(arrayOne));
    }
}