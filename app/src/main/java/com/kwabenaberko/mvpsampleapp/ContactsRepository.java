package com.kwabenaberko.mvpsampleapp;

import java.util.ArrayList;
import java.util.List;

public class ContactsRepository {
    private final List<Contact> mContactList = new ArrayList<>();

    ContactsRepository(){

        mContactList.add(new Contact("Kwabena", "Berko", "0571234567"));
        mContactList.add(new Contact("Roy", "Mensah", "0279876543"));

    }

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
