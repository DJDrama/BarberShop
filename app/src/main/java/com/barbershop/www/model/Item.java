package com.barbershop.www.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private String name;
    private int image;
    private String desc;

    private int setting;
    private int gojung;
    private int balim;
    private int shining;

    public Item(String name, int image, String desc, int setting, int gojung, int balim, int shining) {
        this.name = name;
        this.image = image;
        this.desc = desc;
        this.setting = setting;
        this.gojung = gojung;
        this.balim = balim;
        this.shining = shining;
    }

    protected Item(Parcel in) {
        name = in.readString();
        image = in.readInt();
        desc = in.readString();
        setting = in.readInt();
        gojung = in.readInt();
        balim = in.readInt();
        shining = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
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

    public int getSetting() {
        return setting;
    }

    public int getGojung() {
        return gojung;
    }

    public int getBalim() {
        return balim;
    }

    public int getShining() {
        return shining;
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
        parcel.writeInt(setting);
        parcel.writeInt(gojung);
        parcel.writeInt(balim);
        parcel.writeInt(shining);
    }
}
