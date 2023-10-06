/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author ADMIN
 */
public class Library {

    static Scanner sc = new Scanner(System.in);

    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

    public int getInt(String promt) {
        Integer a = null;

        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a != null) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        return a;
    }
public int getCode(String prompt, Predicate<Integer> p, String filterString) {
    Integer code = null;

    while (true) {
        System.out.print(prompt + ": ");
        try {
            String input = sc.nextLine();
            code = Integer.parseInt(input);
            if (code != null) {
                if (p.test(code)) {
                    break;
                } else {
                    System.out.println(filterString);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
        }
    }
    return code;
}
    public String getString(String promt) {
        String result = "";
        while (true) {
            System.out.print(promt + ": ");
            try {
                result = sc.nextLine().trim();

                if (!result.isEmpty()) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a String");
            }
        }
        return result;

    }

    public int[] createArray(int size_Array) {
        int[] array = new int[size_Array];
        Random rd = new Random();
        for (int i = 0; i < size_Array; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }

    public void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("");
    }
    public boolean checkInputYN() {
        while (true) {
            String result = getString("Do you want to continue (Y/N)? ");
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
}
