package com.thoughtworks.bilbioteca;

public class ListBooksCommand implements Command {

    private Library library;

    public ListBooksCommand(Library library) {
        this.library = library;
    }

    @Override
    public void executeSelection() {
        library.listBooksWithDetails();
    }
}
