package code.src.main.java.lld.reuse.sameconcept.search.libmgmt;

import java.util.List;

import book.BookCopy;

public class AuthorBasedBookSearcher implements BookSearcher {
    private final List<String> authors;


    public AuthorBasedBookSearcher(List<String> authors){
        this.authors = authors;
    }

    @Override
    public List<BookCopy> search() {
        // TODO Auto-generated method stub
        return null;
    }

}