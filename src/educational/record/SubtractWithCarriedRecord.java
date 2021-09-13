package educational.record;

import educational.model.FileUtils;

import java.util.ArrayList;

/**
 * Class that inheritance from Record
 * @see Record
 */
public class SubtractWithCarriedRecord extends Record{
    /**
     * Constructor with parameters
     * @param name A string with the player name
     * @param record A integer for record number
     */
    public SubtractWithCarriedRecord(String name, int record) {
        super(name, record);
    }
    /**
     * Static method that check if the player has a new record
     * @param name player's name
     * @param number A number for check
     * @param records A ArrayList with all the records
     * @return A boolean returns true if the number is greater
     */
    public static boolean checkSubtractWithCarriedRecord(String name ,int number, ArrayList<Record> records){
        boolean newRecord = false;
        for (int i = 0; i < records.size(); i++) {
            if(records.get(i) instanceof SubtractWithCarriedRecord){
                if(number > records.get(i).getRecord()){
                    newRecord = true;
                    records.get(i).setRecord(number);
                    records.get(i).setName(name);
                    FileUtils.saveRecords(records);
                }
            }
        }
        return newRecord;
    }
    /**
     * toString method for SumsRecord
     * @return A string with parameters splits with ";" and the name class
     */
    @Override
    public String toString(){
        return "Subtract With Carried Record - " + super.toString();
    }
}
