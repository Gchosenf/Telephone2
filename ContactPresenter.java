package com.gml.Client;

import com.gml.Server.ContactService;
import java.util.List;

public class ContactPresenter {
    private ContactView view;
    private ContactService service;

    public ContactPresenter(ContactView view) {
        this.view = view;
        this.service = new ContactService();
    }

    public void addContact(Contact contact) {
        service.addContact(contact);
    }

    public void showContacts() {
        List<Contact> contacts = service.getAllContacts();
        view.displayContacts(contacts);
    }

    public void deleteContact(String name) {
        service.deleteContact(name);
    }

    public void updateContact(String name, Contact updatedContact) {
        service.updateContact(name, updatedContact);
    }

    public ContactView getView() {
        return view;
    }
}
