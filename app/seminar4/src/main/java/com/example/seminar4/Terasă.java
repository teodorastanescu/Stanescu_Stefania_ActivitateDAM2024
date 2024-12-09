package com.example.seminar4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "Terasa")
public class Terasă implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @NotNull

    private  int id;
    private String denumire;


    private int capacitate;


    private float rating;


    private String program;


    private Boolean status;

    public Terasă(String denumire, int capacitate, float rating, String program, Boolean status) {
        this.denumire = denumire;
        this.capacitate = capacitate;
        this.rating = rating;
        this.program = program;
        this.status= status;
    }

    public Terasă(){
        this.denumire=" ";
        this.capacitate=0;
        this.rating= 0.0f;
        this.program=" ";
        this.status=false;
    }

    protected Terasă(Parcel in) {
        id=in.readInt();
        denumire = in.readString();
        capacitate = in.readInt();
        rating = in.readFloat();
        program = in.readString();
        status = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(denumire);
        dest.writeInt(capacitate);
        dest.writeFloat(rating);
        dest.writeString(program);
        dest.writeByte((byte) (status ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Terasă> CREATOR = new Creator<Terasă>() {
        @Override
        public Terasă createFromParcel(Parcel in) {
            return new Terasă(in);
        }

        @Override
        public Terasă[] newArray(int size) {
            return new Terasă[size];
        }
    };

    public String getDenumire() {
        return denumire;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public float getRating() {
        return rating;
    }

    public String getProgram() {
        return program;
    }

    public Boolean getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

//    public Boolean isStatus() {
//        return status;
//    }

    public String getKey(){
        StringBuilder sb= new StringBuilder();
        sb.append(this.denumire);
        sb.append(",");
        sb.append(this.capacitate);
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Terasă{");
        sb.append("denumire='").append(denumire).append('\'');
        sb.append(", capacitate=").append(capacitate);
        sb.append(", rating=").append(rating);
        sb.append(", program='").append(program).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}

