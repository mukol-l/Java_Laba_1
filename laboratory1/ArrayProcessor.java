package laboratory1;

import java.util.Random;

public class ArrayProcessor {

    public static int[] generateRandomArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Розмір масиву повинен бути більшим за 0!");
        }
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201) - 100;
        }
        return array;
    }

    public static int sumOfNegatives(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім!");
        }
        int sum = 0;
        for (int num : array) {
            if (num < 0) {
                sum += num;
            }
        }
        return sum;
    }

    // Оновлена точна логіка пошуку меж
    public static int productBetweenMinMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім!");
        }
        if (array.length <= 2) {
            throw new ArithmeticException("Масив занадто малий, немає елементів між min та max!");
        }

        int minIdx = 0;
        int maxIdx = 0;

        // Шукаємо СТРОГО найменший та найбільший елементи
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIdx]) {
                minIdx = i;
            }
            if (array[i] > array[maxIdx]) {
                maxIdx = i;
            }
        }

        int start = Math.min(minIdx, maxIdx);
        int end = Math.max(minIdx, maxIdx);

        // Якщо між ними нічого немає (стоять впритул)
        if (end - start <= 1) {
            throw new ArithmeticException("Між мінімальним та максимальним елементами немає інших чисел!");
        }

        int product = 1;
        for (int i = start + 1; i < end; i++) {
            product *= array[i];
        }

        return product;
    }
}
