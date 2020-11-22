package ee.bcs.valiit.tasks.bankController2.classes;

public class User {
    private String email;
    private String name;
    private int age;

    public User(String email, String name, int age) {
        this.email = email;
        this.name = name;
        this.age = age;
    }

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}