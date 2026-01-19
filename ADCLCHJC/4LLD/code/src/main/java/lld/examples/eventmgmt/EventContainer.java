package code.src.main.java.lld.examples.eventmgmt;

public class EventContainer {
    private final EventTitle title;
    private final EventSyllabus syllabus;

    public EventContainer(EventTitle eventTitle, EventSyllabus eventSyllabus) {
        this.title = eventTitle;
        this.syllabus = eventSyllabus;
    }

    public void increment(){
        title.next();
        syllabus.next();
    }
    
    public String get(){
        return title.get() + "\n" + syllabus.get();
    }


}
