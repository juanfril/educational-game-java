package educational.record;

import educational.model.FileUtils;

import java.util.ArrayList;

/**
 * SuperClass for save records
 */
public abstract class Record {
    protected String name;
    protected int record;

    /**
     * Constructor with parameters
     * @param name A string with the player name
     * @param record A integer for record number
     */
    public Record(String name, int record) {
        this.name = name;
        this.record = record;
    }
    /**
     * Establishes player's name
     * @param name String with name into MainScene
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method get for player's record
     * @return A int with player's record
     */
    public int getRecord() {
        return record;
    }

    /**
     * Establishes player's record
     * @param record A int with player's record
     */
    public void setRecord(int record) {
        this.record = record;
    }

    /**
     * toString method for Record class
     * @return A string with two properties split for ";"
     */
    @Override
    public String toString() {
        return  name + " - " + record;
    }
}
