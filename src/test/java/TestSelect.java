import services.ReviewServices;
import utils.ProductFactory;

public class TestSelect {
    public static void main(String[] args) {
        System.out.println(ProductFactory.getListSizesByProductId(3));
        System.out.println(ReviewServices.getINSTANCE().getListReview(43));
    }
}
