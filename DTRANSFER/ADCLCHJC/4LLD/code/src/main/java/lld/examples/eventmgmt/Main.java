package code.src.main.java.lld.examples.eventmgmt;

public class Main {
    public static void main(String[] args) {
        EventContainer ec=new EventContainer(new EventTitle(), new EventSyllabus());
        System.out.println(ec.get());
    }
}
