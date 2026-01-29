package projectsnew.javacode.src.main.java.swap;
import java.util.Arrays;
import java.util.StringTokenizer;

public class One {
    public static void main(String[] args) {
        // StringBuilder y = new StringBuilder("ab"); 
        // System.out.println("Size of StringBuilder "+y.length());
        // change1(y);
        // System.out.println("StringBuilder After Change "+y);
        
        // String x= new String("ab");
        // System.out.println("Size of NormalString "+x.length());
        // change2(x);
        // System.out.println("NormalString After Change "+x);
        // String s= "abc";
        // System.out.println(s1);
        // int[] v= new int[5];
        // Arrays.fill(v, 1);
        // System.out.println(v[0]);
        // String s1= "abc";
        // StringTokenizer st= new StringTokenizer(s1);
        // // StringBuffer sb= new StringBuffer();
        // StringBuilder sb = new StringBuilder("zyxw");
        // String s= sb.toString();
        // char[] charArray= s.toCharArray();
        // Arrays.sort(charArray);
        // System.out.println(Arrays.toString(charArray));
    }

    public static void change1(StringBuilder y){
        // StringBuilder z= y.reverse();
        // System.out.println("Reversed "+z);
        y.append("JJ");
        System.out.println("StringBuilder Changed "+y);
    }

    public static void change2(String x){
        x="cd";
        System.out.println("NormalString Changed " +x);
    }

}
