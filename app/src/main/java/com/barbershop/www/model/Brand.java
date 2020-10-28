package com.barbershop.www.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Brand implements Parcelable {
    private String name;
    private int image;
    private String desc;
    private int type; // 수성=0, 유성=1
    private List<Item> itemList;

    public Brand(String name, int image, String desc, int type, List<Item> itemList) {
        this.name = name;
        this.image = image;
        this.desc = desc;
        this.type = type;
        this.itemList = itemList;
    }

    protected Brand(Parcel in) {
        name = in.readString();
        image = in.readInt();
        desc = in.readString();
        type = in.readInt();
    }

    public static final Creator<Brand> CREATOR = new Creator<Brand>() {
        @Override
        public Brand createFromParcel(Parcel in) {
            return new Brand(in);
        }

        @Override
        public Brand[] newArray(int size) {
            return new Brand[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getDesc() {
        return desc;
    }

    public int getType() {
        return type;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(image);
        parcel.writeString(desc);
        parcel.writeInt(type);
    }
}
