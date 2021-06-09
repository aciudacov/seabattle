package com.alexa;

import java.io.File;
import java.net.URL;

public class FileReader {
    public int[][] GetFieldFromFile(String file_path)
    {
        URL url = getClass().getResource(file_path);
        File file = new File(url.getPath());
        return null;
    }
}
