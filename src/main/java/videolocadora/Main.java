package videolocadora;

public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("João");
        c.addRental(new Rental(new Movie("Matrix", Movie.REGULAR), 3));
        c.addRental(new Rental(new Movie("Pets", Movie.CHILDRENS), 4));
        c.addRental(new Rental(new Movie("Vingadores", Movie.NEW_RELEASE), 2));

        System.out.println(c.statement());
    }
}
