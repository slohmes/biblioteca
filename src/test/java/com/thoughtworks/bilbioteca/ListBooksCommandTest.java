package com.thoughtworks.bilbioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksCommandTest {
    @Test
    public void test() {
        Library library = mock(Library.class);

        ListBooksCommand listBooksCommand = new ListBooksCommand(library);
        listBooksCommand.executeSelection();

        verify(library).listBooksWithDetails();
    }

}
