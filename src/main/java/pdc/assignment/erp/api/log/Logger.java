package pdc.assignment.erp.api.log;

import java.io.*;

public class Logger {

    private Logger(){
        throw new IllegalStateException("Utility class");
    }

    public static String getLog(){
        StringBuilder context = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream("./derby.log");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                context.append(line);
                context.append("\n");
            }

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return context.toString();
    }
}
