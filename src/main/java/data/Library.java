package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class Library implements Serializable {

    private static final int INITIAL_CAPACITY = 1;
    private Publication[] publications;
    private int publicationsNumber;



    public Library() {
        publications = new Publication[INITIAL_CAPACITY];
    }

    private void addPublication(Publication publication) throws ArrayIndexOutOfBoundsException{
        if(publicationsNumber == publications.length) {
            publications = Arrays.copyOf(publications, publications.length * 2);
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }

    public void removePublication(Publication publication) {
        if(publication == null) return;

        final int NOT_FOUND = -1;
        int found = NOT_FOUND;
        int i = 0;
        while (i < publications.length && found == NOT_FOUND) {
            if (publication.equals(publications[i])) {
                found = i;
            } else {
                i++;
            }
        }
        if (found != NOT_FOUND) {
            System.arraycopy(publications, found + 1, publications, found, publications.length - found - 1);
            publicationsNumber--;
        }
    }

    public void addBook(Book book){
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    public void printBooks() {
        int countBooks = 0;
        for(int i=0; i<publicationsNumber; i++) {
            if(publications[i] instanceof Book) {
                System.out.println(publications[i]);
                countBooks++;
            }
        }

        if(countBooks == 0) {
            System.out.println("Brak książek w bibliotece");
        }
    }

    public void printMagazines() {
        int countMagazines = 0;
        for (int i = 0; i < publicationsNumber; i++) {
            if(publications[i] instanceof Magazine) {
                System.out.println(publications[i]);
                countMagazines++;
            }
        }
        if (countMagazines == 0) {
            System.out.println("Brak magazynów w bibliotece");
        }
    }

    public Publication[] getPublications() {
        return publications;
    }


    public int getPublicationNumber() {
        return publicationsNumber;
    }

    public void setPublications(Publication[] publications) {
        this.publications = publications;
    }

    public void setPublicationNumber(int publicationNumber) {
        this.publicationsNumber = publicationNumber;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<publicationsNumber; i++) {
            builder.append(publications[i]);
            builder.append("\n");
        }
        return builder.toString();
    }
    public static class AlphabeticalComparator implements Comparator<Publication> {

        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static class DateComparator implements Comparator<Publication> {

        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            Integer i1 = o1.getYear();
            Integer i2 = o2.getYear();
            return -i1.compareTo(i2);
        }
    }
}