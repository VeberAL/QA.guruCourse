package collections;

import java.util.ArrayList;

public class ArrayListOperations {
    static int a;

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int startNumber = 1;
        int finishNumber = 15;
        int searchNumber = 9;
        int deleteNumber = 2;

        //добавление элементов в коллекцию
        addIntDataInList(arr, startNumber, finishNumber);
        //поиск элемента в коллекции по значению
        searchDataInList(arr, searchNumber);
        //поиск элемента в коллекции по индексу
        getElementList(arr, searchNumber);
        //добавление элемента в коллекцию по выбранному индексу
        addIntForIndexDataInList(arr, 5, 3);
        addIntForIndexDataInList(arr, 9, 3);
        //поиск индекса первого встречающегося элемента со значением 3
        searchFirstElementIndexInList(arr, 3);
        //удаление элемента из коллекции
        deleteDataInList(arr, deleteNumber);
        //очистка коллекции
        clearList(arr);
        //проверка что коллекция пустая
        emptyCheckList(arr);
    }

    private static void addIntDataInList(ArrayList<Integer> arr, Integer startValue, Integer finishValue) {
        for (int i = startValue; i < finishValue; i++)
            arr.add(i);
        System.out.println("В коллекцию добавлены элементы: " + arr);
    }

    private static void addIntForIndexDataInList(ArrayList<Integer> arr, Integer index, Integer value) {
        arr.add(index, value);
        System.out.println("В коллекцию добавлен элемент со значением '" + value + "' в индекс '" + index + "'.\nНовая коллекция: " + arr);
    }

    private static void searchDataInList(ArrayList<Integer> arr, Integer searchNumber) {
        if (arr.contains(searchNumber))
            System.out.println("Искомое значение '" + searchNumber + "' найдено в коллекции.");
    }

    private static void getElementList(ArrayList<Integer> arr, Integer searchIndex) {
        a = arr.get(searchIndex);
        System.out.println("Эллемент в коллекции с индексом '" + searchIndex + "': " + a);
    }

    private static void deleteDataInList(ArrayList<Integer> arr, Integer deleteNumber) {
        arr.remove(deleteNumber);
        System.out.println("Элемент '" + deleteNumber + "' удален из коллекции: " + arr);
    }

    public static void clearList(ArrayList<Integer> arr) {
        arr.clear();
        System.out.println("Коллекция очищена: " + arr);
    }

    public static void emptyCheckList(ArrayList<Integer> arr) {
        boolean a = arr.isEmpty();
        if (a) {
            System.out.println("Проверка на очистку коллекции прошла успешно.");
        }
    }

    public static void searchFirstElementIndexInList(ArrayList<Integer> arr, Integer value) {
        int a = arr.indexOf(value);
        System.out.println("Индекс первого встречающегося элемента со значением 3: " + a);
    }
}
