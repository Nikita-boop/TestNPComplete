package org.example;

import java.util.*;

public class Router {
    private static final Map<String, String> allPaths = new HashMap<>();
    private static final List<String> visitedCities = new ArrayList<>();

    public static List<String> router(List<Path> listPaths) {
        // Поскольку все значения в листе путей будут уникальный создаем HashMap из этих путей
        for (Path path : listPaths) {
            allPaths.put(path.getFrom(), path.getTo());
        }

        // входной точкой будет path (в мапе) ключу которого нет соответствия в значениях мапы
        // необходимо выполнить прямой перебор всех элементов мапы - сложность O(n)
        Set<String> entrySet = new HashSet<>(allPaths.keySet());
        entrySet.removeAll(allPaths.values());
        String currentPosition = entrySet.stream().findAny().orElse("Маршрута нет");

        // проверка на некорректные данные, хотя они не предусмотрены условием
        if (currentPosition.equals("Маршрута нет")) {
            visitedCities.clear();
            allPaths.clear();
            throw new RuntimeException();
        }

        // Зная начальную точку итерируемся по всей хэш мапе по принципу
        // to предыдущего пути должно соответствовать from следующего пути
        // или value предыдущего должно соответствовать ключу следующего
        // и складываем это все лист (маршрут), сложность O(n)
        visitedCities.add(currentPosition);
        while (allPaths.containsKey(currentPosition)) {
            visitedCities.add(allPaths.get(currentPosition));
            currentPosition = allPaths.get(currentPosition);
        }

        // Формируем лист который нужно вернуть и завершаем метод
        List<String> completeRoute = new ArrayList<>(visitedCities);
        visitedCities.clear();
        allPaths.clear();
        return completeRoute;
    }
}