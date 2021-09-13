package educational.model;
/**
 * Class for make a player
 */
public class Player {
    private String name;
    private byte age;

    /**
     * Constructor with parameters
     * @param name player's name
     * @param age player's age
     */
    public Player(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns player's name
     * @return A string with player's name
     */
    public String getName() {
        return name;
    }
}
