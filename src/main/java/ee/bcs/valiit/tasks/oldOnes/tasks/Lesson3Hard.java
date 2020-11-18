package ee.bcs.valiit.tasks.oldOnes.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;

// Enne kui seda tegema hakkad tee ära Lesson 2 (välja arvatud ülesanded 6, 8, 9)
public class Lesson3Hard {
    public static void main(String[] args) {
        //evenFibonacci(13);
        //randomGame();
        //morseCode("This is just a test");
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        //        Lesson2.fibonacci()
        int first = 0;
        int second = 1;
        int evenSum = 0;
        for (int i = 3; i <= x; i++) {
            int sum = first + second;
            if (sum % 2 == 0) {
                evenSum += sum;
            }
            first = second;
            second = sum;


        }
        return evenSum;
    }

    public static void randomGame() {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
        Random random = new Random();
        int i = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the number between 0 and 100");
        System.out.println("Type your initial guess and hit \"Enter\"");
        int guess = scanner.nextInt();
        int counter = 1;

        while (i != guess) {
            if (i < guess) {
                System.out.println("Wrong. Your number is too big.");
            } else {
                System.out.println("Wrong. Your number is too small.");
            }
            guess = scanner.nextInt();
            counter++;
        }
        System.out.println("Congratulations! You guessed the number in " + counter + " tries.");
    }

    public static List<String> morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        List<String> result = new ArrayList<>();
        String upCaseText = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            if (Character.compare(upCaseText.charAt(i), 'A') == 0) {
                result.add("  .-  ");
            } else if (Character.compare(upCaseText.charAt(i), 'B') == 0) {
                result.add("  -...  ");
            } else if (Character.compare(upCaseText.charAt(i), 'C') == 0) {
                result.add("  -.-.  ");
            } else if (Character.compare(upCaseText.charAt(i), 'D') == 0) {
                result.add("  -..  ");
            } else if (Character.compare(upCaseText.charAt(i), 'E') == 0) {
                result.add("  .  ");
            } else if (Character.compare(upCaseText.charAt(i), 'F') == 0) {
                result.add("  ..-.  ");
            } else if (Character.compare(upCaseText.charAt(i), 'G') == 0) {
                result.add("  --.  ");
            } else if (Character.compare(upCaseText.charAt(i), 'H') == 0) {
                result.add("  ....  ");
            } else if (Character.compare(upCaseText.charAt(i), 'I') == 0) {
                result.add("  ..  ");
            } else if (Character.compare(upCaseText.charAt(i), 'J') == 0) {
                result.add("  .---  ");
            } else if (Character.compare(upCaseText.charAt(i), 'K') == 0) {
                result.add("  -.-  ");
            } else if (Character.compare(upCaseText.charAt(i), 'L') == 0) {
                result.add("  .-..  ");
            } else if (Character.compare(upCaseText.charAt(i), 'M') == 0) {
                result.add("  --  ");
            } else if (Character.compare(upCaseText.charAt(i), 'N') == 0) {
                result.add("  -.  ");
            } else if (Character.compare(upCaseText.charAt(i), 'O') == 0) {
                result.add("  ---  ");
            } else if (Character.compare(upCaseText.charAt(i), 'P') == 0) {
                result.add("  .--.  ");
            } else if (Character.compare(upCaseText.charAt(i), 'Q') == 0) {
                result.add("  --.-  ");
            } else if (Character.compare(upCaseText.charAt(i), 'R') == 0) {
                result.add("  .-.  ");
            } else if (Character.compare(upCaseText.charAt(i), 'S') == 0) {
                result.add("  ...  ");
            } else if (Character.compare(upCaseText.charAt(i), 'T') == 0) {
                result.add("  -  ");
            } else if (Character.compare(upCaseText.charAt(i), 'U') == 0) {
                result.add("  ..-  ");
            } else if (Character.compare(upCaseText.charAt(i), 'V') == 0) {
                result.add("  ...-  ");
            } else if (Character.compare(upCaseText.charAt(i), 'W') == 0) {
                result.add("  .--  ");
            } else if (Character.compare(upCaseText.charAt(i), 'X') == 0) {
                result.add("  -..-  ");
            } else if (Character.compare(upCaseText.charAt(i), 'Y') == 0) {
                result.add("  -.--  ");
            } else if (Character.compare(upCaseText.charAt(i), 'Z') == 0) {
                result.add("  --..  ");
            } else {
                result.add("|");
            }

        }
        System.out.println(result);
        return result;
    }
}