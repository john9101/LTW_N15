import services.CategoryService;

public class ProductCard {
    public static void main(String[] args) {
        filterCategory();
    }

    public static void filterCategory() {
        String[] input = new String[]{"10", "11", "12", "13", "1"};
        System.out.println(CategoryService.getINSTANCE().checkIDValid(input));
    }
}
