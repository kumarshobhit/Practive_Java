import java.util.*;

public class Main {
    public static Scanner scn = new Scanner (System.in) ;
    
    public static void fun(int n){
        System.out.println(n+2) ;
    }
    public static void main(String[] args){
        int n = scn.nextInt();
        fun(n) ;
    }
}