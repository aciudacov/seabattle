package com.alexa;

import java.io.BufferedReader;

import static java.lang.Integer.parseInt;

public class FieldOperations {

    /**
     *
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
    public int[][] IncreaseField(int[][] sourceField, boolean addRow)
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
            for (int j = 0; j < y; j++)
                increasedField[j][y_new-1] = 0;

        return increasedField;
    }
}
