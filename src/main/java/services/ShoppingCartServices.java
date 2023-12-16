package services;

import dao.ShoppingCartDao;
import models.Vouchers;

import java.util.List;

public class ShoppingCartServices {

    private ShoppingCartDao shoppingCartDao;

    private static ShoppingCartServices INSTANCE;

    public ShoppingCartServices() {
        shoppingCartDao = new ShoppingCartDao();
    }

    public static ShoppingCartServices getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new ShoppingCartServices();
        return INSTANCE;
    }
    public List<Vouchers> getListVouchers(){
        return shoppingCartDao.getListVouchers();
    }

    public Vouchers getDiscountPercentByCode(double temporaryPrice, String code){
        return shoppingCartDao.getDiscountPercentByCode(temporaryPrice, code);
    }

    public List<String> getListCodeOfVouchers(){
        return shoppingCartDao.getListCodeOfVouchers();
    }
}
