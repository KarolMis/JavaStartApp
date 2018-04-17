package data;

import java.io.Serializable;

public class Library implements Serializable {

    private static final int MAX_PUBLICATIONS = 2000;
    private Publication[] publications;
    private int publicationsNumber;



    public Library() {
        publications = new Publication[MAX_PUBLICATIONS];
    }

    private void addPublication(Publication publication) throws ArrayIndexOutOfBoundsException{
        if(publicationsNumber == MAX_PUBLICATIONS) {
            throw new ArrayIndexOutOfBoundsException("MAX_PUBLICATIONS " + MAX_PUBLICATIONS);
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
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
}