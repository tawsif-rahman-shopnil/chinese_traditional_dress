package com.ashikurrahman.chinesetraditionaldress;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemModel implements Parcelable {
    private String title;
    private String description;
    private int thumbnailResId;

    public ItemModel(String title, String description, int thumbnailResId) {
        this.title = title;
        this.description = description;
        this.thumbnailResId = thumbnailResId;
    }

    protected ItemModel(Parcel in) {
        title = in.readString();
        description = in.readString();
        thumbnailResId = in.readInt();
    }

    public static final Creator<ItemModel> CREATOR = new Creator<ItemModel>() {
        @Override
        public ItemModel createFromParcel(Parcel in) {
            return new ItemModel(in);
        }

        @Override
        public ItemModel[] newArray(int size) {
            return new ItemModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getThumbnailResId() {
        return thumbnailResId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(thumbnailResId);
    }
}
