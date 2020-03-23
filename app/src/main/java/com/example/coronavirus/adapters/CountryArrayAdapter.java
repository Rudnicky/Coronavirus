package com.example.coronavirus.adapters;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.coronavirus.R;
import com.example.coronavirus.components.flagcomponent.DaggerFlagComponent;
import com.example.coronavirus.models.CountryModelList;
import com.example.coronavirus.components.flagcomponent.FlagComponent;
import com.example.coronavirus.components.flagcomponent.FlagManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountryArrayAdapter extends BaseAdapter implements Filterable {

    private FlagManager mFlagManager;
    private final Context context;
    private List<CountryModelList> values;
    private List<CountryModelList> filteredValues;

    public CountryArrayAdapter(@NonNull Context context, List<CountryModelList> values) {
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

        FlagComponent component = DaggerFlagComponent.create();
        mFlagManager = component.getFlagManager();
        int flagId = mFlagManager.getFlagResource(filteredValues.get(position));
        filteredValues.get(position).setFlagResourceId(flagId);
        flagImageView.setImageResource(flagId);

        return rowView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                filteredValues = (List<CountryModelList>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filteredResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filteredResults.count = values.size();
                    filteredResults.values = values;
                } else {

                    if (constraint.toString() == "Sort by Cases") {
                        List<CountryModelList> results = new ArrayList<CountryModelList>(values);

                        results.forEach((countryCase) -> {
                            String cc = countryCase.getCases();
                            String ccWithoutComma = cc.replaceAll(",","");
                            Integer parsedCC = Integer.parseInt(ccWithoutComma);

                            countryCase.setParsedCases(parsedCC);
                        });

                        Collections.sort(results, Collections.reverseOrder());

                        filteredResults.count = results.size();
                        filteredResults.values = results;

                    } else if (constraint.toString() == "Sort by Deaths") {
                        List<CountryModelList> results = new ArrayList<CountryModelList>(values);

                        results.forEach((countryCase) -> {
                            String cc = countryCase.getDeaths();
                            String ccWithoutComma = cc.replaceAll(",","");
                            Integer parsedCC = Integer.parseInt(ccWithoutComma);

                            countryCase.setParsedDeaths(parsedCC);
                        });

                        Collections.sort(results, Collections.reverseOrder((o1, o2) -> o1.getParsedDeaths().compareTo(o2.getParsedDeaths())));

                        filteredResults.count = results.size();
                        filteredResults.values = results;
                    } else {
                        List<CountryModelList> results = getFilteredResults(constraint);
                        filteredResults.count = results.size();
                        filteredResults.values = results;
                    }
                }

                return filteredResults;
            }
        };
    }



    private List<CountryModelList> getFilteredResults(final CharSequence constraint) {
        return values.stream().filter(p -> p.getCountryName().toLowerCase().startsWith(constraint.toString().toLowerCase())).collect(Collectors.toList());
    }
}
