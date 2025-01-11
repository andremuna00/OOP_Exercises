package it.unive.GObject;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Crea una stringa che rappresenta la data con una format string gg/mm/yyyy
    public String toString() {
        return String.format("%d/%d/%d", day, month, year);
    }

    public boolean equals(Object obj) {
        // Prima controlliamo che l'oggetto sia un Date...
        if (obj instanceof Date) {
            // se è un date possiamo fare il cast e confrontare i campi
            Date objDate = (Date) obj;
            return this.day == objDate.day
                    && this.month == objDate.month
                    && this.year == objDate.year;
        }

        // se NON è un Date sicuramente non sono uguali
        return false;
    }

    public int hashCode() {
        // Ritorna una rappresentazione univoca della data
        // ovvero, giorno mese e anno concatenati
        return year + month * 10000 + day * 1000000;
    }
}
