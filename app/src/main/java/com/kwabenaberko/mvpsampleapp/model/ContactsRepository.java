package com.kwabenaberko.mvpsampleapp.model;

import java.util.ArrayList;
import java.util.List;

public class ContactsRepository {
    private final List<Contact> mContactList = new ArrayList<>();


    public List<Contact> getContactList(){
        return mContactList;
    }

    public Contact add(Contact contact){
        mContactList.add(contact);
        return contact;
    }

    public Contact update(Contact contact){
        int index = mContactList.indexOf(contact);
        mContactList.add(index, contact);
        return contact;
    }

    public void delete(Contact contact){
        mContactList.remove(contact);
    }
}
