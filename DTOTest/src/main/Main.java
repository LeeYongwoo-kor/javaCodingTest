package DTOTest.src.main;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import DTOTest.src.dto.Homeless;
import DTOTest.src.dto.Person;
import DTOTest.src.dto.Student;

public class Main {
    public static void main(String[] args) {
        Homeless homeless = new Homeless();
        Student student = new Student();
        Person person = new Person();

        homeless.setName("K I M");
        homeless.setAge(50);
        student.setName(" LEE ");
        student.setScore(100);
        student.setGrade("  A A");
        person.setName("PA RK  ");
        person.setAge(28);
        person.setProperty(5000);

        homeless = (Homeless) getDtoValue(homeless);
        student = (Student) getDtoValue(student);
        person = (Person) getDtoValue(person);

        System.out.println(homeless.getAge());
        System.out.println(homeless.getName());
        System.out.println(student.getGrade());
        System.out.println(student.getName());
        System.out.println(student.getScore());
        System.out.println(person.getAge());
        System.out.println(person.getName());
        System.out.println(person.getProperty());
    }

    public static Object getDtoValue(Object object) {
        Object obj = object;
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(object) instanceof String) {
                    String value = ((String) field.get(object)).replaceAll("\\s", "");
                    field.set(obj, value);
                }
            }
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return obj;
    }
}
