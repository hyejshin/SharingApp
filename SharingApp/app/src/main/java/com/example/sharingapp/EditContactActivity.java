package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.logging.Logger;

public class EditContactActivity extends AppCompatActivity implements Observer {

    private EditText username;
    private EditText email;
    private int REQUEST_CODE = 1;

    private ContactList contact_list = new ContactList();
    private ContactListController contactListController = new ContactListController(contact_list);
    Contact contact;
    private ContactController contactController;
    private Context context;
    private boolean on_create_update = false;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        context = getApplicationContext();

        Intent intent = getIntent();
        pos = intent.getIntExtra("position", 0);


        on_create_update = true;
        contactListController.addObserver(this);
        contactListController.loadContacts(context);
        on_create_update = false;

        username.setText(contactController.getUsername());
        email.setText(contactController.getEmail());
    }

    public void saveContact (View view) {

        String username_str = username.getText().toString();
        String email_str = email.getText().toString();

        if (username_str.equals("")) {
            username.setError("Empty field!");
            return;
        }

        if (email_str.equals("")) {
            email.setError("Empty field!");
            return;
        }

        if (!email_str.contains("@")) {
            email.setError("Must be an email address!");
            return;
        }

        String id = contactController.getId();
        Contact updatedContact = new Contact(username_str, email_str, id);

        boolean success = contactListController.editContact(contact, updatedContact, context);
        if(!success) {
            return;
        }

        // End AddItemActivity
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

    public void deleteContact(View view) {

        boolean success = contactListController.deleteContact(contact, context);
        if(!success){
            return;
        }

        // End EditItemActivity
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

    public void update() {
        System.out.print("update");
        if (on_create_update) {
            System.out.print("updated!!");
            contact = contactListController.getContact(pos);
            contactController = new ContactController(contact);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        contactListController.removeObserver(this);
    }
}
