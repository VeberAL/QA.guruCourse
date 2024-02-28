package collections;

import java.util.HashMap;
import java.util.Random;

public class HashMapOperations {
    public static void main(String[] args) {
        HashMap<Integer, String> NumberAndText = new HashMap<>();
        HashMap<Integer, String> NumberAndText1 = new HashMap<>();
        NumberAndText1.put(19, "uihvb");
        NumberAndText1.put(16, "hfffd");
        int value = 3;
        int key = 6;
        //заполнение мапы рандомными значениями
        putHashMap(NumberAndText);
        //проверка на содержание в коллекции ключа со значением value
        searchKeyInHashMap(NumberAndText, value);
        //вывести значение элемента для ключа key
        getHashMap(NumberAndText, key);
        //слияние мап
        putAllHashMap(NumberAndText, NumberAndText1);
        //удаление элементов по ключу и по ключу и значению
        removeElementsInHashMap(NumberAndText, key);
        removeElementsInHashMap(NumberAndText, 16, "hfffd");
    }

    public static void putHashMap(HashMap<Integer, String> map) {
        Random ran = new Random();
        int a = 0;
        while (a < 16) {
            String dat = "";
            for (int i = 0; i <= 5; i++) {
                char data = (char) (ran.nextInt(25) + 97);
                dat = data + dat;
            }
            map.put(a, dat);
            a++;
        }
        System.out.println("Заполнение коллекции случайными данными: " + map);
    }

    public static void searchKeyInHashMap(HashMap<Integer, String> map, Integer key) {
        if (map.containsKey(key)) {
            System.out.println("Коллекция содержит элемент с ключом '" + key + "'.");
        }
    }

    public static void getHashMap(HashMap<Integer, String> map, Integer key) {

        System.out.println("Значение элемента для ключа '" + key + "' - '" + map.get(key) + "'.");
    }

    public static void putAllHashMap(HashMap<Integer, String> map, HashMap<Integer, String> mapForPut) {
        map.putAll(mapForPut);
        System.out.println("Слияние c коллекцией " + mapForPut + "\nРезультат: " + map);
    }

    public static void removeElementsInHashMap(HashMap<Integer, String> map, Integer key) {
        map.remove(key);
        System.out.println("Удаление значения с ключом '" + key + "'.\nРезультат: " + map);
    }

    public static void removeElementsInHashMap(HashMap<Integer, String> map, Integer key, String value) {
        map.remove(key, value);
        System.out.println("Удаление значения с ключом '" + key + "' и значением '" + value + "'.\nРезультат: " + map);
    }
}
