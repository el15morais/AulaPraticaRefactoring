package videolocadora;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    private double amountFor(Rental aRental) {

        double thisAmount = 0;

        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (aRental.getDaysRented() > 2) {
                    thisAmount += (aRental.getDaysRented() - 2) * 1.5;
                }
                break;

            case Movie.NEW_RELEASE:
                thisAmount += aRental.getDaysRented() * 3;
                break;

            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (aRental.getDaysRented() > 3) {
                    thisAmount += (aRental.getDaysRented() - 3) * 1.5;
                }
                break;
        }

        return thisAmount;
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }


    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
