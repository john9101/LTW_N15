package dao;

import models.PaymentMethod;
import models.DeliveryMethod;

import java.util.List;

public class CheckoutDao {

    public List<DeliveryMethod> getAllInformationDeliveryMethod(){
        String sql = "SELECT id, typeShipping, description, shippingFee FROM delivery_methods";
        return GeneralDao.executeQueryWithSingleTable(sql, DeliveryMethod.class);
    }

    public List<PaymentMethod> getAllPaymentMethod(){
        String sql = "SELECT id, typeMethod FROM payment_methods";
        return GeneralDao.executeQueryWithSingleTable(sql, PaymentMethod.class);
    }

    public DeliveryMethod getDeliveryMethodById(int id){
        String sql = "SELECT id, shippingFee, typeShipping FROM delivery_methods WHERE id = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, DeliveryMethod.class, id).get(0);
    }

    public PaymentMethod getPaymentMethodById(int id){
        String sql = "SELECT id, typeMethod FROM payment_methods";
        return GeneralDao.executeQueryWithSingleTable(sql, PaymentMethod.class).get(0);
    }
}
