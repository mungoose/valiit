package ee.bcs.valiit.tasks.oldOnes;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String [] args){
        Map<String, BigDecimal> accounts = new HashMap();
        accounts.put("EE2344", BigDecimal.ZERO);        //BigDecimali asemel kogu accounti objekt
        accounts.put("EE3444", new BigDecimal("398989499"));
        System.out.println(accounts.get("EE3444"));
    }
}
