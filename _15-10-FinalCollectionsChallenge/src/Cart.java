import java.time.LocalDate;
import java.util.Map;

public class Cart {

    enum CartType {PHYSICAL, VIRTUAL};

    private static int lastId = 1;
    private int id;
    private LocalDate cartDate;
    private CartType type;
    private Map<String, Integer> product;

    public Cart(CartType type, int days) {
        this.type = type;
    }

}
