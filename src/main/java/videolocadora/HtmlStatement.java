package videolocadora;

import java.util.Enumeration;

public class HtmlStatement extends Statement {

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
        return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }

    @Override
    public String eachRental(Rental each) {
        return each.getMovie().getTitle() + ": " +
                each.getCharge() + "<BR>\n";
    }

    @Override
    public String footer(Customer aCustomer) {
        return "<P>You owe <EM>" + aCustomer.getTotalCharge() +
                "</EM><P>\n" +
                "On this rental you earned <EM>" +
                aCustomer.getTotalFrequentRenterPoints() +
                "</EM> frequent renter points<P>";
    }
}
