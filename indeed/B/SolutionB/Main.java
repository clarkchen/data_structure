package B.SolutionB;


import java.util.*;
public class Main{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    // get a integer
    String a = sc.nextLine();
    // get two integers separated with half-width break
    int b = sc.nextInt();
    b = (b % a.length())-1;
    if(b<0) b = a.length()-1;
    // output
    System.out.println( a.charAt(b));
    }
}

