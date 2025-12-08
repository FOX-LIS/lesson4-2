package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Список заводов
        List<Factory> factories = Arrays.asList(
                new Factory(1, "Uralmash", "Yekaterinburg", 1933, 12500, 240.5),
                new Factory(2, "GAZ", "Nizhny Novgorod", 1932, 45000, 1120.0),
                new Factory(3, "KAMAZ", "Naberezhnye Chelny", 1969, 60000, 890.3),
                new Factory(4, "Severstal", "Cherepovets", 1955, 82000, 2200.7),
                new Factory(5, "MMK", "Magnitogorsk", 1932, 70000, 1850.2),
                new Factory(6, "Lipetsk Steel", "Lipetsk", 1982, 32000, 950.1),
                new Factory(7, "AvtoVAZ", "Tolyatti", 1966, 97000, 630.8),
                new Factory(8, "SIBUR", "Moscow", 1995, 42000, 1680.0),
                new Factory(9, "TMK", "Moscow", 1999, 28000, 410.9),
                new Factory(10, "Rostselmash", "Rostov-on-Don", 1929, 15000, 320.6)
        );

        //Task 1
        System.out.println("Список названий всех заводов:");
        factories.stream()
                .map(Factory::getName)
                .forEach(System.out::println);
        System.out.println();

        //Task 2
        System.out.println("Заводы, основанные после 1970 года:");
        factories.stream()
                .filter(factory -> factory.getYearFounded() > 1970)
                .forEach(System.out::println);
        System.out.println();

        //Task 3
        System.out.print("Общее количество сотрудников на всех заводах: " +
                factories.stream()
                        .map(Factory::getEmployees)
                        .mapToInt(Integer::intValue)
                        .sum());
        System.out.println();

        //Task 4
        System.out.println("Завод с наибольшей годовой прибылью: " +
                factories.stream()
                        .max(Comparator.comparing(Factory::getProfit))
                        .orElse(null));
        System.out.println();

        //Task 5
        System.out.println("Список городов, где расположены заводы (без дубликатов):");
        factories.stream()
                .map(Factory::getCity)
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        //Task 6
        System.out.println("Сгруппировать заводы по городу (Map<String, List<Factory>>):");
        factories.stream()
                .collect(Collectors.groupingBy(Factory::getCity, Collectors.toList()))
                .entrySet()
                .forEach(System.out::println);
        System.out.println();

        //Task 7
        System.out.print("Есть ли хотя бы один завод с числом сотрудников > 90 000: ");
        boolean flag = factories.stream()
                .anyMatch(factory -> factory.getEmployees() > 90_000);
        System.out.println(flag ? "да" : "нет");
        System.out.println();

        //Task 8
        System.out.println("Получить Map: год основания → количество заводов, основанных в этот год:");
        Map<Integer, Long> collect = factories.stream()
                .collect(Collectors.groupingBy(Factory::getYearFounded, Collectors.counting()));
        collect.entrySet().forEach(System.out::println);
        System.out.println();

        //Task 9
        System.out.print("Средняя прибыль заводов, основанных до 1950 года: " +
                factories.stream()
                        .filter(factory -> factory.getYearFounded() < 1950)
                        .map(Factory::getProfit)
                        .mapToInt(Double::intValue)
                        .average()
                        .orElse(0));
        System.out.println("\n");

        //Task 10
        System.out.println("Топ-3 самых крупных по числу сотрудников завода:");
        factories.stream()
                .sorted(Comparator.comparing(Factory::getEmployees).reversed())
                .limit(3)
                .forEach(System.out::println);
    }
}