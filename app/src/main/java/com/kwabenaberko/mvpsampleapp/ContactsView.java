package com.kwabenaberko.mvpsampleapp;

import java.util.List;

public interface ContactsView {
    String getFirstName();
    String getLastName();
    String getPhoneNumber();

    void showError(String message);

    void displayContactSaved();
    void showContacts(List<Contact> contacts);
}
