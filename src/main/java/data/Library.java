package data;

public class Library {

    private static final int MAX_BOOKS = 1000;
    private static final int MAX_MAGAZINE = 1000;
    private Book[] books;
    private Magazine[] magazines;

    private int booksNumber;
    private int magazineNumber;

    public Library() {
        books = new Book[MAX_BOOKS];
    }

    public int getMagazineNumber(){
        return magazineNumber;
    }

    public Magazine[] getMagazines() {
        return magazines;
    }

    public int getBooksNumber() {
        return booksNumber;
    }

    public Book[] getBooks() {
        return books;
    }

    public void addBook(Book book) {
        if(booksNumber < MAX_BOOKS) {
            books[booksNumber] = book;
            booksNumber++;
        } else {
            System.out.println("Maxymalna liczba książek została osiągnięta");
        }
    }

    public void addMagazine(Magazine magazine) {
        if(magazineNumber < MAX_MAGAZINE) {
            magazines[magazineNumber] = magazine;
            magazineNumber++;
        } else {
            System.out.println("Maxymalna liczba magazynów została osiągnięta");
        }

    }

    public void printBooks() {
        if(booksNumber == 0) {
            System.out.println("Brak książek w bibliotece");
        }
        for(int i=0; i<booksNumber; i++) {
            books[i].printInfo();
        }
    }

    public void printMagazines() {
        if (magazineNumber == 0) {
            System.out.println("Brak magazynów w bibliotece");
        }
        for (int i = 0; i < magazineNumber; i++) {
            magazines[i].printInfo();
        }

    }
}