package com.barbershop.www.model;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Style implements Parcelable {
    private String title;
    private String description;
    private List<Integer> beardList;
    private int drawableId;

    public Style(String title, String description, int drawableId, List<Integer> beardList) {
        this.title = title;
        this.description = description;
        this.beardList = beardList;
        this.drawableId = drawableId;
    }

    protected Style(Parcel in) {
        title = in.readString();
        description = in.readString();
        drawableId = in.readInt();
    }

    public static final Creator<Style> CREATOR = new Creator<Style>() {
        @Override
        public Style createFromParcel(Parcel in) {
            return new Style(in);
        }

        @Override
        public Style[] newArray(int size) {
            return new Style[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Integer> getBeardList() {
        return beardList;
    }

    public int getDrawableId() {
        return drawableId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(drawableId);
    }
}
