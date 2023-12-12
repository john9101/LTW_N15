package dao;

import models.Vouchers;

import java.util.List;

public class ShoppingCartDao {
    public List<Vouchers> getListVouchers(){
        String sql = "SELECT id, `code`, `description`, minimumPrice, discountPercent, expiryDate FROM vouchers";
        return GeneralDao.executeQueryWithSingleTable(sql, Vouchers.class);
    }
}
