package ee.bcs.valiit.tasks.tasks;

import java.util.*;

public class Lesson3 {

    public static void main(String[] args) {
        //uusSumma(0,0);
        //System.out.println(sum(new int[]{5, 3, 8}));
        //System.out.println(factorial(6));
        sort(new int[]{22, 16, 8, 1, -4, -45, 33, -243, 55, 3, 0, 344, 1200, -433, 2, 4, 552, 3, 3, 56666, -3444, 89});
        //System.out.println(reverseString("Pneumonoultramicroscopicsilicovolcanoconiosis"));
        //System.out.println(isPrime(1));
    }

    private static void test(Map<String, String> testMap) {
        testMap.put("test", "test");
    }

    public static int uusSumma(int x, int y) {
        // TODO liida kokku ja tagasta x ja y väärtus
        return x + y;
    }

    public static int sum(int[] x) {
        // Todo liida kokku kõik numbrid massivis x
        if (x.length == 1) {
            return x[0];
        }
        int sum = x[0] + x[1];
        for (int i = 2; i < x.length; i++) {
            sum = sum + x[i];
        }
        return sum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
        int sum = 1;
        for (int i = 1; i <= x; i++) {
            sum = sum * i;
            //    System.out.println("\"i\" is now: " + i);
            //    System.out.println("       Sum is now: " + sum);
        }
        return sum;
        /*if (x == 1) {
            return x;
        }
        int sum = 2;
        for (int i = 1; i < (x-1); i++){
            sum = sum * (i+2);
        }*/
        /*int sum = x * (x - 1);
        for (int i = 3; i <= x; i++) {
            sum = sum * (x - (i - 1));
        } */
        //return sum;
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi
        // Näiteks {2, 6, 8, 1}
        // Väljund {1, 2, 6, 8}
        /*int[] b = new int[a.length];   //Create new array b
        int max = a[0];                //Initialize biggest int in array a as the first
        for (int i = 0; i < a.length; i++) {            //Loop through array a and assign biggest int to array b
            for (int j = 1; j < a.length; j++) {        //Loop through array a and find smallest int
                if (a[j] > max) {                       //Compare next in against the previous int in array a
                    max = a[j];                         //Update the smallest int
                }
            }
            for (int k = 0; k < a.length; k++){         //Initialize biggest in in array a to smallest possible value
                if (max == a[k]){
                    a[k] = Integer.MIN_VALUE;
                }
            }
            b[a.length-i] = max;                 //Assign biggest int to array b in the end
        }

        System.out.println("Min is:" + max); */
        for (int j = 0; j < (a.length * a.length); j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    a[i] = a[i] + a[i + 1];
                    a[i + 1] = a[i] - a[i + 1];
                    a[i] = a[i] - a[i + 1];
                }
            }
        }


        System.out.println(Arrays.toString(a));
        return new int[0];
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        // Näiteks:
        // a = "Test";
        // return tseT";
        String reversed = " ";
        for (int i = (a.length() - 1); i >= 0; i--) {
            reversed += a.charAt(i);
        }
        return reversed;
    }

    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

}
