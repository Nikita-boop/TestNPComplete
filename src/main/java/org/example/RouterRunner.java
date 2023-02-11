package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Router.router;

public class RouterRunner {
    public static void main(String[] args) {
        List<Path> list = new ArrayList<>();
        list.add(new Path("Москва", "Тюмень"));
        list.add(new Path("Тюмень", "Сочи"));
        list.add(new Path("Ростов-на-Дону", "Москва"));
        printRoute(router(list));

        list.clear();

        list.add(new Path("Москва", "Тюмень"));
        list.add(new Path("Сочи", "Рязань"));
        list.add(new Path("Рязань", "Смоленск"));
        list.add(new Path("Смоленск", "Екатеринбург"));
        list.add(new Path("Екатеринбург", "Череповец"));
        list.add(new Path("Тюмень", "Сочи"));
        list.add(new Path("Ростов-на-Дону", "Москва"));
        printRoute(router(list));
    }

    public static void printRoute(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("Маршрут не найден");
        } else {
            System.out.println(String.join(" -> ", list));
        }
    }
}
