package Java;

import java.io.*;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [Name: " + name + ", Age: " + age + "]";
    }
}

class Student extends Person {
    private String studentId;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student [Name: " + super.toString() + ", Student ID: " + studentId + "]";
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        // Serialize objects to a binary file
        serializeObjects();

        // Deserialize objects from the binary file
        deserializeObjects();
    }

    private static void serializeObjects() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objects.ser"))) {
            Person person = new Person("Alice", 30);
            Student student = new Student("Bob", 20, "S12345");

            oos.writeObject(person);
            oos.writeObject(student);

            System.out.println("Objects serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeObjects() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objects.ser"))) {
            Person person = (Person) ois.readObject();
            Student student = (Student) ois.readObject();

            System.out.println("Deserialized Objects:");
            System.out.println(person);
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
