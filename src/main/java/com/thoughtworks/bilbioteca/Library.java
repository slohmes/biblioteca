package com.thoughtworks.bilbioteca;

import java.util.Collection;

public class Library{

    private Collection<Book> books;

    public Library(Collection<Book> books) {
        this.books = books;
    }


    public void listBooksWithDetails() {

        for (Book book : books) {
            book.printBookDetails();
        }
    }
}
