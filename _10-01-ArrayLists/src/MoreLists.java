import java.util.List;

public class MoreLists {

    public static void main(String[] args) {

        String[] items = {"apples" , "bananas", "eggs"};

        List<String> list = List.of(items);
        System.out.println(list);

        System.out.println(list.getClass().getName());
    }
}
