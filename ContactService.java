package com.gml.Server;

import com.gml.Client.Contact;
import com.gml.Dao.ContactDAO;
import java.util.List;

public class ContactService {
    private ContactDAO contactDAO;

    public ContactService() {
        this.contactDAO = new ContactDAO();
    }

    public void addContact(Contact contact) {
        contactDAO.saveContact(contact);
    }

    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    public void deleteContact(String name) {
        contactDAO.deleteContact(name);
    }

    public void updateContact(String name, Contact updatedContact) {
        contactDAO.updateContact(name, updatedContact);
    }
}
