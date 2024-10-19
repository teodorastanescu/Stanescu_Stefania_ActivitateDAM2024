package com.example.seminar4;

public class Terasă {

    private String denumire;
    private int capacitate;
    private float rating;
    private String program;

    private boolean status;

    public Terasă(String denumire, int capacitate, float rating, String program, boolean status) {
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
        this.status=true;
    }

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

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
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

