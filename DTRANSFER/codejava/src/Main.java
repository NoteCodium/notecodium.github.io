public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
//        Class<Integer> class1= int.class;
//        System.out.println(class1.getName());

        Class class2= Class.forName("java.lang.String");
        System.out.println(class2);


    }
}