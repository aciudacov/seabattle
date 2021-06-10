package com.alexa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class FieldOperations {

    /**
     * Creates sea battle field stored in two-dimensional array from file. Array size set in file.
     * @param filePath File path from where to create sea battle field.
     * @return Returns two-dimensional integer array filled according to file content with set dimensions.
     */
    public int[][] GetFieldFromFile(String filePath)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath));
            String line = reader.readLine();
            String[] fieldSize = line.split(" ");
            int x = parseInt(fieldSize[0]);
            int y = parseInt(fieldSize[1]);
            int[][] field = new int[x][y];
            int lineNum = 0;

            while (line != null)
            {
                line = reader.readLine();
                if (line == null)
                    break;
                String[] nums = line.split(" ");
                for (int i = 0; i < y; i++)
                {
                    field[lineNum][i] = parseInt(nums[i]);
                }
                lineNum++;
            }
            return field;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param sourceField Source sea battle field which will be increased.
     * @param addColumn If true, will add column, else add row.
     * @return Returns increased sea battle field.
     * */
    public int[][] IncreaseField(int[][] sourceField, boolean addColumn)
    {
        int x = sourceField.length;
        int y = sourceField[0].length;
        int x_new = x;
        int y_new = y;

        if (addColumn)
            y_new++;
        else
            x_new++;

        int[][] increasedField = new int[x_new][y_new];

        for (int i = 0; i < x; i++) //TODO: replace with System.arraycopy
            for (int j = 0; j < y; j++)
                increasedField[i][j] = sourceField[i][j];

        if (addColumn) //add column else add row
            for (int j = 0; j < x; j++)
                increasedField[j][y_new-1] = 0;
        else
            for (int j = 0; j < x_new; j++)
                increasedField[y_new - 1][j] = 0;

        return increasedField;
    }


    /**
     *
     * @param sourceField Source sea battle field from where the ship will be removed.
     * @param x Vertical coordinate of the ship (specify lowest point).
     * @param y Horizontal coordinate of the ship (specify rightmost point).
     * @return Returns true if ship was removed.
     */
    public boolean RemoveShip(int[][] sourceField, int x, int y)
    {
        try
        {
            if (x+1 < sourceField.length) //check down
            {
                if (sourceField[x+1][y] == 1)
                    return false;
            }
            else if (y+1 < sourceField[0].length) //check right
            {
                if (sourceField[x][y+1] == 1)
                    return false;
            }

            if (sourceField[x][y] == 0)
                return false;
            else
            {
                if (sourceField[x-1][y] == 0 && sourceField[x][y-1] == 0) //one-pos ship
                {
                    sourceField[x][y] = 0;
                    return true;
                }
                else if (sourceField[x-1][y] == 1 && sourceField[x][y-1] == 0) //go up
                {
                    sourceField[x][y] = 0;
                    while (x != 0 && sourceField[x-1][y] != 0)
                    {
                        sourceField[x-1][y] = 0;
                        x--;
                        if (x-1 == -1)
                            break;
                    }
                    return true;
                }
                else if (sourceField[x-1][y] == 0 && sourceField[x][y-1] == 1) //go left
                {
                    sourceField[x][y] = 0;
                    while (y != 0 && sourceField[x][y-1] != 0)
                    {
                        sourceField[x][y-1] = 0;
                        y--;
                        if (y-1 == -1)
                            break;
                    }
                    return true;
                }
            }
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Counts amount of ships on the sea battle field.
     * @param sourceField Source sea battle field where to count ships.
     * @return Returns amount of ships on the field according to rules.
     */
    public int GetShipCount(int[][] sourceField)
    {
        var fieldCopy = sourceField;
        var shipAmount = 0;
        try
        {
            for (int x = 0; x < fieldCopy.length; x++)
            {
                for (int y = 0; y < fieldCopy[0].length; y++)
                {
                    if (RemoveShip(fieldCopy, x, y))
                        shipAmount++;
                }
            }
            return shipAmount;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     *
     * @param sourceField Source sea battle field where to identify ship.
     * @param x Vertical coordinate of the ship (specify highest point).
     * @param y Horizontal coordinate of the ship (specify leftmost point).
     * @return Returns ship type number (from 1 to 7) or 0 if coordinate does not contain ship.
     */
    public int GetShipType(int[][] sourceField, int x, int y)
    {
        try
        {
            if (sourceField[x][y] == 0)
                return 0;
            if (x - 1 > -1)
            {
                if (sourceField[x - 1][y] == 1)
                    return 0;
            }
            if (y - 1 > -1)
            {
                if (sourceField[x][y - 1] == 1)
                    return 0;
            }
            if (x + 3 < sourceField.length)
            {
                if (sourceField[x][y] == 1 && sourceField[x + 1][y] == 1 && sourceField[x + 2][y] == 1 && sourceField[x + 3][y] == 1)
                    return 7;
                else if (sourceField[x][y] == 1 && sourceField[x + 1][y] == 1 && sourceField[x + 2][y] == 1)
                    return 6;
                else if (sourceField[x][y] == 1 && sourceField[x + 1][y] == 1)
                    return 5;
            }
            else if (x + 2 < sourceField.length)
            {
                if (sourceField[x][y] == 1 && sourceField[x + 1][y] == 1 && sourceField[x + 2][y] == 1)
                    return 6;
                else if (sourceField[x][y] == 1 && sourceField[x + 1][y] == 1)
                    return 5;
            }
            else if (x + 1 < sourceField.length)
            {
                if (sourceField[x][y] == 1 && sourceField[x + 1][y] == 1)
                    return 5;
            }
            else if (y + 3 < sourceField[0].length)
            {
                if (sourceField[x][y] == 1 && sourceField[x][y + 1] == 1 && sourceField[x][y + 2] == 1 && sourceField[x][y + 3] == 1)
                    return 4;
                else if (sourceField[x][y] == 1 && sourceField[x][y + 1] == 1 && sourceField[x][y + 2] == 1)
                    return 3;
                else if (sourceField[x][y] == 1 && sourceField[x][y + 1] == 1)
                    return 2;
            }
            else if (y + 2 < sourceField[0].length)
            {
                if (sourceField[x][y] == 1 && sourceField[x][y + 1] == 1 && sourceField[x][y + 2] == 1)
                    return 3;
                else if (sourceField[x][y] == 1 && sourceField[x][y + 1] == 1)
                    return 2;
            }
            else if (y + 1 < sourceField[0].length)
            {
                if (sourceField[x][y] == 1 && sourceField[x][y + 1] == 1)
                    return 2;
            }
            return 1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Lists coordinates of ships from longest to shortest.
     * @param sourceField Source sea battle field where to calculate ships length.
     */
    public ArrayList<ShipTypeCoordPair> GetCoordinatesDesc(int[][] sourceField)
    {
        var shipList = new ArrayList<ShipTypeCoordPair>();
        for (int x = 0; x < sourceField.length; x++)
        {
            for (int y = 0; y < sourceField[0].length; y++)
            {
                var shipType = GetShipType(sourceField, x, y);
                if (shipType != 0)
                    shipList.add(new ShipTypeCoordPair(shipType, x, y));
            }
        }
         shipList.sort(Comparator.comparing(ShipTypeCoordPair::getShipType).reversed());

        return shipList;
    }

    /**
     * Writes all horizontal ship coordinates to Orizont.txt file.
     * @param sourceField Source sea battle field where to look for horizontal ships.
     * @return Returns true if write to file was successful.
     */
    public boolean WriteHorizontal(int[][] sourceField)
    {
        try
        {
            var reqShips = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
            var file = new File("Orizont.txt");
            file.createNewFile();
            var writer = new BufferedWriter(new FileWriter("Orizont.txt"));
            var shipList = GetCoordinatesDesc(sourceField);
            for (var sh: shipList)
            {
                if (reqShips.contains(sh.ShipType))
                {
                    writer.write("Horizontal ship type is " + sh.ShipType + ". Top left coordinate is " + (sh.x + 1) + ":" + (sh.y + 1) + "\n");
                }
            }
            writer.close();

            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param sourceField Source sea battle field where to look for required rectangular area.
     */
    public void GetRectangle(int [][] sourceField)
    {
        //do something
    }

    /**
     *
     * @param sourceField Source sea battle field where attacked ships are.
     */
    public void AttackShips(int[][] sourceField)
    {
        //do something
    }

    public void OutputField(int[][] sourceField)
    {
        for (int i = 0; i < sourceField.length; i++)
        {
            for (int j = 0; j < sourceField[0].length; j++)
            {
                System.out.print(sourceField[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
