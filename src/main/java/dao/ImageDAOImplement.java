package dao;

import java.util.List;

public class ImageDAOImplement implements ImageDAO {
    @Override
    public List<Image> getImg(String productId) {
        return null;
    }

    @Override
    public List<Image> getThumbnail(int productId) {
        String sql = "SELECT nameImage FROM images WHERE productId = ? AND isThumbnail = 1";
        return GeneralDao.executeQueryWithSingleTable(sql, Image.class, productId);
    }
}
