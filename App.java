import java.util.Arrays;
import java.util.Scanner;
import laboratory1.ArrayProcessor;

public class App {

    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    public static void waitForEnter(Scanner scanner) {
        System.out.println("\n👉 Натисніть [Enter], щоб повернутися до меню...");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] currentArray = null;

        while (true) {
            clearScreen();

            System.out.println("=== МЕНЮ ПРОГРАМИ (ВАРІАНТ №6) ===");
            System.out.println("1. Згенерувати новий випадковий масив [-100; 100]");
            System.out.println("2. Обчислити суму від'ємних елементів");
            System.out.println("3. Обчислити добуток елементів між MIN та MAX");
            System.out.println("4. Вивести поточний масив на екран");
            System.out.println("0. Вийти з програми");
            if (currentArray != null) {
                System.out.println("\n📌 Статус: Масив згенеровано (Розмір: " + currentArray.length + ")");
            } else {
                System.out.println("\n📌 Статус: Масив ще не створено");
            }
            System.out.print("Виберіть дію: ");

            String input = scanner.nextLine();
            clearScreen();

            switch (input) {
                case "1":
                    System.out.println("=== 1. ГЕНЕРАЦІЯ МАСИВУ ===");
                    System.out.print("Введіть розмір масиву: ");
                    try {
                        int size = Integer.parseInt(scanner.nextLine());
                        currentArray = ArrayProcessor.generateRandomArray(size);
                        System.out.println("\nУспішно згенеровано!");
                        System.out.println("Ваш масив: " + Arrays.toString(currentArray));
                    } catch (NumberFormatException e) {
                        System.out.println("\nПомилка: Потрібно ввести ціле число, а не літери чи символи!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nПомилка: " + e.getMessage());
                    }
                    waitForEnter(scanner);
                    break;

                case "2":
                    System.out.println("=== 2. СУМА ВІД'ЄМНИХ ЕЛЕМЕНТІВ ===");
                    try {
                        int sum = ArrayProcessor.sumOfNegatives(currentArray);
                        System.out.println("Поточний масив: " + Arrays.toString(currentArray));
                        System.out.println("\nРезультат: Сума від'ємних елементів = " + sum);
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nПомилка: " + e.getMessage() + " Спочатку згенеруйте масив (Пункт 1).");
                    }
                    waitForEnter(scanner);
                    break;

                case "3":
                    System.out.println("=== 3. ДОБУТОК МІЖ MIN ТА MAX ===");
                    try {
                        int product = ArrayProcessor.productBetweenMinMax(currentArray);
                        System.out.println("Поточний масив: " + Arrays.toString(currentArray));
                        System.out.println("\nРезультат: Добуток елементів між MIN та MAX = " + product);
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nПомилка: " + e.getMessage() + " Спочатку згенеруйте масив (Пункт 1).");
                    } catch (ArithmeticException e) {
                        System.out.println("\nУвага: " + e.getMessage());
                    }
                    waitForEnter(scanner);
                    break;

                case "4":
                    System.out.println("=== 4. ПОТОЧНИЙ МАСИВ ===");
                    if (currentArray == null) {
                        System.out.println("Масив ще не створено. Оберіть пункт 1.");
                    } else {
                        System.out.println("Ваш поточний масив: " + Arrays.toString(currentArray));
                    }
                    waitForEnter(scanner);
                    break;

                case "0":
                    System.out.println("Дякуємо за використання програми! Завершення роботи.");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Некоректний вибір! Будь ласка, введіть число від 0 до 4.");
                    waitForEnter(scanner);
                    break;
            }
        }
    }
}
