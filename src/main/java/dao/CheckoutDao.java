package dao;

import models.PaymentMethod;
import models.Shipping;

import java.util.List;
import java.util.Set;

public class CheckoutDao {

    public List<Shipping> getAllInformationShipping(){
        String sql = "SELECT id, typeShipping, description, shippingFee FROM shippings";
        return GeneralDao.executeQueryWithSingleTable(sql, Shipping.class);
    }

    public List<PaymentMethod> getAllPaymentMethod(){
        String sql = "SELECT id, typeMethod FROM payment_methods";
        return GeneralDao.executeQueryWithSingleTable(sql, PaymentMethod.class);
    }

    public Shipping getShippingById(int id){
        String sql = "SELECT id, shippingFee, typeShipping FROM shippings";
        return GeneralDao.executeQueryWithSingleTable(sql, Shipping.class).get(0);
    }

    public PaymentMethod getPaymentMethodById(int id){
        String sql = "SELECT id, typeMethod FROM payment_methods";
        return GeneralDao.executeQueryWithSingleTable(sql, PaymentMethod.class).get(0);
    }
}
