package ee.bcs.valiit.tasks;

import ee.bcs.valiit.tasks.tasks.Lesson2;
import ee.bcs.valiit.tasks.tasks.Lesson3;
import ee.bcs.valiit.tasks.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("calculations")
@RestController
public class TestController {

    @GetMapping("fibonacci")
    public int test(@RequestParam("nr") int nr) {
        return Lesson2.fibonacci(nr);
    }

    @GetMapping("pairs")
    public List<Integer> pairs(@RequestParam("number") int in) {
        return Lesson2.exercise2(in);
    }

    @GetMapping("exc-5") //localhost:8080/calculations/exc-5?nr1=i&nr2=j
    public List<Integer> exc5(@RequestParam("nr1") int i,
                              @RequestParam("nr2") int j) {
        return Lesson2.exercise5(i, j);
    }

    @GetMapping("sum") //localhost:8080/calculations/sum?nr1=x&nr2=y
    public int sum(@RequestParam("nr1") int x,
                   @RequestParam("nr2") int y) {
        return Lesson3.uusSumma(x, y);
    }

    // localhost:8080/users/5/contracts/8?filterBy=status
    @GetMapping("/users/{nr1]/contracts/{nr2}")
    public String aaa(@PathVariable("nr1") int nr1,
                      @PathVariable("nr2") int nr2,
                      @RequestParam("filterBy") String v1) {
        return "";
    }

    /*
    /company/5/employee/8/contact/5

    /?employeeId=8&somethingElse=tere

    /company/6?company=5&a=a&b=b
     */

    @GetMapping("/company/{nr1}/employee/{nr2}/contact/{nr3}")
    public String exc1(@PathVariable("nr1") int nr1,
                       @PathVariable("nr2") int nr2,
                       @PathVariable("nr3") int nr3) {
        return "";
    }

    public String exc2(@RequestParam("employeeId") int nr,
                       @RequestParam("somethingElse") String text) {
        return "";
    }

    @GetMapping("/company/{nr]")
    public String exc3(@PathVariable("nr") int nr,
                       @RequestParam("company") int nbr,
                       @RequestParam("a") String a,
                       @RequestParam("b") String b) {
        return "";
    }

    //http://localhost:8080/calculations/a/random/a/something/42/c?a=other&b=112
    @GetMapping("a/*/a/{a}/{b}/c")
    public String test(@PathVariable("a") String a,
                       @RequestParam("a") String aa,
                       @RequestParam("b") Integer bb,
                       @PathVariable("b") Integer b) {
        return "testing1234";
    }


    @GetMapping("minusPlus")     //localhost:8080/calculations/minusPlus?i=4
    public List<Integer> minusPlus(@RequestParam("i") int i) {
        return Lesson2.plusMinus(i);
    }

    @GetMapping("evenFibo")     //localhost:8080/calculations/evenFibo?in=13
    public int evenFibo(@RequestParam("in") int x) {
        return Lesson3Hard.evenFibonacci(x);
    }

    @GetMapping("dto_test")     //localhost:8080/calculations/dto_test?Brand=Yamaha&Model=MT07&AnyGood=true
    public Bikes getBikes(@RequestParam("Brand") String brand,
                          @RequestParam("Model") String model,
                          @RequestParam("AnyGood") boolean anyGood) {

        Bikes one = new Bikes(brand, model, anyGood);
        return one;
    }

    @PostMapping("dto_test")     //localhost:8080/calculations/dto_test?Brand=Yamaha&Model=MT07&AnyGood=true
    public List<Bikes> getBikesPost(@RequestParam("Brand") String brand,
                                    @RequestParam(value = "Model", required = false) String model,
                                    @RequestParam(value = "AnyGood", required = false) boolean anyGood,
                                    @RequestBody Bikes bikesToo) {
        List<Bikes> bikesTooList = new ArrayList<>();
        Bikes first = new Bikes(brand, model, anyGood);
        bikesTooList.add(bikesToo);
        bikesTooList.add(first);
        return bikesTooList;
    }

    List<Employee> employeeList = new ArrayList<>();

    @PostMapping("employee")        //localhost:8080/employee
    public List<Employee> postEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return employeeList;
    }

    @GetMapping("employee")
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @GetMapping("employee/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeList.get(id);
    }

    @PutMapping("employee/{id}")
    public Employee replaceEmployee(@PathVariable("id") int id,
                                    @RequestBody Employee employee) {
        return employeeList.set(id, employee);
    }

    @DeleteMapping("employee/{id}")
    public Employee removeEmployee(@PathVariable("id") int id) {
        return employeeList.remove(id);
    }

    @GetMapping("morse")         //localhost:8080/morse?text=abcdefg
    public List<String> textToMorse(@RequestParam("text") String text){
        return Lesson3Hard.morseCode(text);
    }





 /*   @PostMapping("employee/{id}")
    public List<Employee> getEmployees(@RequestBody Employee employee) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        return employeeList;
    }
*/

}