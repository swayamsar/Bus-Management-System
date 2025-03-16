import javax.swing.*;  // Import for JPasswordField
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class AdminMenu {
    
    private int passengerId;
    
    public AdminMenu() {
        this.passengerId = 0; // Default initialization
    }
    
    public int getPassengerId() {
        return passengerId;
    }
    
    public static void main(String[] args) {
        // Example usage of JPasswordField
        JPasswordField passwordField = new JPasswordField();
        JOptionPane.showMessageDialog(null, passwordField, "Enter Password", JOptionPane.PLAIN_MESSAGE);
        char[] password = passwordField.getPassword();
        System.out.println("Entered Password: " + new String(password));

        // Example of reading an object from a file
        ArrayList<Passenger> passengers = readObjectFromFile("passengers.dat", Passenger.class);
        System.out.println("Loaded Passengers: " + passengers);
    }

    // Generic method to read objects from a file
    public static <T> ArrayList<T> readObjectFromFile(String filename, Class<T> clazz) {
        ArrayList<T> tempList = new ArrayList<>();
        try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = objectInput.readObject();
            if (obj instanceof ArrayList<?>) {
                tempList = ((ArrayList<?>) obj).stream()
                        .filter(clazz::isInstance)
                        .map(clazz::cast)
                        .collect(Collectors.toCollection(ArrayList::new));
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return tempList;
    }
}

// A sample Passenger class (Make sure you have this class)
class Passenger implements Serializable {
    private int id;
    private String name;
    
    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Passenger{id=" + id + ", name='" + name + "'}";
    }
}
