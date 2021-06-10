package com.alexa;

//import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.util.List;
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
     * @param addRow If true, will add row. If false, will add column.
     * @return Returns increased sea battle field.
     * */
    public int[][] IncreaseField(int[][] sourceField, int addRow)
    {
        int x = sourceField.length;
        int y = sourceField[0].length;
        Scanner sss = new Scanner(System.in);
        int x_new = x;
        int y_new = y;
        int [] tempArray;

        if (addRow == 1) {
            y_new++;
        }
        else {
            x_new++;
        }

        int[][] increasedField = new int[x_new][y_new];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                increasedField[i][j] = sourceField[i][j];
            }
        }

        if (addRow == 1) {
            for (int j = 0; j < x; j++) {
                increasedField[j][y_new-1] = sss.nextInt();//добавляет столбец если вводим 1
            }
        }
        else {
            for (int j = 0; j < x_new; j++)
                increasedField[y_new - 1][j] = sss.nextInt();//добавляем строку если вводим 0
        }


        return increasedField;
    }

    public int[][] IncreaseFieldVer2(int[][] sourceField, boolean addRow)
    {
        int x = sourceField.length;
        int y = sourceField[0].length;

        int x_new = x;
        int y_new = y;

        if (addRow)
            y_new++;
        else
            x_new++;

        int[][] increasedField = new int[x_new][y_new];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                increasedField[i][j] = sourceField[i][j];
            }
        }

        if (addRow)
            for (int j = 0; j < y; j++)
                increasedField[x_new-1][j] = 0;
        else
            for (int j = 0; j < y; j++) {

                increasedField[j][y_new-1] =1 ;
            }


        return increasedField;
    }
    /**
     *
     * @param sourceField Source sea battle field which will be modified.
     * @param x Vertical coordinate of the ship (specify lowest point).
     * @param y Horizontal coordinate of the ship (specify rightmost point).
     * @return Returns modified sea battle field without the ship whose coords were specified.
     */
    public int[][] RemoveShip(int[][] sourceField, int x, int y)
    {
        return null;
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
}
