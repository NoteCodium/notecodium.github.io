package code.src.main.java.lld.examples.libmgmtDone.searcher;

import book.BookCopy;

import java.util.List;

public class IdBasedBookSearcher implements BookSearcher {

    private final int id;

    public IdBasedBookSearcher(int id){
        this.id=id;
    }


    @Override
    public List<BookCopy> search(){
        return null;
    }

}