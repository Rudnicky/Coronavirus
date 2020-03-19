package com.example.coronavirus.adapters;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.coronavirus.R;
import com.example.coronavirus.models.CountriesStat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountryArrayAdapter extends BaseAdapter implements Filterable {

    private final Context context;
    private List<CountriesStat> values;
    private List<CountriesStat> filteredValues;

    public CountryArrayAdapter(@NonNull Context context, List<CountriesStat> values) {
        this.context = context;
        this.values = values;
        this.filteredValues = values;
    }

    @Override
    public int getCount() {
        return filteredValues.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredValues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converterView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_country_list_item, parent, false);

        ImageView flagImageView = (ImageView) rowView.findViewById(R.id.flagImageView);
        TextView countryTextView = (TextView) rowView.findViewById(R.id.countryTextView);
        TextView casesTextView = (TextView) rowView.findViewById(R.id.casesTextView);
        TextView deathTextView = (TextView) rowView.findViewById(R.id.deathTextView);

        countryTextView.setGravity(Gravity.CENTER_VERTICAL);
        casesTextView.setGravity(Gravity.CENTER_VERTICAL);
        deathTextView.setGravity(Gravity.CENTER_VERTICAL);

        countryTextView.setText(filteredValues.get(position).getCountryName());
        casesTextView.setText(filteredValues.get(position).getCases());
        deathTextView.setText(filteredValues.get(position).getDeaths());

        String str = filteredValues.get(position).getCountryName().trim().toLowerCase();
        if (str.contains("poland")) {
            flagImageView.setImageResource(R.drawable.poland);
        } else if (str.contains("china")) {
            flagImageView.setImageResource(R.drawable.china);
        } else if (str.contains("italy")) {
            flagImageView.setImageResource(R.drawable.italy);
        } else if (str.contains("spain")) {
            flagImageView.setImageResource(R.drawable.spain);
        } else if (str.contains("iran")) {
            flagImageView.setImageResource(R.drawable.iran);
        } else if (str.contains("germany")) {
            flagImageView.setImageResource(R.drawable.germany);
        } else if (str.contains("usa")) {
            flagImageView.setImageResource(R.drawable.usa);
        } else if (str.contains("france")) {
            flagImageView.setImageResource(R.drawable.france);
        } else if (str.contains("s. korea")) {
            flagImageView.setImageResource(R.drawable.s_korea);
        } else if (str.contains("switzerland")) {
            flagImageView.setImageResource(R.drawable.switzerland);
        } else if (str.contains("uk")) {
            flagImageView.setImageResource(R.drawable.uk);
        } else if (str.contains("netherlands")) {
            flagImageView.setImageResource(R.drawable.netherlands);
        } else if (str.contains("austria")) {
            flagImageView.setImageResource(R.drawable.austria);
        } else if (str.contains("norway")) {
            flagImageView.setImageResource(R.drawable.norway);
        } else if (str.contains("belgium")) {
            flagImageView.setImageResource(R.drawable.belgium);
        } else if (str.contains("sweden")) {
            flagImageView.setImageResource(R.drawable.sweden);
        } else if (str.contains("denmark")) {
            flagImageView.setImageResource(R.drawable.denmark);
        } else if (str.contains("japan")) {
            flagImageView.setImageResource(R.drawable.japan);
        } else if (str.contains("malaysia")) {
            flagImageView.setImageResource(R.drawable.malaysia);
        } else if (str.contains("canada")) {
            flagImageView.setImageResource(R.drawable.canada);
        } else if (str.contains("portugal")) {
            flagImageView.setImageResource(R.drawable.portugal);
        } else if (str.contains("australia")) {
            flagImageView.setImageResource(R.drawable.australia);
        } else if (str.contains("brazil")) {
            flagImageView.setImageResource(R.drawable.brazil);
        } else if (str.contains("czechia")) {
            flagImageView.setImageResource(R.drawable.czechia);
        } else if (str.contains("qatar")) {
            flagImageView.setImageResource(R.drawable.qatar);
        } else if (str.contains("israel")) {
            flagImageView.setImageResource(R.drawable.israel);
        } else if (str.contains("greece")) {
            flagImageView.setImageResource(R.drawable.greece);
        } else if (str.contains("ireland")) {
            flagImageView.setImageResource(R.drawable.ireland);
        } else if (str.contains("finland")) {
            flagImageView.setImageResource(R.drawable.finland);
        } else if (str.contains("singapore")) {
            flagImageView.setImageResource(R.drawable.singapore);
        } else if (str.contains("pakistan")) {
            flagImageView.setImageResource(R.drawable.pakistan);
        } else if (str.contains("slovenia")) {
            flagImageView.setImageResource(R.drawable.slovenia);
        } else if (str.contains("romania")) {
            flagImageView.setImageResource(R.drawable.romania);
        } else if (str.contains("estonia")) {
            flagImageView.setImageResource(R.drawable.estonia);
        } else if (str.contains("bahrain")) {
            flagImageView.setImageResource(R.drawable.bahrain);
        } else if (str.contains("iceland")) {
            flagImageView.setImageResource(R.drawable.iceland);
        } else if (str.contains("saudi arabia")) {
            flagImageView.setImageResource(R.drawable.saudi);
        } else if (str.contains("chile")) {
            flagImageView.setImageResource(R.drawable.chile);
        } else if (str.contains("indonesia")) {
            flagImageView.setImageResource(R.drawable.indonesia);
        } else if (str.contains("thailand")) {
            flagImageView.setImageResource(R.drawable.thailand);
        } else if (str.contains("egypt")) {
            flagImageView.setImageResource(R.drawable.egypt);
        } else if (str.contains("luxembourg")) {
            flagImageView.setImageResource(R.drawable.luxembourg);
        } else if (str.contains("philippines")) {
            flagImageView.setImageResource(R.drawable.philippines);
        } else if (str.contains("hong kong")) {
            flagImageView.setImageResource(R.drawable.hong);
        } else if (str.contains("turkey")) {
            flagImageView.setImageResource(R.drawable.turkey);
        }

        return rowView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                filteredValues = (List<CountriesStat>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filteredResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filteredResults.count = values.size();
                    filteredResults.values = values;
                } else {
                    List<CountriesStat> results = getFilteredResults(constraint);
                    filteredResults.count = results.size();
                    filteredResults.values = results;
                }

                return filteredResults;
            }
        };
    }

    private List<CountriesStat> getFilteredResults(final CharSequence constraint) {
        return values.stream().filter(p -> p.getCountryName().toLowerCase().startsWith(constraint.toString().toLowerCase())).collect(Collectors.toList());
    }
}
