package com.kwabenaberko.mvpsampleapp;

import java.util.ArrayList;
import java.util.List;

public class ContactsRepository {
    private final List<Contact> mContactList = new ArrayList<>();


    List<Contact> getContactList(){
        return mContactList;
    }

    Contact add(Contact contact){
        mContactList.add(contact);
        return contact;
    }

    Contact update(Contact contact){
        int index = mContactList.indexOf(contact);
        mContactList.add(index, contact);
        return contact;
    }

    void delete(Contact contact){
        mContactList.remove(contact);
    }
}
