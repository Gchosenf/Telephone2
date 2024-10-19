package com.gml.Client;

public class Contact {
    private String name;
    private String phone;
    private String address;

    public Contact(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "姓名: " + name + ", 电话: " + phone + ", 住址: " + address;
    }
}

