package ee.bcs.valiit.tasks.tasks;

import java.util.Scanner;

public class Lesson1MathUtil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Type: min2, min3, max2, max3, abs, isEven:");
        System.out.println("Available calculations:");
        System.out.println("min2 - Minimum of two numbers");
        System.out.println("min3 - Minimum of three numbers");
        System.out.println("max2 - Maximum of two numbers");
        System.out.println("max3 - Maximum of three numbers");
        System.out.println("abs - Absolute number");
        System.out.println("isEven - Even or not");
        System.out.println("Write the shorthand, hit Enter and write the number(s):");
        String name = scanner.nextLine();
        switch (name) {
            case "min2":
                int first = scanner.nextInt();
                int second = scanner.nextInt();
                System.out.println("Smallest number of those is: " + min2(first, second));
                break;
            case "min3":
                first = scanner.nextInt();
                second = scanner.nextInt();
                int third = scanner.nextInt();
                System.out.println("Smallest number of those is: " + min3(first, second, third));
                break;
            case "max2":
                first = scanner.nextInt();
                second = scanner.nextInt();
                System.out.println("Biggest number of those is: " + max2(first, second));
                break;
            case "max3":
                first = scanner.nextInt();
                second = scanner.nextInt();
                third = scanner.nextInt();
                System.out.println("Biggest number of those is: " + max3(first, second, third));
                break;
            case "abs":
                first = scanner.nextInt();
                System.out.println("Absolute of your number is: " + abs(first));
                break;
            case "isEven":
                first = scanner.nextInt();
                if (isEven(first)) {
                    System.out.println("Your number is even");
                } else {
                    System.out.println("Your number is not even");
                }
                break;
            default:
                System.out.println("Something went wrong. Try again!");
        }
    }

    public static int min2(int a, int b) {
        // TODO tagasta a ja b väikseim väärtus
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public static int max2(int a, int b) {
        // TODO tagasta a ja b suurim väärtus
        if (a < b){
            return b;
        } else {
            return a;
        }
    }

    public static int abs(int a) {
        // TODO tagasta a absoluut arv
        if (a < 0) {
            return -a;
        }
        return a;
        //return Math.abs(a);   Alternatiivne variant.
    }

    public static boolean isEven(int a) {
        // TODO tagasta true, kui a on paaris arv
        // tagasta false kui a on paaritu arv
        //boolean isEven;
        return a % 2 == 0;
    }

    public static int min3(int a, int b, int c) {
        // TODO tagasta a, b ja c väikseim väärtus
        /* if (a <= b && a <= c){
            return a;
        } else if (b <= a && b <= c){
            return b;
        }
        return c; */
        return min2(min2(a, b), c);     // Kasutab varem deklareeritud funktsioone
    }

    public static int max3(int a, int b, int c) {
        // TODO tagasta a, b ja c suurim väärtus
        /* if (a >= b && a >= c){
            return a;
        } else if (b >= a && b >= c){
            return b;
        }
        return c; */
        return max2(max2(a, b), c);     // Kasutab varem deklareeritud funktsioone
    }

}
