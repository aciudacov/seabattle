package com.alexa;

public class Main {

    public static void main(String[] args) {
        FieldOperations operations = new FieldOperations();
	    int[][] field = operations.GetFieldFromFile("Corabii.in");

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println("\n");
        }

        field = operations.IncreaseField(field, true);
        System.out.println("Increased by 1 row");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println("\n");
        }
    }
}
