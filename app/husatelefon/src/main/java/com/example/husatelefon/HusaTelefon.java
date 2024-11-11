package com.example.husatelefon;

import android.os.Parcel;
import android.os.Parcelable;

public class HusaTelefon implements Parcelable {

    private String material;
    private int lungime;
    private String model;

    public HusaTelefon(String material, int lungime, String model) {
        this.material = material;
        this.lungime = lungime;
        this.model = model;
    }

    public HusaTelefon() {
        this.material = "";
        this.lungime = 0;
        this.model = "";
    }

    protected HusaTelefon(Parcel in) {
        material = in.readString();
        lungime = in.readInt();
        model = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(material);
        dest.writeInt(lungime);
        dest.writeString(model);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HusaTelefon> CREATOR = new Creator<HusaTelefon>() {
        @Override
        public HusaTelefon createFromParcel(Parcel in) {
            return new HusaTelefon(in);
        }

        @Override
        public HusaTelefon[] newArray(int size) {
            return new HusaTelefon[size];
        }
    };

    public String getMaterial() {
        return material;
    }

    public String getModel() {
        return model;
    }

    public int getLungime() {
        return lungime;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HusaTelefon{");
        sb.append("material='").append(material).append('\'');
        sb.append(", lungime=").append(lungime);
        sb.append(", model='").append(model).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
