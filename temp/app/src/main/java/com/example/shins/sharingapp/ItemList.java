package com.example.shins.sharingapp;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ItemList {

    private String FILENAME = "myFile.txt";
    private ArrayList<Item> items = new ArrayList<>();

    public ItemList() {
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void deleteItemList(int position) {
        items.remove(position);
    }

    public ArrayList<Item> getItemList() {
        return items;
    }

    public void readItems(Context context) {
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            String json = sb.toString();
            Log.d("json", "item: " + json);
            Gson gson = new Gson();
            items = gson.fromJson(json, new TypeToken<ArrayList<Item>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveItems(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(items, osw);
            osw.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Item> filterItemsByStatus() {
        ArrayList<Item> selected_items = new ArrayList<>();
        for(Item i: items) {
            if(i.getStatus().equals(true)) {
                selected_items.add(i);
            }
        }
        return selected_items;
    }
}
