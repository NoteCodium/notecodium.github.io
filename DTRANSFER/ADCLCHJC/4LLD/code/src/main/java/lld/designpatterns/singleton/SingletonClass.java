package code.src.main.java.lld.designpatterns.singleton;
public class SingletonClass {
    private static SingletonClass singletonClass=null;
    private SingletonClass(){}
    public static SingletonClass getSingletonClass(){
        if(singletonClass==null){
            singletonClass=new SingletonClass();
        }
        return singletonClass;
    }
}
