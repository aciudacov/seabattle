package com.alexa;

import java.io.BufferedReader;
import java.util.Scanner;

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
     * @return Returns true if ship was removed else returns false.
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
                if (sourceField[x-1][y] == 0 && sourceField[x][y-1] == 0)
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
        for (int i = 0; i < sourceField.length; i++) {
            for (int j = 0; j < sourceField[0].length; j++) {
                //do something
            }
        }
        return 0;
    }

    /**
     *
     * @param sourceField Source sea battle field where to identify ship.
     * @param x Vertical coordinate of the ship (specify highest point).
     * @param y Horizontal coordinate of the ship (specify leftmost point).
     * @return Returns ship type number (from 1 to 7).
     */
    public int GetShipType(int[][] sourceField, int x, int y)
    {
        return 0;
    }

    /**
     * Lists coordinates of ships from longest to shortest.
     * @param sourceField Source sea battle field where to calculate ships length.
     */
    public void ShowCoordinatesDesc(int[][] sourceField)
    {
        //do something
    }

    /**
     * Writes all horizontal ship coordinates to Orizont.txt file
     * @param sourceField Source sea battle field where to look for horizontal ships.
     */
    public void WriteHorizontal(int[][] sourceField)
    {
        //do something
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
