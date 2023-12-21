package services;

import dao.CheckoutDao;
import dao.ProductDao;
import models.PaymentMethod;
import models.Shipping;

import java.util.List;

public class CheckoutServices {
    private CheckoutDao checkoutDao;
    private static CheckoutServices INSTANCE;

    public CheckoutServices() {
        checkoutDao = new CheckoutDao();
    }

    public static CheckoutServices getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new CheckoutServices();
        return INSTANCE;
    }

    public List<Shipping> getAllInformationShipping(){
        return checkoutDao.getAllInformationShipping();
    }

    public List<PaymentMethod> getAllPaymentMethod(){
        return checkoutDao.getAllPaymentMethod();
    }
}
