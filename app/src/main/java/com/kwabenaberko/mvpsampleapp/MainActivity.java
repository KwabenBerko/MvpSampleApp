package com.kwabenaberko.mvpsampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactsView {

    private ContactsPresenter mContactsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mContactsPresenter = new ContactsPresenterImpl(this);
        mContactsPresenter.getContacts();

    }

    @Override
    public void showContacts(List<Contact> contacts) {
        Toast.makeText(this, contacts.size() + "", Toast.LENGTH_LONG).show();
    }
}
