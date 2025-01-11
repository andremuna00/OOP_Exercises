package it.unive.FInterfaces.Meteo;

public class TemperatureDashboardItem implements DashboardItem {
    private String title;
    private double mean;
    private double variance;

    public TemperatureDashboardItem(String title, double mean, double variance) {
        this.title = title;
        this.mean = mean;
        this.variance = variance;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        double value = mean + (Math.random() - 0.5) * variance * 2;
        return String.format("%.2f", value) + "°C";
    }
}
