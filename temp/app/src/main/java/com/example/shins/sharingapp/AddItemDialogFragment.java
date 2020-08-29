package com.example.shins.sharingapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
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
                        EditText makerEditText = dialogObj.findViewById(R.id.maker);
                        EditText descriptionEditText = dialogObj.findViewById(R.id.description);
                        EditText lengthEditText = dialogObj.findViewById(R.id.length);
                        EditText widthEditText = dialogObj.findViewById(R.id.width);
                        EditText heightEditText = dialogObj.findViewById(R.id.height);

                        String title = titleEditText.getText().toString();
                        String maker = makerEditText.getText().toString();
                        String description = descriptionEditText.getText().toString();
                        Integer length = Integer.parseInt(lengthEditText.getText().toString());
                        Integer width = Integer.parseInt(widthEditText.getText().toString());
                        Integer height = Integer.parseInt(heightEditText.getText().toString());
                        Dimensions dimension = new Dimensions(length, width, height);

                        Item item = new Item(title, maker, description, dimension);

                        ItemList itemList = new ItemList();
                        itemList.addItem(item);
                        itemList.saveItems(getContext());
                        itemList.readItems(getContext());

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
