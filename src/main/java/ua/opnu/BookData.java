package ua.opnu;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getReviews() {
        return reviews;
    }

    public double getTotal() {
        return total;
    }

    public double getRating() {
        return reviews == 0 ? 0 : total / reviews;
    }

    @Override
    public int compareTo(BookData other) {
        int byRating = Double.compare(other.getRating(), this.getRating());
        if (byRating != 0) {
            return byRating;
        }
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return String.format("%s (%s), rating %.2f", title, author, getRating());
    }
}
