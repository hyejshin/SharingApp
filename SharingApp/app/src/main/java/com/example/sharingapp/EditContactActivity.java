package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditContactActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private int REQUEST_CODE = 1;

    private ContactList contact_list = new ContactList();
    Contact contact;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        context = getApplicationContext();
        contact_list.loadContacts(context);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("position", 0);

        contact = contact_list.getContact(pos);

        username.setText(contact.getUsername());
        email.setText(contact.getEmail());
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

        String id = contact.getId();
        contact_list.deleteContact(contact);

        Contact contact = new Contact(username_str, email_str, id);

        contact_list.addContact(contact);
        contact_list.saveContacts(context);

        // End AddItemActivity
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

    public void deleteContact(View view) {
        contact_list.deleteContact(contact);
        contact_list.saveContacts(context);

        // End EditItemActivity
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }
}
