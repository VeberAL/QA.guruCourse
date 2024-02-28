package collections;

import java.util.LinkedList;

public class LinkedListOperations {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int startNumber = 1;
        int finishNumber = 15;
        int Value = 9;
        //добавление элемента в стэк коллекции
        pushElementInList(list, startNumber, finishNumber);
        //достать и удалить первый элемент из стэка коллекции
        popElementInList(list);
        //определить первый элемент в стэке
        peekElementInList(list);
        //добавить элемент в конец стэка
        addLastElementInList(list, Value);
        //удалить первое значение "9" в коллекции
        removeFirstSetElementInList(list, Value);
        //выести размер коллекции
        sizeList(list);
    }

    private static void pushElementInList(LinkedList<Integer> list, Integer startValue, Integer finishValue) {
        for (int i = startValue; i < finishValue; i++)
            list.push(i);
        System.out.println("В коллекцию добавлены элементы: " + list);
    }

    private static void popElementInList(LinkedList<Integer> list) {
        list.pop();
        System.out.println("Из коллекции удалён первый элемент: " + list);
    }

    private static void peekElementInList(LinkedList<Integer> list) {
        System.out.println("Определен первый элемент коллекции - " + list.peek());
    }

    private static void addLastElementInList(LinkedList<Integer> list, Integer addValue) {
        list.addLast(addValue);
        System.out.println("Добавлен элемент '" + addValue + "' в конце коллекции: " + list);
    }

    private static void removeFirstSetElementInList(LinkedList<Integer> list, Integer removeValue) {
        list.removeFirstOccurrence(removeValue);
        System.out.println("Удален первый встречающийся элемент '" + removeValue + "' в конце коллекции: " + list);
    }

    private static void sizeList(LinkedList<Integer> list) {
        System.out.println("Количество элементов в коллекции - " + list.size());
    }
}
