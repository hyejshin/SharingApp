package com.example.shins.sharingapp;

import java.util.ArrayList;

public class ItemList {

    private ArrayList<Item> mItemList = new ArrayList<>();

    public ItemList() {
    }

    public void addItemList(Item item) {
        mItemList.add(item);
    }

    public void deleteItemList(int position) {
        mItemList.remove(position);
    }

    public ArrayList<Item> getItemList() {
        return mItemList;
    }
}
