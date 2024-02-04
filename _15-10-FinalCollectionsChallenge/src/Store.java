import java.util.*;

public class Store {

    private static Random random = new Random();
    private Map<String, InventoryItem> inventory;
    private NavigableSet<Cart> carts = new TreeSet<>(Comparator.comparing(Cart::getId));
    private Map<Category, Map<String, InventoryItem>> asleInventory;

    public static void main(String[] args) {


    }

    private void manageStoreCarts() {

    }

    private boolean checkOUtCart(Cart cart) {

        return false;
    }
}
