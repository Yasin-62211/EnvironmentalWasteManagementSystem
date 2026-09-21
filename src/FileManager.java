import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileManager {

    private static final String FILE_NAME = "waste_data.txt";

    public static void saveWaste(Waste waste) {

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(FILE_NAME, true))) {

            writer.println(
                    waste.getType() + "," +
                            waste.getWeight() + "," +
                            waste.isRecyclable()
            );

        } catch (IOException e) {
            System.out.println("Error saving waste data.");
        }
    }

    public static void displaySavedData() {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            System.out.println("\n--- Saved Waste Data ---");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("No saved data found.");
        }
    }
}