package com.example.seminar4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class TerasaAdapter extends BaseAdapter {

    private List<Terasă> listaTerase = null;
    private Context ctx;
    private int resursaLayout;

    public TerasaAdapter(List<Terasă> apartamentList, Context ctx, int resursaLayout) {
        this.listaTerase = apartamentList;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return listaTerase.size();
    }

    @Override
    public Object getItem(int i) {
        return listaTerase.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout,parent,false);
        TextView etDenumire= v.findViewById(R.id.editTextText);
        TextView etCapacitate= v.findViewById(R.id.editTextText2);
        TextView etRating= v.findViewById(R.id.ratingBar);
        TextView etSpinner= v.findViewById(R.id.spinner);
        CheckBox cbStatus=v.findViewById(R.id.checkBox);
        Terasă terasa = (Terasă) getItem(position);

        etDenumire.setText(terasa.getDenumire());
        etCapacitate.setText(String.valueOf(terasa.getCapacitate()));
        etRating.setText(String.valueOf(terasa.getRating()));
        etSpinner.setText(terasa.getProgram());
        cbStatus.setChecked(terasa.getStatus());
        return v;
    }
}
