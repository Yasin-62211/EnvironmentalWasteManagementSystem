import java.util.ArrayList;
import java.util.List;

public class WasteManager {

    private final List<Waste> wasteList = new ArrayList<>();

    // Add a new waste item
    public void addWaste(Waste waste) {
        wasteList.add(waste);
    }

    // Display all waste items
    public void displayAllWaste() {
        if (wasteList.isEmpty()) {
            System.out.println("No waste records found.");
            return;
        }

        System.out.println("\n--- Waste Records ---");

        for (Waste waste : wasteList) {
            System.out.println(waste);
        }
    }

    // Calculate total waste weight
    public double getTotalWeight() {
        double total = 0;

        for (Waste waste : wasteList) {
            total += waste.getWeight();
        }

        return total;
    }

    // Calculate recyclable waste weight
    public double getRecyclableWeight() {
        double total = 0;

        for (Waste waste : wasteList) {
            if (waste.isRecyclable()) {
                total += waste.getWeight();
            }
        }

        return total;
    }

    // Calculate non-recyclable waste weight
    public double getNonRecyclableWeight() {
        double total = 0;

        for (Waste waste : wasteList) {
            if (!waste.isRecyclable()) {
                total += waste.getWeight();
            }
        }

        return total;
    }

    // Search waste by type
    public void searchByType(String type) {
        boolean found = false;

        for (Waste waste : wasteList) {
            if (waste.getType().equalsIgnoreCase(type)) {
                System.out.println(waste);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No waste found for type: " + type);
        }
    }
    public void generateEnvironmentalReport() {

        double total = getTotalWeight();
        double recyclable = getRecyclableWeight();
        double nonRecyclable = getNonRecyclableWeight();

        System.out.println("\n======================================");
        System.out.println("       ENVIRONMENTAL REPORT");
        System.out.println("======================================");

        System.out.printf("Total Waste: %.2f kg%n", total);
        System.out.printf("Recyclable Waste: %.2f kg%n", recyclable);
        System.out.printf("Non-Recyclable Waste: %.2f kg%n", nonRecyclable);

        if (total > 0) {

            double recyclingRate = (recyclable / total) * 100;

            System.out.printf(
                    "Recycling Rate: %.2f%%%n",
                    recyclingRate
            );

            if (recyclingRate >= 50) {
                System.out.println(
                        "Status: More than half of the waste is recyclable."
                );
            } else {
                System.out.println(
                        "Status: Recycling rate can be improved."
                );
            }
        }

        System.out.println("======================================");
    }
}
