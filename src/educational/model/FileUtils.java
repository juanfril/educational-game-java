package educational.model;

import educational.record.*;

import java.io.*;
import java.util.ArrayList;

/**
 * Class for load and save records
 */
public class FileUtils {
    /**
     * Method for load records into an ArrayList
     * @return ArrayList with the records
     */
    public static ArrayList<Record> loadRecords(){
        ArrayList<Record> records = new ArrayList<>();

        if (! (new File("records.txt")).exists() ) {
            System.out.println("File records.txt not found");
            return records;
        }
        else{
            try{
                BufferedReader inputFile = new BufferedReader(
                        new FileReader("records.txt"));
                String line;
                do {
                    line = inputFile.readLine();
                    if(line != null){
                        String[] lineSplit = line.split("-");
                        switch (lineSplit[0]){
                            case "Sums Record ":
                                records.add(new SumsRecord(
                                        lineSplit[1], Integer.parseInt(lineSplit[2]
                                            .replace(" ",""))
                                ));
                                break;
                            case "Subtract Record ":
                                records.add(new SubtractRecord(
                                        lineSplit[1], Integer.parseInt(lineSplit[2]
                                            .replace(" ",""))
                                ));
                                break;
                            case "Subtract With Carried Record ":
                                records.add(new SubtractWithCarriedRecord(
                                        lineSplit[1], Integer.parseInt(lineSplit[2]
                                            .replace(" ",""))
                                ));
                                break;
                            case "Mouse Record ":
                                records.add(new MouseRecord(
                                        lineSplit[1], Integer.parseInt(lineSplit[2]
                                            .replace(" ",""))
                                ));
                                break;
                            case "How Many Record ":
                                records.add(new HowManyRecord(
                                        lineSplit[1], Integer.parseInt(lineSplit[2]
                                            .replace(" ",""))
                                ));
                                break;
                        }
                    }
                } while (line != null);
                inputFile.close();
            }
            catch (IOException fileError) {
                System.out.println(
                        "There has been some problems: " +
                                fileError.getMessage() );
            }
        }
        return records;
    }
    /**
     * Method for save records into an ArrayList
     * @param records ArrayList with the records
     */
    public static void saveRecords( ArrayList<Record> records ){
        PrintWriter printerWriter = null;
        try{
            printerWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter("records.txt")));
            for (int i = 0; i < records.size(); i++) {
                printerWriter.println(records.get(i));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (printerWriter != null){
                printerWriter.close();
            }
        }
    }
}
