package it.unive.FInterfaces.Meteo;

import java.util.ArrayList;

public class DashboardManager {
    private ArrayList<DashboardItem> items;
    private int itemWidth = 16;

    public DashboardManager() {
        items = new ArrayList<DashboardItem>();
    }

    public void addItem(DashboardItem i) {
        items.add(i);
    }

    private String extendString(String s, int width) {
        String output = s;
        for (int i = s.length(); i < width; i++) {
            output += " ";
        }
        return output;
    }

    public void printAllItems() {
        for (DashboardItem item : items) {
            System.out.print(extendString(item.getTitle(), itemWidth));
        }
        System.out.println();

        for (DashboardItem item : items) {
            System.out.print(extendString(item.getValue(), itemWidth));
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
