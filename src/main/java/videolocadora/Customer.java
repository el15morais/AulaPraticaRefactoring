package videolocadora;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    // Método statement agora usa TextStatement
    public String statement() {
        return new TextStatement().value(this);
    }

    // Método htmlStatement agora usa HtmlStatement
    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }

    public Enumeration<Rental> getRentals() {
        Vector<Rental> vector = new Vector<>(rentals);
        return vector.elements();
    }

    public double getTotalCharge() {
        double result = 0;
        for (Rental each : rentals) {
            result += each.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental each : rentals) {
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
