package com.example.shins.sharingapp;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class AllItemsFragment extends Fragment {

    private Button btnAdd;
    static final String[] ITEMS = {"DOG", "BOY", "JELLY", "PINK", "SCUBADIVING"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.all_items_fragment, container, false);
        btnAdd = view.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  DialogFragment dialog = new AddItemDialogFragment();
                  dialog.show(getFragmentManager(), "dialog");
              }
          }
        );

        ItemList itemList = new ItemList();
        ArrayList<Item> items = itemList.getItemList();
        items.add(new Item(R.drawable.pinkdog, "DOG", "PINK", "PINK DOGGIE"));

        ItemAdapter adapter = new ItemAdapter(getActivity(), R.layout.list_view_item, items);

       // ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, ITEMS);

        ListView listView = view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        return view;
    }
}
