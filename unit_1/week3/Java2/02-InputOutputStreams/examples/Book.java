package examples;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private int yearPublished;
    private int numPages;

    public Book(String t, String a, int y, int n) {
        title = t;
        author = a;
        yearPublished = y;
        numPages = n;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + ", published "
                + yearPublished + ", " + numPages + " pages.";
    }
}
