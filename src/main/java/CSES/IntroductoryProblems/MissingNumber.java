package CSES.IntroductoryProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < n-1; i++)
            numbers.add(scanner.nextInt());
        solve(n, numbers);
    }

    private static void solve(int n, List<Integer> numbers){
        long sum = 0;
        for(Integer x: numbers) sum +=x ;
        System.out.println(1l*n*(n+1)/2 - sum);
    }
}
