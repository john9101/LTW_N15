package dao;

import java.util.List;

public interface ImageDAO {
    public List<Image> getImg(String productId);

    public List<Image> getThumbnail(int productId);
}
