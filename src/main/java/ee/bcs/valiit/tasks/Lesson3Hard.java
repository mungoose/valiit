package ee.bcs.valiit.tasks;

import java.util.Random;

// Enne kui seda tegema hakkad tee ära Lesson 2 (välja arvatud ülesanded 6, 8, 9)
public class Lesson3Hard {
    public static void main(String[] args) {
        //evenFibonacci(13);
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
        System.out.println(i);
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        return "";
    }
}
