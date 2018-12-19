package com.kwabenaberko.mvpsampleapp;

import java.util.List;

public class ContactsPresenterImpl implements ContactsPresenter {

    private ContactsRepository mContactsRepository;
    private ContactsView mContactsView;

    ContactsPresenterImpl(ContactsView contactsView){
        mContactsRepository = new ContactsRepository();
        mContactsView = contactsView;
    }

    @Override
    public void getContacts() {
        List<Contact> contacts = mContactsRepository.getContactList();
        mContactsView.showContacts(contacts);
    }
}
