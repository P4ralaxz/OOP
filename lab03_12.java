/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nattawut
 */
import java.util.*;
public class lab03_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please insert a number : ");
        int x = sc.nextInt();
        for (int i = 1; i <= x; i++) {
            if (i%5 == 0) {
                System.out.print("|");
                System.out.println();
            }else {
                System.out.print("|");
            }
        }
        System.out.println();
    }
}
