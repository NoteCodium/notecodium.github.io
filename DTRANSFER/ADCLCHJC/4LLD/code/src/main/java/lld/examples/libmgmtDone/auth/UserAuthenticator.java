package code.src.main.java.lld.examples.libmgmtDone.auth;

//Doing this make it stateless

public class UserAuthenticator{
    private UserAuthenticator(){}

    public static boolean isAdmin(String token){
        return true;
    }

    public static boolean isMember(String token){
        return true;
    }

}