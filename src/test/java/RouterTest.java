import org.example.Path;
import org.example.Router;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RouterTest {
    @Test
    void test1() {
        List<Path> list = new ArrayList<>();
        list.add(new Path("Москва", "Тюмень"));
        list.add(new Path("Сочи", "Рязань"));
        list.add(new Path("Рязань", "Смоленск"));
        list.add(new Path("Смоленск", "Екатеринбург"));
        list.add(new Path("Екатеринбург", "Череповец"));
        list.add(new Path("Тюмень", "Сочи"));
        list.add(new Path("Ростов-на-Дону", "Москва"));

        List<String> expectList = List.of("Ростов-на-Дону", "Москва", "Тюмень", "Сочи", "Рязань", "Смоленск", "Екатеринбург", "Череповец");
        Assertions.assertTrue(Router.router(list).equals(expectList));
    }

    @Test
    void test2() {
        List<Path> list = new ArrayList<>();
        list.add(new Path("Москва", "Тюмень"));
        list.add(new Path("Сочи", "Рязань"));
        list.add(new Path("Рязань", "Смоленск"));
        list.add(new Path("Смоленск", "Екатеринбург"));
        list.add(new Path("Екатеринбург", "Ростов-на-Дону"));
        list.add(new Path("Тюмень", "Сочи"));
        list.add(new Path("Ростов-на-Дону", "Москва"));

        Assertions.assertThrows(RuntimeException.class, () -> {Router.router(list);} );
    }

    @Test
    void test3() {
        List<Path> list = new ArrayList<>();
        list.add(new Path("Москва", "Тюмень"));
        list.add(new Path("Тюмень", "Сочи"));
        list.add(new Path("Ростов-на-Дону", "Москва"));

        List<String> expectList = List.of("Ростов-на-Дону", "Москва", "Тюмень", "Сочи");
        Assertions.assertTrue(Router.router(list).equals(expectList));
    }

    @Test
    void test4() {
        List<Path> list = new ArrayList<>();
        list.add(new Path("Москва", "Тюмень"));
        list.add(new Path("Тюмень", "Сочи"));
        list.add(new Path("Ростов-на-Дону", "Москва"));

        List<String> expectList = List.of("Ростов-на-Дону", "Сочи");
        Assertions.assertTrue(!Router.router(list).equals(expectList));
    }

}

