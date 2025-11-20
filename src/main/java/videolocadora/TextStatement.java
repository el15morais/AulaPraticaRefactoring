package videolocadora;

import java.util.Enumeration;

public class TextStatement extends Statement {

    @Override
    public String value(Customer aCustomer) {
        Enumeration<Rental> rentals = aCustomer.getRentals();

        String result = header(aCustomer);

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += eachRental(each);
        }

        result += footer(aCustomer);

        return result;
    }

    @Override
    public String header(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    @Override
    public String eachRental(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" +
                each.getCharge() + "\n";
    }

    @Override
    public String footer(Customer aCustomer) {
        return "Amount owed is " + aCustomer.getTotalCharge() + "\n" +
                "You earned " + aCustomer.getTotalFrequentRenterPoints() +
                " frequent renter points";
    }
}
