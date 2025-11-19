package videolocadora;

public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    // Já existia no seu código
    public double getCharge(int daysRented) {

        switch (getPriceCode()) {
            case REGULAR:
                double result = 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                return result;

            case NEW_RELEASE:
                return daysRented * 3;

            case CHILDRENS:
                double c = 1.5;
                if (daysRented > 3)
                    c += (daysRented - 3) * 1.5;
                return c;
        }

        return 0;
    }

    // Também já existia
    public int getFrequentRenterPoints(int daysRented) {
        if (getPriceCode() == NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
