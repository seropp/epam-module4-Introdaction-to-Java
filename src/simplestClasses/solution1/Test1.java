package simplestClasses.solution1;

    /**
    Класс Test1 решает 1 задачу из 4 модуля Introduction to Java Online - EPAM:
    Методы реализованные в классе Test1:
    print() - для отображения переменных
    setNum(double number1), setNum2(double number2) - для изменения пременных
    sum() - возвращает сумму переменных
    max() - врзвращает переменную с наибольщим значением
    */

public class Test1 {
    /*
    Так как в задании точно не сказанно какой тип должны иметь переменне,
    мы будем использовать примитивы типа double.
    Мы могли бы использовать generics <T extends Number>,
    но это бы привело к усложнению синтаксиса и
    дополнительным расходам памяти */
    private double num1;
    private double num2;


    /*
    Так как в условии ничего не сказно про конструкторы,
    мы реализуем сразу два: по умолчанию и конструктор с 2 входными аргументами*/
    public Test1() {
    }

    public Test1(double number1, double number2) {
        this.num1 = number1;
        this.num2 = number2;
    }

    public void setNum1(double number1) {
        this.num1 = number1;
    }

    public void setNum2(double number2) {
        this.num2 = number2;
    }

    /*
    В методе для отображения переменных используем метод printf()
    В самаом методе используем вывод строки (s),
    вместо отображения дробного числа черещ (f) */
    public void printNumbers() {
        System.out.printf("First number: %s Second number: %s", num1, num2);
    }

    /*
    Возвращает сумму переменных.*/
    public double sum() {
        return num1 + num2;
    }

    /*
    Возвращает наибольшую из переменных
    Внутри метода вызывается метод Math.max()*/
    public double max() {
        return Math.max(num1, num2);
    }

    @Override
    public String toString() {
        return String.format("First number: %s Second number: %s", num1, num2);
    }
}
