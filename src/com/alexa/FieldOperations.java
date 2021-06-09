package com.alexa;

import java.io.BufferedReader;

import static java.lang.Integer.parseInt;

public class FieldOperations {
    public int[][] GetFieldFromFile(String file_path)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file_path));
            String line = reader.readLine();
            String[] fieldSize = line.split(" ");
            int x = parseInt(fieldSize[0]);
            int y = parseInt(fieldSize[1]);
            int[][] field = new int[x][y];
            int lineNum = 0;

            while (line != null)
            {
                line = reader.readLine();
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
}
