package app;

import data.Book;
import data.Library;
import utils.DataReader;

public class LibraryControl {
    // zmienne do kontrolowania programu
    public static final int EXIT = 0;
    public static final int ADD_BOOK = 1;
    public static final int PRINT_BOOKS = 2;

    // zmienna do komunikacji z użytkownikiem
    private DataReader dataReader;

    // "biblioteka" przechowująca dane
    private Library library;

    public LibraryControl() {
        dataReader = new DataReader();
        library = new Library();
    }

    /*
     * Główna pętla programu, która pozwala na wybór opcji i interakcję
     */
    public void controlLoop() {
        int option;
        printOptions();
        while ((option = dataReader.getInt()) != EXIT) {
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji, wprowadź ponownie: ");
            }
            printOptions();
        }
        // zamykamy strumień wejścia
        dataReader.close();
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        System.out.println("0 - wyjście z programu");
        System.out.println("1 - dodanie nowej książki");
        System.out.println("2 - wyświetl dostępne książki");
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printBooks() {
        library.printBooks();
    }
}