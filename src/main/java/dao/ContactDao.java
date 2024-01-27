package dao;

import models.Contact;
import models.SubjectContact;

import java.util.List;
import java.util.Map;

public class ContactDao {

    public List<Contact> getListUserContacts(){
        return GeneralDao.executeQueryWithSingleTable("SELECT id, fullName, phone, email, `subject` FROM contacts", Contact.class);
    }

    public List<SubjectContact> getListContactSubjects(){
        String sql = "SELECT id , subjectName FROM contact_subjects";
        return GeneralDao.executeQueryWithSingleTable(sql, SubjectContact.class);
    }


    public int getIdContactSubjectByName(String subjectName){
        return (int) GeneralDao.executeQueryWithJoinTables("SELECT id FROM contact_subjects WHERE subjectName = ?", subjectName).get(0).get("id");
    }

    public void addNewRecordUserContact(Integer userId, String fullName, String phone, String email, int subjectId, String message){
        GeneralDao.executeAllTypeUpdate("INSERT INTO contact(userId, fullName, phone, email, subjectId, message) VALUES(?,?,?,?,?,?)", userId, fullName, phone, email, subjectId, message);
    }
}
