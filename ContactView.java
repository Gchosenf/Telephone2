package com.gml.Client;

import java.util.Scanner;
import java.util.List;

public class ContactView {
    public void displayContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public Contact getUpdatedContact(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入新的电话: ");
        String phone = scanner.nextLine();
        System.out.print("请输入新的住址: ");
        String address = scanner.nextLine();
        return new Contact(name, phone, address);
    }
}
