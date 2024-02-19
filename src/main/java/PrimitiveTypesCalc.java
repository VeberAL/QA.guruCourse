public class PrimitiveTypesCalc {
    public static void main(String[] args) {
        byte b = 1;
        short s = 1;
        int i = 1;
        long l = 2147483647;

        //Переполнение типов:
        b += 127;
        s += 32767;
        i += 2147483647;
        l *= l * 3;
        //Результат: byte: -128; short: -32768; int: -2147483648; long: -4611686031312289789
        System.out.println("byte: " + b + "; short: " + s + "; int: " + i + "; long: " + l);

        //Условный оператор и логические операции
        if (i < 0 && s < 0 || b < 0) {
            ++i;
            System.out.println("Переполнение прошло успешно.");
        } else System.out.println("Переполнение прошло безуспешно.");

        boolean z = true, v = false, c = true, n;
        n = z && c || c && !v;
        System.out.println("Результат логических вычислений = " + n);

        //Расширение типов (byte -> short-> int-> long -> float -> double)
        int a1 = 10;
        long a2 = a1;
        System.out.println("Расширение типа int до long прошло успешно." + a1 + " = " + a2);

        //Преобразование типов
        char sim = 'A';
        int a3 = sim;
        System.out.println("В переменную типа char записался код символа А: " + a3);

        //Потеря точности
        int big = 1234567890;
        float f = big;
        System.out.printf("Число " + big + " проебразовалось в %f", f);

        //Явное приведение типов
        byte b1 = 10;
        int i1 = b1 * b1;
        b1 = (byte) (b1 * b1);

        int k = 4;
        double x = 3.14;
        short s1 = -5;
        System.out.println("\nЗначение = " + ((int) x + k * s1));
        System.out.println("Но, значение = " + (int) (x + k * s1));

        //Вычисления различных типов
        int ii1 = 8;
        double dd1 = 5.2;
        int ii2 = (int) (ii1 / dd1);
        int ii3 = (int) (dd1 / ii1);
        System.out.println("Результат деления int на double = " + ii1 / dd1);
        System.out.println("Результат деления int на double с приведением к типу int = " + ii2);
        System.out.println("Результат деления double на int = " + dd1 / ii1);
        System.out.println("Результат деления double на int с приведением к типу int = " + ii3);
    }
}
