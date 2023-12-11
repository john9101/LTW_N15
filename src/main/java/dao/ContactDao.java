package dao;

import models.Contacts;
import models.User;

import java.util.List;
import java.util.Map;

public class ContactDao {

    public List<Contacts> getListUserContacts(){
        return GeneralDao.executeQueryWithSingleTable("SELECT id, fullName, phone, email, `subject` FROM contacts", Contacts.class);
    }

    public List<Map<String, Object>> getListContactSubjects(){
        return GeneralDao.executeQueryWithJoinTables("SELECT subjectName FROM contact_subjects");
    }

    public static int getIdContactSubjectByName(String subjectName){
        return (int) GeneralDao.executeQueryWithJoinTables("SELECT id FROM contact_subjects WHERE subjectName = ?", subjectName).get(0).get("id");
    }

    public void addNewRecordUserContact(int userId, String fullName, String phone, String email, int subjectId, String message){
        GeneralDao.executeAllTypeUpdate("INSERT INTO contact(userId, fullName, phone, email, subjectId, message) VALUES(?,?,?,?,?,?)", userId, fullName, phone, email, subjectId, message);
    }
}
