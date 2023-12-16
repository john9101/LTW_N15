package dao;

import models.Vouchers;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDao {
    public List<Vouchers> getListVouchers(){
        String sql = "SELECT id, `code`, `description`, minimumPrice, discountPercent, expiryDate FROM vouchers";
        return GeneralDao.executeQueryWithSingleTable(sql, Vouchers.class);
    }

    public static Vouchers getDiscountPercentByCode(double temporaryPrice, String code){
        String sql = "SELECT discountPercent, minimumPrice FROM vouchers WHERE minimumPrice <= ? AND expiryDate >= CURDATE() AND `code` = ?";
        List<Vouchers> listVouchers = GeneralDao.executeQueryWithSingleTable(sql, Vouchers.class, temporaryPrice, code);
        if (!listVouchers.isEmpty()){
            return listVouchers.get(0);
        }else{
            return null;
        }
    }

    public List<String> getListCodeOfVouchers(){
        List<String> listCodeOfVouchers = new ArrayList<>();
        String sql = "SELECT `code` FROM Vouchers";
        List<Vouchers> listVouchers = GeneralDao.executeQueryWithSingleTable(sql, Vouchers.class);
        for (Vouchers voucher: listVouchers){
            listCodeOfVouchers.add(voucher.getCode());
        }
        return listCodeOfVouchers;
    }

    public static void main(String[] args) {
        System.out.println(getDiscountPercentByCode(222, "sss"));
    }
}
