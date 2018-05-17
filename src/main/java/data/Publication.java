package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Publication implements Serializable, Comparable<Publication> {
    private LocalDate date;
    private String title;
    private String publisher;

    protected Publication(int year, String title, String publisher) {
        setDate(LocalDate.of(year, 1, 1));
        this.title = title;
        this.publisher = publisher;
    }

    public int getYear() {
        return date.getYear();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(title, that.title) &&
                Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, title, publisher);
    }

    @Override
    public int compareTo(Publication o) {
        return title.compareTo(o.getTitle());
    }
}
