package sampleCode.CodeWithTests;

public class MyClass {
    private String name;
    private int age;

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "My name is " + name + " and I'm " + age + " years old.";
    }
}
