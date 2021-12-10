package simplestClasses.solution2;

    /*
    Класс Test2 решает 2 задачу из 4 модуля Introduction to Java Online - EPAM
    */

public class Test2 {
    private String name;
    private int age;

    /*
    Конструктор для инициализации полей по умолчанию*/
    public Test2() {
        this.name = "Name";
        this.age = 1;
    }

    /*
    Конструктор с входными параметрами     */
    public Test2(String name, int age) {
        this.name = name;
        this.age = age;
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

    /*
    В сеттере переменной age добавляем проверку значения*/
    public void setAge(int age) {
        try {
            if (age < 1 || age > 110) throw new Exception("Недопустимое значение возраста");
            this.age = age;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    Для коректного отображеня данных*/
    @Override
    public String toString() {
        return String.format("Имя пользователя: %s \nВозраст пользователя: %d", getName(), getAge());
    }
}