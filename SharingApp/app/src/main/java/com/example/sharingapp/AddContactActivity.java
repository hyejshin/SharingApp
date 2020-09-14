package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private int REQUEST_CODE = 1;

    private ContactList contact_list = new ContactList();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        context = getApplicationContext();
        contact_list.loadContacts(context);
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

        Contact contact = new Contact(username_str, email_str, null);

        AddContactCommand addContactCommand = new AddContactCommand(contact_list, contact, context);
        addContactCommand.execute();
        if(!addContactCommand.isExecuted()) {
            return;
        }

        // End AddItemActivity
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

}