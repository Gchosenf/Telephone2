package com.gml.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactPresenter presenter = new ContactPresenter(new ContactView());

        while (true) {
            System.out.println("1. 添加联系人");
            System.out.println("2. 查看联系人");
            System.out.println("3. 删除联系人");
            System.out.println("4. 修改联系人");
            System.out.println("5. 退出");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("姓名: ");
                    String name = scanner.nextLine();
                    System.out.print("电话: ");
                    String phone = scanner.nextLine();
                    System.out.print("住址: ");
                    String address = scanner.nextLine();
                    presenter.addContact(new Contact(name, phone, address));
                    break;
                case 2:
                    presenter.showContacts();
                    break;
                case 3:
                    System.out.print("请输入要删除的联系人的姓名: ");
                    String contactName = scanner.nextLine();
                    presenter.deleteContact(contactName);
                    break;
                case 4:
                    System.out.print("请输入要修改的联系人的姓名: ");
                    String contactToUpdate = scanner.nextLine();
                    Contact updatedContact = presenter.getView().getUpdatedContact(contactToUpdate);
                    presenter.updateContact(contactToUpdate, updatedContact);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("无效选择，请重试。");
                    break;
            }
        }
    }
}
