package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FlooidChallenge {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int nPeach = 0;
        int nAvocado = 0;
        int nMango = 0;

        try {
            nPeach = scan.nextInt();
            nAvocado = scan.nextInt();
            nMango = scan.nextInt();
            if(nPeach <0 || nAvocado <0 || nMango <0) {
                System.err.println("Input shouldn't be negative.");
                return;
            }
            scan.close();
        } catch(InputMismatchException ex) {
            System.err.println("Token does not match the Integer " +
                    "regular expression, or is out of range");
            return;
        } catch(NoSuchElementException ex) {
            System.err.println("Input is exhuasted");
            return;
        } catch(IllegalStateException ex) {
            System.err.println("This scanner is closed");
            return;
        }

        float sum = 0;
        if(nPeach < 4) sum+= 0.75 * nPeach;
        else sum+= 0.75 * 3 + 0.5*(nPeach -3);

        sum+= 2*nAvocado;

        int rem = nMango % 2;
        int pair = (nMango-rem)/2;
        sum += pair *2 + (rem * 2);
        System.out.println(sum);
    }

}
