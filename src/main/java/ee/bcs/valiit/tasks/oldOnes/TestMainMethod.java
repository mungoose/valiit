package ee.bcs.valiit.tasks.oldOnes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMainMethod {
    public static void main(String[] args) {

//        stringMethods();
//        stringList();
//        stringMap();
//        comparisonTest();
//        bigMethods();
        test();
    }

    private static void test() {
        System.out.println("test");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }


    public static void stringMethods() {

        String a = "Hello";
        String b = "Hello2";

        System.out.println("String a is equal to String b: " + a.equals(b));
        System.out.println();

        String sentence = "A rather long, and yet so little informative sentence.";

        System.out.println("A substring would be: " + sentence.substring(0, 14));
        System.out.println("The length of that particular sentence is " + sentence.length());
        System.out.println("The character at position 24 is " + sentence.charAt(13));
    }

    public static void stringList() {

        List<String> testList = new ArrayList<>();
        testList.add("New York");
        testList.add("Los Angeles");
        testList.add("Puerto Praga");
        testList.set(2, "Tallinn");
        testList.size();

        System.out.println(testList);
        System.out.println(testList.get(2));
        System.out.println(testList.size());
    }

    public static void stringMap() {

        Map<String, String> mapOfStrings = new HashMap<>();
        mapOfStrings.put("NumberOne", "Is this thing");

        System.out.println(mapOfStrings.get("NumberOne"));
    }

    public static void comparisonTest() {

        String a = "This is a test";
        String b = "This is a tfst";

        if (a.compareTo(b) < 0) {
            System.out.println("a is smaller");
        } else if (a.compareTo(b) == 0) {
            System.out.println("a and b are equal");
        } else {
            System.out.println("a is bigger");
        }

    }

    public static void bigMethods() {

        BigDecimal bigOne = BigDecimal.valueOf(1288.88);
        BigDecimal bigAnotherOne = BigDecimal.TEN;

        BigDecimal sum = bigOne.add(bigAnotherOne);
        System.out.println("1288.88 plus TEN is " + sum);
        System.out.println();

        BigDecimal sum2 = bigOne.subtract(bigAnotherOne);
        System.out.println("1288.88 minus TEN is " + sum2);
        System.out.println();

        BigDecimal sum3 = bigOne.multiply(bigAnotherOne);
        System.out.println("1288.88 times TEN is " + sum3);
        System.out.println();

        BigDecimal sum4 = bigOne.divide(bigAnotherOne);
        System.out.println("1288.88 divided by TEN is " + sum4);
        System.out.println();
        System.out.println();

        BigInteger bigIntOne = BigInteger.valueOf(1299);
        BigInteger bigIntAnotherOne = BigInteger.TWO;

        System.out.println("BigInteger Division example result: " + bigIntOne.divide(bigIntAnotherOne));

    }


}
