package com.kwabenaberko.mvpsampleapp;

import java.util.List;

public class ContactsPresenterImpl implements ContactsPresenter {

    private ContactsRepository mContactsRepository;
    private ContactsView mContactsView;

    ContactsPresenterImpl(){
        mContactsRepository = new ContactsRepository();
    }

    @Override
    public void setView(ContactsView contactsView) {
        mContactsView = contactsView;
        loadContacts();
    }

    private void loadContacts() {
        List<Contact> contacts = mContactsRepository.getContactList();
        mContactsView.showContacts(contacts);
    }

    @Override
    public void saveContact() {
        String firstName = mContactsView.getFirstName();
        String lastName = mContactsView.getLastName();
        String phoneNumber = mContactsView.getPhoneNumber();

        if(firstName.isEmpty()){
            mContactsView.showError("Invalid first name");
        }

        else if(lastName.isEmpty()){
            mContactsView.showError("Invalid last name");
        }

        else if(phoneNumber.isEmpty()){
            mContactsView.showError("Invalid phone number");
        }

        else{
            Contact newContact = new Contact(firstName, lastName, phoneNumber);
            mContactsRepository.add(newContact);
            mContactsView.displayContactSaved();
            loadContacts();
        }
    }
}
