public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistence = new FilePersistenceService();

        String filePath = "inventory.txt";

        // Load previous state
        persistence.loadInventory(inventory, filePath);

        // Show current inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getAvailableRooms("Single"));
        System.out.println("Double: " + inventory.getAvailableRooms("Double"));
        System.out.println("Suite: " + inventory.getAvailableRooms("Suite"));

        // Save state
        persistence.saveInventory(inventory, filePath);
    }
}