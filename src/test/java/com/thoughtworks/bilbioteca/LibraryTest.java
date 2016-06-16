package com.thoughtworks.bilbioteca;


import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {
    private Library library;
    private Book book;
    private ArrayList<Book> books;

    @Before
    public void setUp(){
        book = mock(Book.class);

        books = new ArrayList<>();
        library = new Library(books);
    }

    @Test
    public void shouldPrintBookDetailsWhenListingABook() {
        books.add(book);

        library.listBooksWithDetails();
        verify(book).printBookDetails();
    }

    @Test
    public void shouldPrintSecondBooksDetailsWhenLibraryContainsTwoBooks() {
        Book secondBook = mock(Book.class);

        books.add(book);
        books.add(secondBook);

        library.listBooksWithDetails();

        verify(secondBook).printBookDetails();

    }




}