package simplestClasses.solution4;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Класс Train решает 4 задачу из 4 модуля Introduction to Java Online - EPAM:
 * <p>
 * Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
 * из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
 * номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */
class Main {
    public static void main(String[] args) {


        Train[] trains = {
                new Train("New York", 1038, LocalDateTime.of(2021, 12, 21, 20, 40)),
                new Train("Boston", 1142, LocalDateTime.of(2022, 1, 2, 5, 30)),
                new Train("New York", 1022, LocalDateTime.of(2021, 12, 22, 10, 0)),
                new Train("Florida", 1302, LocalDateTime.of(2021, 12, 29, 11, 30)),
                new Train("Columbus", 1628, LocalDateTime.of(2021, 12, 16, 7, 20)),
        };
        Train.printInfo(trains);
        System.out.println();
        System.out.println();

        Train.sortByNumber(trains);
        System.out.println();
        System.out.println();

        Train.printInfo(trains);
    }
}

public class Train{
    private String destination;
    private int trainNumber;
    private ZonedDateTime zonedDateTime;


    public Train(String destination, int trainNumber, LocalDateTime departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        zonedDateTime = ZonedDateTime.of(departureTime, ZoneId.systemDefault());
    }


    public static Train[] sortByNumber(Train[] trains) {
        return Arrays.stream(trains).sorted(Comparator.comparing(train -> train.trainNumber)).toArray(Train[]::new);
    }
    public static Train[] sortByDestination(Train[] trains) {
        return Arrays.stream(trains).sorted(Comparator.<String,Integer>comparing(train -> train.destination)
                .thenComparing(train -> train.trainNumber))
                .toArray(Train[]::new);

    }
    public static void printInfo(Train... trains) {
        for (Train train : trains) {
            System.out.printf("DEPARTURE TO %tI:%Tm(%Tp) BY LOCAL TIME %td %TB(%ta)\tTRAIN NUMBER %-5d DESTINATION: %5S\n"
                    , train.zonedDateTime, train.zonedDateTime, train.zonedDateTime, train.zonedDateTime
                    , train.zonedDateTime, train.zonedDateTime, train.trainNumber, train.destination);
        }
    }


    @Override
    public String toString() {
        String time = String.format("DEPARTURE TO %tI:%Tm(%Tp) BY LOCAL TIME %td %TB(%ta) ",
                zonedDateTime, zonedDateTime, zonedDateTime, zonedDateTime, zonedDateTime, zonedDateTime);
        return null;
    }


}
