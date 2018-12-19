package com.kwabenaberko.mvpsampleapp.presentation;

import com.kwabenaberko.mvpsampleapp.view.ContactsView;

public interface ContactsPresenter {
    void setView(ContactsView contactsView);
    void saveContact();
}
