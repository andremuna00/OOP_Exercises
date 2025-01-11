package it.unive.FInterfaces.Meteo;

public class Interfaces {
    public static void main(String[] args) {
        DashboardManager manager = new DashboardManager();
        manager.addItem(new TemperatureDashboardItem("TEMP INT", 20, 5));
        manager.addItem(new TemperatureDashboardItem("TEMP EXT", 10, 10));
        manager.addItem(new ConstDashboardItem("HUM", "55%"));

        for (int i = 0; i < 10; i++) {
            manager.printAllItems();
        }
    }
}
