package services;

import dao.ContactDao;
import dao.GeneralDao;
import models.Contacts;

import java.util.List;
import java.util.Map;

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

    public List<Map<String, Object>> getListContactSubjects(){
        return contactDao.getListContactSubjects();
    }

    public int getIdContactSubjectByName(String subjectName){
        return contactDao.getIdContactSubjectByName(subjectName);
    }

    public void addNewRecordUserContact(String fullName, String phone, String email, int subjectId, String message){
        contactDao.addNewRecordUserContact(fullName, phone, email, subjectId, message);
    }
}
