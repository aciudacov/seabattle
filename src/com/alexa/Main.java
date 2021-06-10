package com.alexa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var operations = new FieldOperations();
	    var field = operations.GetFieldFromFile("Corabii.in");

        for (int i = 0; i < field.length; i++)
        {
            for (int j = 0; j < field[0].length; j++)
            {
                System.out.print(field[i][j]);
            }
            System.out.println("\n");
        }
        System.out.println("Enter 1 if you want to add a column or any number for adding a row");
        var type = scanner.nextInt();
        field = operations.IncreaseField(field, type == 1 ? true : false);
        
        for (int i = 0; i < field.length; i++)
        {
            for (int j = 0; j < field[0].length; j++)
            {
                System.out.print(field[i][j]);
            }
            System.out.println("\n");
        }
    }
}
