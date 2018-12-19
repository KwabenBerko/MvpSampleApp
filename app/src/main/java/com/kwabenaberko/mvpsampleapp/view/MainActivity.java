package com.kwabenaberko.mvpsampleapp.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kwabenaberko.mvpsampleapp.R;
import com.kwabenaberko.mvpsampleapp.model.Contact;
import com.kwabenaberko.mvpsampleapp.presentation.ContactsPresenter;
import com.kwabenaberko.mvpsampleapp.presentation.ContactsPresenterImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactsView {

    private ContactsPresenter mContactsPresenter;
    private ContactAdapter mContactAdapter;
    private TextInputEditText firstNameEditText;
    private TextInputEditText lastNameEditText;
    private TextInputEditText phoneNumberEditText;
    private LinearLayout mLinearLayout;
    private RecyclerView contactsRecyclerView;
    private Button saveContactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mLinearLayout = findViewById(R.id.main_layout);
        firstNameEditText = findViewById(R.id.first_name_edit_text);
        lastNameEditText = findViewById(R.id.last_name_edit_text);
        phoneNumberEditText = findViewById(R.id.phone_number_edit_text);
        contactsRecyclerView = findViewById(R.id.contacts_recycler_view);
        saveContactBtn = findViewById(R.id.save_contact_btn);

        mContactAdapter = new ContactAdapter();
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        contactsRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        contactsRecyclerView.setAdapter(mContactAdapter);

        saveContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContactsPresenter.saveContact();
            }
        });


        mContactsPresenter = new ContactsPresenterImpl();
        mContactsPresenter.setView(this);

    }

    @Override
    public void showError(String message) {
        Snackbar.make(mLinearLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void displayContactSaved() {
        Snackbar.make(mLinearLayout, "Contact saved", Snackbar.LENGTH_SHORT).show();
        firstNameEditText.setText("");
        lastNameEditText.setText("");
        phoneNumberEditText.setText("");
    }

    @Override
    public void showContacts(List<Contact> contacts) {
        mContactAdapter.updateContactList(contacts);
    }

    @Override
    public String getFirstName() {
        return firstNameEditText.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastNameEditText.getText().toString();
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumberEditText.getText().toString();
    }
}
