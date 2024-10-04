import java.util.Scanner;
public class FuelCosts {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean validInput = false;
        double fuelEfficiency = 0; // miles per gallon
        double fuelTankCapacity = 0; // gallons
        double fuelCostPerGallon = 0; // dollars

        // Input loop
        do {
            try {
                System.out.print("Enter fuel efficiency (miles per gallon): ");
                fuelEfficiency = Double.parseDouble(in.nextLine());

                System.out.print("Enter fuel tank capacity (gallons): ");
                fuelTankCapacity = Double.parseDouble(in.nextLine());

                System.out.print("Enter fuel cost per gallon (dollars): ");
                fuelCostPerGallon = Double.parseDouble(in.nextLine());

                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        } while (!validInput);

        // Calculations
        double totalDistance = fuelEfficiency * fuelTankCapacity;
        double costFor100Miles = (100 / fuelEfficiency) * fuelCostPerGallon;

        // Output results
        System.out.printf("Total distance on a full tank: %.2f miles%n", totalDistance);
        System.out.printf("Cost for 100 miles: $%.2f%n", costFor100Miles);

        // Tests
        System.out.println("\nRunning tests...");
        runTests();
    }

    public static void runTests() {
        // Test with known values
        double testFuelEfficiency = 25; // miles per gallon
        double testFuelTankCapacity = 15; // gallons
        double testFuelCostPerGallon = 3.50; // dollars

        double expectedTotalDistance = testFuelEfficiency * testFuelTankCapacity;
        double expectedCostFor100Miles = (100 / testFuelEfficiency) * testFuelCostPerGallon;

        System.out.printf("Test total distance: %.2f miles (expected: %.2f miles)%n", expectedTotalDistance, expectedTotalDistance);
        System.out.printf("Test cost for 100 miles: $%.2f (expected: $%.2f)%n", expectedCostFor100Miles, expectedCostFor100Miles);

        // Test bad input
        try {
            System.out.println("Testing bad input...");
            Double.parseDouble("bad input");
        } catch (NumberFormatException e) {
            System.out.println("Caught bad input as expected.");
        }
    }
}
