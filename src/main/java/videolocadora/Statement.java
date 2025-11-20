package videolocadora;

import java.util.Enumeration;

public abstract class Statement {

    public String value(Customer aCustomer) {
        String result = headerString(aCustomer);

        for (Enumeration<Rental> rentals = aCustomer.getRentals(); rentals.hasMoreElements();) {
            Rental each = rentals.nextElement();
            result += eachRentalString(each);
        }

        result += footerString(aCustomer);
        return result;
    }

    protected abstract String headerString(Customer aCustomer);

    protected abstract String eachRentalString(Rental aRental);

    protected abstract String footerString(Customer aCustomer);
}
