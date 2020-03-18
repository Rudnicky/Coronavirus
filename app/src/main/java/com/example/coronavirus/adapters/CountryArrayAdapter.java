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

        TextView countryTextView = (TextView) rowView.findViewById(R.id.countryTextView);
        TextView casesTextView = (TextView) rowView.findViewById(R.id.casesTextView);
        TextView deathTextView = (TextView) rowView.findViewById(R.id.deathTextView);

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                100,
                1.0f
        );

        countryTextView.setLayoutParams(param);
        casesTextView.setLayoutParams(param);
        deathTextView.setLayoutParams(param);

        countryTextView.setGravity(Gravity.CENTER_VERTICAL);
        casesTextView.setGravity(Gravity.CENTER_VERTICAL);
        deathTextView.setGravity(Gravity.CENTER_VERTICAL);

        countryTextView.setText(filteredValues.get(position).getCountryName());
        casesTextView.setText(filteredValues.get(position).getCases());
        deathTextView.setText(filteredValues.get(position).getDeaths());

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
        return values.stream().filter(p -> p.getCountryName().startsWith(constraint.toString())).collect(Collectors.toList());
    }
}
