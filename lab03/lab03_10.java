/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nattawut
 */
import java.util.*;
public class lab03_10 {
    public static void main(String[] args) {
        int odd = 0;
        int even = 0;
        while (!false) {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            if (x != -1) {
                if (x%2 == 0) {
                    even += 1;
                }else {
                    odd += 1;
                }
            }else {
                break;
            }
        }
        System.out.println("odd number = "+ odd + " and even number = "+ even);
    }
}
