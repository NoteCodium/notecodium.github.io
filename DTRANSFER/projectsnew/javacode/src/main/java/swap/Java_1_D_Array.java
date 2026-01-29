package projectsnew.javacode.src.main.java.swap;
import java.util.Scanner;

class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] v = new int[n];
        for(int i=0;i<n;i++){
           v[i]= scanner.nextInt(); 
        }
        for(int i=0;i<n;i++){
            System.out.println(v[i]);
        }
        
        scanner.close();
    }
}