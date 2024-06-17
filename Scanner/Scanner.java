import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println(number);
        }
        
        scanner.close();
    }
}
