package code.src.main.java.lld.examples.libmgmtDone.lib;

import book.BookCopy;
import dataaccessor.DBAccessor;
import dataaccessor.Results;
import dataaccessor.ResultsConverterNew;

import user.Member;
import java.util.List;

//business class
public class Library{

    private final DBAccessor dbAccessor;
    public Library(DBAccessor dbAccessor){
        this.dbAccessor = dbAccessor;
    }

    //book manager
    //membermanager

    //lib specific
    //book stock
    public void addBookCopy(BookCopy bookCopy){
        if(bookCopy==null){

        }
        dbAccessor.inserBookCopy(bookCopy);

    }

    public synchronized void deleteBookCopy(BookCopy bookCopy){
        //not issued by any user
        //certain bookcopy can not be deleted
        //multithreaded env for additin and deletion
        //for the api layer the code is very easy
        //but this is the business layer so this would be complex
        //Before deleting we have to check if it is available or not
        if(dbAccessor.isCopyAvailable(bookCopy)){
            dbAccessor.deleteBookCopy(bookCopy);
        }

    }

    //issue system
    public void issueBook(BookCopy bookCopy, Member member){

    }

    public void submiBook(BookCopy bookCopy, Member member){
        //calculate fine if submiited after a particular date

    }

    public Member getBorrower(BookCopy bookCopy){
        Results results=
                dbAccessor.getBorrower(bookCopy);

        return ResultsConverterNew.convert2Member(results);

    }

    public List<BookCopy> getBorrowedBooks(Member member){

    }


    public void blockMember(Member member){

    }








}