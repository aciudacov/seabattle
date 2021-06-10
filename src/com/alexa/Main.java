package com.alexa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FieldOperations operations = new FieldOperations();
	    int[][] field = operations.GetFieldFromFile("Corabii.in");

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println("\n");
        }
        System.out.println("Enter type of operation, 1 if you want to add a column, 0 if a row");
        int type = scanner.nextInt();
        System.out.println("Your choice is read");
        String str = scanner.nextLine();
        field = operations.IncreaseField(field, type);
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println("\n");
        }
    }
}
