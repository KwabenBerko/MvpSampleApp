package com.kwabenaberko.mvpsampleapp.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kwabenaberko.mvpsampleapp.R;
import com.kwabenaberko.mvpsampleapp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> mContactList;

    public ContactAdapter(){
        mContactList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = mContactList.get(position);
        holder.fullNameTextView.setText(contact.getFirstName() + " " + contact.getLastName());
        holder.phoneNumberTextView.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    void updateContactList(List<Contact> contacts){
        mContactList = contacts;
        notifyDataSetChanged();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{

        private TextView fullNameTextView;
        private TextView phoneNumberTextView;

        ContactViewHolder(View itemView) {
            super(itemView);
            fullNameTextView = itemView.findViewById(R.id.full_name_textview);
            phoneNumberTextView = itemView.findViewById(R.id.phone_number_textview);
        }
    }
}
