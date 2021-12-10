package simplestClasses.solution3;

import java.util.Arrays;

class TestSolution3 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Jones", "D.C.", 103, new int[]{8, 2, 10, 5, 2}),
                new Student("Musk", "T.S.", 105, new int[]{9, 9, 10, 9, 8}),
                new Student("Smith", "C.D.", 103, new int[]{8, 3, 10, 5, 2}),
                new Student("Miller", "B.B.", 103, new int[]{8, 9, 10, 5, 2}),
                new Student("Anderson", "A.D.", 105, new int[]{8, 9, 10, 5, 2}),
                new Student("Martin", "C.U.", 103, new int[]{8, 9, 1, 5, 6}),
                new Student("White", "V.E.", 105, new int[]{8, 9, 10, 8, 9}),
                new Student("White", "I.V.", 105, new int[]{8, 9, 10, 9, 9}),
                new Student("Thomas", "W.A.", 103, new int[]{10, 9, 10, 8, 10}),
        };

    }
}

/**
 * Класс Student решает 3 задачу из 4 модуля Introduction to Java Online - EPAM:
 * <p>
 * Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
 * из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
 * номеров групп студентов, имеющих оценки, равные только 9 или 10.
 * <p>
 * Массив объектов создвн в классе TestSolution3
 */
public class Student {
    private String lastName;
    private String initials;
    private int groupNumber;
    private int[] academicPerformance = new int[5];

    public Student(String lastName, String initials, int groupNumber, int[] academicPerformance) {
        if (academicPerformance.length != 5)
            throw new ArrayIndexOutOfBoundsException("Incorrect number of student grades");
        this.initials = initials;
        this.lastName = lastName;
        this.groupNumber = groupNumber;
        this.academicPerformance = academicPerformance;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int[] getAllGraduates() {
        return this.academicPerformance.clone();
    }

    public void setAllGraduates(int[] academicPerformance) {
        if (academicPerformance.length != 5)
            throw new ArrayIndexOutOfBoundsException("Incorrect number of student grades");
        this.academicPerformance = academicPerformance.clone();
    }

    /**
     * Осуществляет поиск студентов с подходящими оценками и выводит их не печать
     *
     * @param students array of students
     * @param minGrade comparison grade
     */
    public static void searchStudents(Student[] students, int minGrade) {
        try {
            if (minGrade < 0 || minGrade > 10) throw new Exception("Некоректное значение оценки");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (Student student : students) {
            if (checkingGrades(student, minGrade) != null)
                System.out.printf("Student surname: %-10s \tGroup number: %5d\n Minimum grade: "
                        , student.lastName, student.groupNumber);
        }
    }

    /**
     * Вспомогатеьный метод для осуществления сравнения оценок студента
     * с заданой оценкой.
     *
     * @param student         object of type Student
     * @param minStudentGrade comparison grade
     * @return returns an object of type Student, that passes the test, otherwise null
     */
    private static Student checkingGrades(Student student, int minStudentGrade) {
        for (int grade : student.academicPerformance) {
            if (grade < minStudentGrade) return null;
        }
        return student;
    }

    /**
     * Осуществляет печать информации о каждом студенте
     *
     * @param students varargs of Student
     */
    public static void InfoAboutAllStudents(Student... students) {
        if (students == null) {
            System.out.println("No students found");
            return;
        }
        for (Student s : students)
            System.out.printf("Last name: %-10s Initial:%5s \tGroup number: %5d\n", s.lastName, s.initials, s.groupNumber);
    }

    @Override
    public String toString() {
        return String.format("Last name: %-10s Initial:%5s \tGroup number:%5d", lastName, initials, groupNumber);
    }
}
