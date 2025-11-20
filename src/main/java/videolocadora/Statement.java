package videolocadora;

public abstract class Statement {

    public abstract String header(Customer aCustomer);
    public abstract String eachRental(Rental each);
    public abstract String footer(Customer aCustomer);
}
