package it.unive.FInterfaces.Meteo;

public class ConstDashboardItem implements DashboardItem {
    private String title;
    private String value;

    public ConstDashboardItem(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }
}
