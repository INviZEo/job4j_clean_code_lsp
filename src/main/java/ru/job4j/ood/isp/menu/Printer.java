package ru.job4j.ood.isp.menu;

import java.util.Iterator;

public class Printer implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        Iterator<Menu.MenuItemInfo> iterator = menu.iterator();
        Menu.MenuItemInfo currentItem;
        while (iterator.hasNext()) {
            StringBuilder rsl = new StringBuilder();
            currentItem = iterator.next();
            String number = currentItem.getNumber();
            rsl.append("--".repeat(number.length() - 2));
            System.out.println(rsl.append(number).append(currentItem.getName()));
        }
    }
}