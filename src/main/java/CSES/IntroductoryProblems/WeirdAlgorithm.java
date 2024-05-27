package CSES.IntroductoryProblems;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextInt();
        solve(n);
    }

    private static void solve(long n){
        while(n != 1){
            System.out.print(n + " ");
            if(n%2 == 0){
                n = n/2;
            } else {
                n = 3*n + 1;
            }
        }
        System.out.print(n + " ");
    }
}
