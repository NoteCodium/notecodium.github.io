package code.src.main.java.lld.examples.libmgmtDone;
import book.BookCopy;
import book.BookDetails;
import dataaccessor.DBAccessor;
import id.IDGenerator;
import lib.Library;
import searcher.*;
import user.Member;

//do changes
import java.util.Date;
import java.util.List;

import auth.UserAuthenticator;

public class Tester {

    //We are creating library object again and again
    private final Library library=
        new Library(new DBAccessor());


    //Operations on books
    //Search book
    //This is API
    public List<BookCopy> searchBooksByBookName(String bookName){
        if(bookName == null){
            throw new IllegalArgumentException("Book name cannot be null");
        }

        //This is business logic
        //New of concrete classes can be avoided with factory design pattern
        BookSearcher bookSearcher = new NameBasedBookSearcher(bookName);
        return  bookSearcher.search();
    }

    public List<BookCopy> searchBooksByAuthorNames(List<String> authorNames){
        if(authorNames == null || authorNames.size()==0){
            throw new IllegalArgumentException("authorName cannot be null or empty");
        }

        //This is business logic
        BookSearcher bookSearcher = new AuthorBasedBookSearcher(authorNames);
        return  bookSearcher.search();
    }

    ////Admin only features
    //Edit book stock
    //Add book
    public void addBook(String bookName, Date publicationDate, List<String> authors, String adminToken){
        if(bookName == null || publicationDate == null || authors == null || adminToken == null){
            throw new IllegalArgumentException("Book name, publication date, authors and admin token cannot be null");
        }

        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalArgumentException("Admin token is invalid");
        }

        BookDetails bookDetails = new BookDetails(bookName, publicationDate, authors);
        BookCopy bookCopy = new BookCopy(bookDetails, IDGenerator.getUniqueId());

        //important
        library.addBookCopy(bookCopy);


        // //This is business logic
        // Book book = new Book(bookName, publicationDate, authors);
        // BookStock bookStock = new BookStock(book);
        // bookStock.addBook(book);
    }

    //delete book
    public void deleteBook(int bookCopyId, String adminToken){
        if(bookCopyId <= 0 || adminToken == null || adminToken.length()==0){
            throw new IllegalArgumentException("Book copy id and admin token cannot be null");
        }

        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalArgumentException("Admin token is invalid");
        }


        BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyId);
        List<BookCopy> bookCopies = bookSearcher.search();
        if(bookCopies==null || bookCopies.size()==0){
            throw new IllegalArgumentException("Book copy not found");
        }

        library.deleteBookCopy(bookCopies.get(0));
    }
    //library specific features
    public void issueBook(){

    }


    //Operations on Members
    //Search
    //Should be member only
    public List<Member> searchMembersByMemberNames(String memberName, String adminToken){

        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalArgumentException("Admin token is invalid");
        }

        if(memberName == null){
            throw new IllegalArgumentException("Member name cannot be null");
        }

        //This is business logic
        MemberSearcher memberSearcher = new NameBasedMemberSearcher(memberName);
        return memberSearcher.search();
    }

    //Admin only features
    //bock
    public void blockMember(int memberId, String adminToken){
        MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
        List<Member> members = memberSearcher.search();
        if(members==null || members.size()==0){
            throw new IllegalArgumentException("Member not found");
        }

        library.blockMember(members.get(0));

    }






}