package services;

import dao.ContactDao;
import dao.GeneralDao;
import models.Contacts;

import java.util.List;

public class ContactServices {

    private ContactDao contactDao;

    private static ContactServices INSTANCE;

    public ContactServices() {
        contactDao = new ContactDao();
    }

    public static ContactServices getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ContactServices();
        }
        return INSTANCE;
    }

    public List<Contacts> getListUserContacts(){
        return contactDao.getListUserContacts();
    }

    public void addNewRecordUserContact(String fullName, String phone, String email, String subject, String message){
        contactDao.addNewRecordUserContact(fullName, phone, email, subject, message);
    }
}
