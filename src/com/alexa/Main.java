package com.alexa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var operations = new FieldOperations();
	    var field = operations.GetFieldFromFile("Corabii.in");

        operations.OutputField(field);
        System.out.println("Input bottom rightmost coordinate of the ship to remove");
        System.out.println("Input left topmost coordinate of the ship to identify");
        /*var x = scanner.nextInt()-1;
        var y = scanner.nextInt()-1;
        System.out.println("Selected ship is of type " + operations.GetShipType(field, x, y));

        System.out.println("Removed ship? " + operations.RemoveShip(field, x, y));*/

        operations.OutputField(field);

        var shipList = operations.GetCoordinatesDesc(field);
        for (var sh: shipList)
        {
            System.out.println("Ship type is " + sh.ShipType + ", it starts at x:" + (sh.x+1) + " y:" + (sh.y+1));
        }
        System.out.println("Write to file success? " + operations.WriteHorizontal(field, "Orizont.txt"));



        System.out.println("Amount of ships is " + operations.GetShipCount(field));
        var postAttack = operations.AttackShips(field, "Atac.in");
        operations.OutputField(postAttack);
        System.out.println("Write attack result to file " + operations.AnalyzeAttack(field, postAttack, "Corabii.out"));

        /*System.out.println("Enter 1 if you want to add a column or any number for adding a row");
        var type = scanner.nextInt();
        field = operations.IncreaseField(field, type == 1 ? true : false);
        operations.OutputField(field);*/
    }
}
