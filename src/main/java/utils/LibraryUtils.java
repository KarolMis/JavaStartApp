package utils;

import data.*;

import java.util.*;

public class LibraryUtils {

    public static void printBooks(Library library) {
        printPublication(library, Book.class);
    }

    private static void printPublication(Library library, Class cl) {
        long countPublications = library.getPublications().values().stream().filter(cl::isInstance)
                .sorted(new Library.AlphabeticalComparator()).peek(System.out::println).count();

        if (countPublications == 0) {
            System.out.println("Brak publikacji typu: " + cl.getSimpleName() + " w bibliotece");
        }
    }

    public static void printMagazines(Library library) {
        printPublication(library, Magazine.class);
    }

    public static void printUsers(Library library) {
        library.getUsers().values().stream()
                .sorted(Comparator.comparing(User::getLastName))
                .forEach(System.out::println);
    }
}
