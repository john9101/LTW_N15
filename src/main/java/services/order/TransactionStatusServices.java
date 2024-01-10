package services.order;

import dao.order.OrderStatusDao;
import dao.order.TransactionStatusDao;
import models.TransactionStatus;

import java.util.List;

public class TransactionStatusServices {
    private TransactionStatusDao transactionStatusDao;
    private static TransactionStatusServices INSTANCE;

    public TransactionStatusServices() {
        transactionStatusDao = new TransactionStatusDao();
    }

    public static TransactionStatusServices getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new TransactionStatusServices();
        return INSTANCE;
    }

    public List<TransactionStatus> getListAllTransactionStatus(){
        return transactionStatusDao.getListAllTransactionStatus();
    }
}
