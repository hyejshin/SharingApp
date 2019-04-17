package com.example.shins.sharingapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemDialogFragment extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_add_item, null))
                // Add action buttons
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Dialog dialogObj = Dialog.class.cast(dialog);

                        EditText titleEditText = dialogObj.findViewById(R.id.title);
                        EditText makerEditText = dialogObj.findViewById(R.id.title);
                        EditText descriptionEditText = dialogObj.findViewById(R.id.title);

                        String title = titleEditText.getText().toString();
                        String maker = makerEditText.getText().toString();
                        String description = descriptionEditText.getText().toString();

                        Toast.makeText(getActivity(), title + " Item is added", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddItemDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

}
