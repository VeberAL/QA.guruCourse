package collections;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetOperations {
    static Integer[] a = new Integer[19];

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();
        int startNumber = 0;
        int finishNumber = 20;
        int deleteNumber = 7;
        set.add(4);
        set.add(6);
        //добавление элементов в set
        addIntDataInList(set, startNumber, finishNumber);
        //выести размер коллекции
        sizeSet(set);
        //скопировать коллекцию в массив
        toArraySet(set, a);
        //удаление элемента из коллекции
        deleteDataInSet(set, deleteNumber);
    }

    private static void addIntDataInList(HashSet<Integer> set, Integer startValue, Integer finishValue) {
        for (int i = finishValue - 1; i > startValue; i--)
            set.add(i);
        System.out.println("В коллекцию добавлены автоматически укомплектованные по возрастанию элементы и удалены дубликаты: \n" + set);
    }

    private static void sizeSet(HashSet<Integer> set) {
        System.out.println("Количество элементов в коллекции - " + set.size());
    }

    private static void toArraySet(HashSet<Integer> set, Integer[] array) {
        set.toArray(array);
        System.out.println("Элементы коллекции записаны в массив: " + Arrays.toString(array));
    }

    private static void deleteDataInSet(HashSet<Integer> set, Integer deleteNumber) {
        set.remove(deleteNumber);
        System.out.println("Элемент '" + deleteNumber + "' удален из коллекции: " + set);
    }
}