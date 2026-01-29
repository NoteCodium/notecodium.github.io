package code.src.main.java.lld.reuse.as_it_is.user;

//revise abstract class
public abstract class User {
    private final int id;
    private final String name;
    
    public User(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    
}
