import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WasteManager manager = new WasteManager();

        boolean running = true;

        System.out.println("======================================");
        System.out.println("   ENVIRONMENTAL WASTE MANAGEMENT");
        System.out.println("======================================");

        while (running) {

            System.out.println("\n----------- MENU -----------");
            System.out.println("1. Add Waste");
            System.out.println("2. View All Waste");
            System.out.println("3. View Waste Statistics");
            System.out.println("4. Search Waste by Type");
            System.out.println("5. Environmental Report");
            System.out.println("6. Exit");
            System.out.println("----------------------------");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter waste type: ");
                    String type = scanner.nextLine();

                    double weight;

                    while (true) {
                        System.out.print("Enter weight (kg): ");

                        if (scanner.hasNextDouble()) {
                            weight = scanner.nextDouble();

                            if (weight > 0) {
                                break;
                            } else {
                                System.out.println(
                                        "Weight must be greater than 0."
                                );
                            }

                        } else {
                            System.out.println(
                                    "Please enter a valid number."
                            );
                            scanner.next();
                        }
                    }

                    String recyclableInput;

                    while (true) {
                        System.out.print(
                                "Is it recyclable? (yes/no): "
                        );

                        recyclableInput = scanner.next();

                        if (recyclableInput.equalsIgnoreCase("yes") ||
                                recyclableInput.equalsIgnoreCase("no")) {
                            break;
                        }

                        System.out.println(
                                "Please enter only yes or no."
                        );
                    }

                    boolean recyclable =
                            recyclableInput.equalsIgnoreCase("yes");

                    Waste waste =
                            new Waste(type, weight, recyclable);

                    manager.addWaste(waste);
                    FileManager.saveWaste(waste);

                    System.out.println(
                            "Waste added successfully!"
                    );
                    break;

                case 2:
                    manager.displayAllWaste();
                    break;

                case 3:
                    System.out.println("\n--- Waste Statistics ---");

                    System.out.printf(
                            "Total Waste: %.2f kg%n",
                            manager.getTotalWeight()
                    );

                    System.out.printf(
                            "Recyclable Waste: %.2f kg%n",
                            manager.getRecyclableWeight()
                    );

                    System.out.printf(
                            "Non-Recyclable Waste: %.2f kg%n",
                            manager.getNonRecyclableWeight()
                    );
                    break;

                case 4:
                    System.out.print(
                            "Enter waste type to search: "
                    );

                    String searchType = scanner.nextLine();

                    System.out.println(
                            "\n--- Search Results ---"
                    );

                    manager.searchByType(searchType);
                    break;

                case 5:
                    manager.generateEnvironmentalReport();
                    break;

                case 6:
                    running = false;

                    System.out.println(
                            "\nThank you for using the system!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }
}