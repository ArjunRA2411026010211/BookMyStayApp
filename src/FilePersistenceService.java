import java.io.*;

public class FilePersistenceService {

    // Save inventory to file
    public void saveInventory(RoomInventory inventory, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.write("Single=" + inventory.getAvailableRooms("Single"));
            writer.newLine();
            writer.write("Double=" + inventory.getAvailableRooms("Double"));
            writer.newLine();
            writer.write("Suite=" + inventory.getAvailableRooms("Suite"));

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

    // Load inventory from file
    public void loadInventory(RoomInventory inventory, String filePath) {

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");

                String type = parts[0];
                int count = Integer.parseInt(parts[1]);

                inventory.setRoomCount(type, count); // ⚠️ make sure this method exists
            }

            System.out.println("Inventory loaded successfully.");

        } catch (Exception e) {
            System.out.println("Error loading inventory. Starting fresh.");
        }
    }
}