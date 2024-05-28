package ru.job4j.ood.isp.menu;

import java.util.Scanner;

/**
 * 6. Создайте простенький класс TodoApp. Этот класс будет представлять собой консольное приложение, которое позволяет:
 * Добавить элемент в корень меню;
 * Добавить элемент к родительскому элементу;
 * Вызвать действие, привязанное к пункту меню (действие можно сделать константой,
 * например, ActionDelete DEFAULT_ACTION = () -> System.out.println("Some action") и указывать при добавлении элемента в меню);
 * Вывести меню в консоль.
 */
public class TodoApp {
    public static void main(String[] args) {
        final String EXIT = "0";
        final String ADD = "1";
        final String ADDCHILD = "2";
        final String ACTION = "3";
        final String PRINTMENU = "4";
        Printer printer = new Printer();
        ActionDelegate actionDelegate = () -> System.out.println("action");
        Menu simpleMenu = new SimpleMenu();
        String ln = System.lineSeparator();
        boolean switcher = true;
        String menu = "1. Добавить родительский элемент" + ln
                + "2. Добавить дочерний элемент" + ln
                + "3. Вызвать действие" + ln
                + "4. Показать все элементы" + ln
                + "0. Выход" + ln;
        Scanner scanner = new Scanner(System.in);
        while (switcher) {
            System.out.println(menu);
            System.out.print("Введите число:");
            String choose = scanner.nextLine();
            if (choose.equals(ADD)) {
                System.out.println("Введите имя корневого элемента");
                choose = scanner.nextLine();
                simpleMenu.add(Menu.ROOT, choose, actionDelegate);
            } else if (choose.equals(ADDCHILD)) {
                System.out.println("Введите имя родительского элемента");
                choose = scanner.nextLine();
                System.out.println("Введите имя дочернего элемента");
                String choose2 = scanner.nextLine();
                simpleMenu.add(choose, choose2, actionDelegate);
            } else if (choose.equals(ACTION)) {
                System.out.println(actionDelegate);
            } else if (choose.equals(PRINTMENU)) {
                printer.print(simpleMenu);
            }
            if (choose.equals(EXIT)) {
                switcher = false;
            }
        }
    }
}
