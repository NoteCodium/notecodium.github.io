package code.src.main.java.lld.examples.libmgmtDone.book;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookCopy{
    //inheritance should  be discouraged
    //even if, we dont do for data members but for functions

    //composition
    private final BookDetails bookDetails;
    private final int id;

}