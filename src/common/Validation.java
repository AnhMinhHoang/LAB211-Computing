/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Scanner;

/**
 *
 * @author GoldCandy
 */
public class Validation {

    public double inputDouble(String title) {
        double a;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(title + ": ");
                a = sc.nextInt();
                return a;
            } catch (Exception e) {
                System.err.println("Please input digit");
            }
        }
    }

    public String stringMatch(String title, String regrex) {
        String s = " ";
        while (!regrex.contains(s)) {
            Scanner sc = new Scanner(System.in);
            System.out.print(title + ": ");
            s = sc.nextLine();
            if (s.equals("=")) {
                return s;
            }
            if (!regrex.contains(s)) {
                System.err.print("Please input (");
                for (int i = 0; i < regrex.length(); i++) {
                    System.err.print(regrex.charAt(i) + ", ");
                }
                System.err.print(")");
                System.err.println("");
            }
        }
        return s;
    }
}
