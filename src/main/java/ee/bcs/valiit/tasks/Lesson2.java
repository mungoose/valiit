package ee.bcs.valiit.tasks;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Lesson2 {

    public static void main(String[] args) throws Exception {
        //test();
        //exercise5(900, 1000);
        //exercise7();
        exercise8();
    }

    public static void exercise1() {
        // TODO loo 10 elemendile täisarvude massiv
        // TODO loe sisse konsoolist 10 täisarvu
        // TODO trüki arvud välja vastupidises järjekorras
        int[] numbers;
        numbers = new int[10];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int a = scanner.nextInt();
            numbers[i] = a;
        }
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
    }

    public static void exercise2() {
        // TODO prindi välja x esimest paaris arvu
        // Näide:
        // Sisend 5
        // Väljund 2 4 6 8 10
        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();
        for (int i = 2; i < ((2 * in) + 1); i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void exercise3(int x, int y) {
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
        // TODO näiteks x = 3 y = 3
        // TODO väljund
        // 1 2 3
        // 2 4 6
        // 3 6 9
        for (int i = 1; i <= y; i++) {
            System.out.println();
            for (int j = 1; j <= x; j++) {
                System.out.print(j * i + " ");
            }
        }
    }

    public static int fibonacci(int n) {
        // TODO
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return first;
    }

    public static int sequenceLength(int n) {
        int count = 0;
        while (n != 1) {
            count++;
            if (n % 2 != 0) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
        }
        return count + 1;
    }

    public static void exercise5(int i, int j) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        //TODO 1 (tee alamfunktsioon), mis leiab 3n+1 sequenci pikkuse
        //kui on paaris, jaga 2-ga, kui on paaritu korruta 3+1-ga.
        //TODO 2 tee tsükkel mis leiab i -> j kõige suurema tsükkli pikkuse
        int length = 0;
        for (int k = i; k <= j; k++) {
            if (length < sequenceLength(k)) {
                length = sequenceLength(k);
            }
        }
        System.out.println(i + " " + j + " " + length);
    }

    public static void exercise6() {
            /*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.*/

        String a = "2018-01-13, 436";
        String[] b = a.split(", ");
        System.out.println(b[0]);
        System.out.println(b[1].trim());        //.trim() kustutab eest ja tagant kõik whitespace'id.
        Visits visits = new Visits(b[0], Integer.parseInt(b[0]));
        List<Visits> visit = new ArrayList<>();
        visit.add(visits);
        visit.sort(new Comparator<Visits>() {
            @Override
            public int compare(Visits o1, Visits o2) {
                return 0;
            }
        });


    }

    public static void exercise7() {
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820340 / 15 ) - 4 )
        BigDecimal a = new BigDecimal("1.89");
        BigDecimal b = new BigDecimal("394486820340");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");
        //BigDecimal division = b.divide(c, RoundingMode.CEILING);
        //BigDecimal substraction = division.subtract(d);
        //BigDecimal y = a.multiply(substraction);
        BigDecimal y = a.multiply((b.divide(c)).subtract(d));
        System.out.println(y);
    }

    public static void exercise8() throws Exception {
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.

        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.

        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */
        File file = new File("/Users/mongoose/IdeaProjects/valiit3/src/main/resources/test_data/nums.txt");
        Scanner scanner = new Scanner(file);

        BigInteger big = BigInteger.valueOf(0);
        big = scanner.nextBigInteger();
        while (scanner.hasNextLine()) {
            big = big.add(scanner.nextBigInteger());
            //System.out.println("Sum after a cycle: " + big);
        }
        System.out.println("Final sum: " + big);
    }

    public static void exercise9() {
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
    }

    public static void test() {
        int a = 2;
        int b = 4;

        a = a + b;
        b = a - b;
        a = a - b;
        /*
        a = a * b;
        b = a / b;
        a = a / b;
        */
        System.out.println(a + "/" + b);
    }

}
