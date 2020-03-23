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
import java.util.Collections;
import java.util.Comparator;
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
        } else if (str.contains("india")) {
            flagImageView.setImageResource(R.drawable.india);
        } else if (str.contains("ecuador")) {
            flagImageView.setImageResource(R.drawable.ecuador);
        } else if (str.contains("iraq")) {
            flagImageView.setImageResource(R.drawable.iraq);
        } else if (str.contains("kuwait")) {
            flagImageView.setImageResource(R.drawable.kuwait);
        } else if (str.contains("russia")) {
            flagImageView.setImageResource(R.drawable.russia);
        } else if (str.contains("peru")) {
            flagImageView.setImageResource(R.drawable.peru);
        } else if (str.contains("san marino")) {
            flagImageView.setImageResource(R.drawable.san);
        } else if (str.contains("lebanon")) {
            flagImageView.setImageResource(R.drawable.lebanon);
        } else if (str.contains("mexico")) {
            flagImageView.setImageResource(R.drawable.mexico);
        } else if (str.contains("south africa")) {
            flagImageView.setImageResource(R.drawable.south_africa);
        } else if (str.contains("armenia")) {
            flagImageView.setImageResource(R.drawable.armenia);
        } else if (str.contains("panama")) {
            flagImageView.setImageResource(R.drawable.panama);
        } else if (str.contains("taiwan")) {
            flagImageView.setImageResource(R.drawable.taiwan);
        } else if (str.contains("slovakia")) {
            flagImageView.setImageResource(R.drawable.slovakia);
        } else if (str.contains("colombia")) {
            flagImageView.setImageResource(R.drawable.colombia);
        } else if (str.contains("croatia")) {
            flagImageView.setImageResource(R.drawable.croatia);
        } else if (str.contains("argentina")) {
            flagImageView.setImageResource(R.drawable.argentina);
        } else if (str.contains("serbia")) {
            flagImageView.setImageResource(R.drawable.serbia);
        } else if (str.contains("bulgaria")) {
            flagImageView.setImageResource(R.drawable.bulgaria);
        } else if (str.contains("latvia")) {
            flagImageView.setImageResource(R.drawable.latvia);
        } else if (str.contains("uruguay")) {
            flagImageView.setImageResource(R.drawable.uruguay);
        } else if (str.contains("vietnam")) {
            flagImageView.setImageResource(R.drawable.vietnam);
        } else if (str.contains("algeria")) {
            flagImageView.setImageResource(R.drawable.algeria);
        } else if (str.contains("hungary")) {
            flagImageView.setImageResource(R.drawable.hungary);
        } else if (str.contains("costa rica")) {
            flagImageView.setImageResource(R.drawable.costa);
        } else if (str.contains("brunei")) {
            flagImageView.setImageResource(R.drawable.brunei);
        } else if (str.contains("albania")) {
            flagImageView.setImageResource(R.drawable.albania);
        } else if (str.contains("cyprus")) {
            flagImageView.setImageResource(R.drawable.cyprus);
        } else if (str.contains("jordan")) {
            flagImageView.setImageResource(R.drawable.jordan);
        } else if (str.contains("morocco")) {
            flagImageView.setImageResource(R.drawable.morocco);
        } else if (str.contains("andorra")) {
            flagImageView.setImageResource(R.drawable.andorra);
        } else if (str.contains("sri lanka")) {
            flagImageView.setImageResource(R.drawable.sri);
        } else if (str.contains("belarus")) {
            flagImageView.setImageResource(R.drawable.belarus);
        } else if (str.contains("malta")) {
            flagImageView.setImageResource(R.drawable.malta);
        } else if (str.contains("kazakhstan")) {
            flagImageView.setImageResource(R.drawable.kazakhstan);
        } else if (str.contains("palestine")) {
            flagImageView.setImageResource(R.drawable.palestine);
        } else if (str.contains("north macedonia")) {
            flagImageView.setImageResource(R.drawable.macedonia);
        } else if (str.contains("georgia")) {
            flagImageView.setImageResource(R.drawable.georgia);
        } else if (str.contains("oman")) {
            flagImageView.setImageResource(R.drawable.oman);
        } else if (str.contains("bosnia")) {
            flagImageView.setImageResource(R.drawable.bosnia);
        } else if (str.contains("cambodia")) {
            flagImageView.setImageResource(R.drawable.cambodia);
        } else if (str.contains("moldova")) {
            flagImageView.setImageResource(R.drawable.moldova);
        } else if (str.contains("senegal")) {
            flagImageView.setImageResource(R.drawable.senegal);
        } else if (str.contains("venezuela")) {
            flagImageView.setImageResource(R.drawable.venezuela);
        } else if (str.contains("dominican")) {
            flagImageView.setImageResource(R.drawable.dominican);
        } else if (str.contains("azerbaijan")) {
            flagImageView.setImageResource(R.drawable.azerbaijan);
        } else if (str.contains("lithuania")) {
            flagImageView.setImageResource(R.drawable.lithuania);
        } else if (str.contains("guadeloupe")) {
            flagImageView.setImageResource(R.drawable.guadeloupe);
        } else if (str.contains("tunisia")) {
            flagImageView.setImageResource(R.drawable.tunisia);
        } else if (str.contains("new zeland")) {
            flagImageView.setImageResource(R.drawable.new_zealand);
        } else if (str.contains("liechtenstein")) {
            flagImageView.setImageResource(R.drawable.liechtenstein);
        } else if (str.contains("burkina faso")) {
            flagImageView.setImageResource(R.drawable.burkina);
        } else if (str.contains("martinique")) {
            flagImageView.setImageResource(R.drawable.martinique);
        } else if (str.contains("uzbekistan")) {
            flagImageView.setImageResource(R.drawable.uzbekistan);
        } else if (str.contains("afghanistan")) {
            flagImageView.setImageResource(R.drawable.afghanistan);
        } else if (str.contains("bangladesh")) {
            flagImageView.setImageResource(R.drawable.bangladesh);
        } else if (str.contains("macao")) {
            flagImageView.setImageResource(R.drawable.macao);
        } else if (str.contains("ukraine")) {
            flagImageView.setImageResource(R.drawable.ukraine);
        } else if (str.contains("jamaica")) {
            flagImageView.setImageResource(R.drawable.jamaica);
        } else if (str.contains("reunion")) {
            flagImageView.setImageResource(R.drawable.reunion);
        } else if (str.contains("cameroon")) {
            flagImageView.setImageResource(R.drawable.cameroon);
        } else if (str.contains("maldives")) {
            flagImageView.setImageResource(R.drawable.maldives);
        } else if (str.contains("bolivia")) {
            flagImageView.setImageResource(R.drawable.bolivia);
        } else if (str.contains("honduras")) {
            flagImageView.setImageResource(R.drawable.honduras);
        } else if (str.contains("cuba")) {
            flagImageView.setImageResource(R.drawable.cuba);
        } else if (str.contains("rwanda")) {
            flagImageView.setImageResource(R.drawable.rwanda);
        } else if (str.contains("monaco")) {
            flagImageView.setImageResource(R.drawable.monaco);
        } else if (str.contains("ivory coast")) {
            flagImageView.setImageResource(R.drawable.ivory_coast);
        } else if (str.contains("guatemala")) {
            flagImageView.setImageResource(R.drawable.guatemala);
        } else if (str.contains("gibraltar")) {
            flagImageView.setImageResource(R.drawable.gibraltar);
        } else if (str.contains("montenegro")) {
            flagImageView.setImageResource(R.drawable.montenegro);
        } else if (str.contains("ghana")) {
            flagImageView.setImageResource(R.drawable.ghana);
        } else if (str.contains("kenya")) {
            flagImageView.setImageResource(R.drawable.kenya);
        } else if (str.contains("ethiopia")) {
            flagImageView.setImageResource(R.drawable.ethiopia);
        } else if (str.contains("mongolia")) {
            flagImageView.setImageResource(R.drawable.mongolia);
        } else if (str.contains("puerto rico")) {
            flagImageView.setImageResource(R.drawable.puerto_rico);
        } else if (str.contains("seychelles")) {
            flagImageView.setImageResource(R.drawable.seychelles);
        } else if (str.contains("guyana")) {
            flagImageView.setImageResource(R.drawable.guyana);
        } else if (str.contains("equatorial")) {
            flagImageView.setImageResource(R.drawable.equatorial);
        } else if (str.contains("gabon")) {
            flagImageView.setImageResource(R.drawable.gabon);
        } else if (str.contains("kyrgyzstan")) {
            flagImageView.setImageResource(R.drawable.kyrgyzstan);
        } else if (str.contains("mauritius")) {
            flagImageView.setImageResource(R.drawable.mauritius);
        } else if (str.contains("tanzania")) {
            flagImageView.setImageResource(R.drawable.tanzania);
        } else if (str.contains("sudan")) {
            flagImageView.setImageResource(R.drawable.sudan);
        } else if (str.contains("barbados")) {
            flagImageView.setImageResource(R.drawable.barbados);
        } else if (str.contains("benin")) {
            flagImageView.setImageResource(R.drawable.benin);
        } else if (str.contains("greenland")) {
            flagImageView.setImageResource(R.drawable.greenland);
        } else if (str.contains("liberia")) {
            flagImageView.setImageResource(R.drawable.liberia);
        } else if (str.contains("mauritania")) {
            flagImageView.setImageResource(R.drawable.mauritania);
        } else if (str.contains("new caledonia")) {
            flagImageView.setImageResource(R.drawable.new_caledonia);
        } else if (str.contains("saint lucia")) {
            flagImageView.setImageResource(R.drawable.saint_lucia);
        } else if (str.contains("u.s. virgin islands")) {
            flagImageView.setImageResource(R.drawable.virgin);
        } else if (str.contains("zambia")) {
            flagImageView.setImageResource(R.drawable.zambia);
        } else if (str.contains("nepal")) {
            flagImageView.setImageResource(R.drawable.nepal);
        } else if (str.contains("antigua and barbuda")) {
            flagImageView.setImageResource(R.drawable.barbuda);
        } else if (str.contains("bahamas")) {
            flagImageView.setImageResource(R.drawable.bahamas);
        } else if (str.contains("bhutan")) {
            flagImageView.setImageResource(R.drawable.bhutan);
        } else if (str.contains("congo")) {
            flagImageView.setImageResource(R.drawable.congo);
        } else if (str.contains("djibouti")) {
            flagImageView.setImageResource(R.drawable.djibouti);
        } else if (str.contains("gambia")) {
            flagImageView.setImageResource(R.drawable.gambia);
        } else if (str.contains("guinea")) {
            flagImageView.setImageResource(R.drawable.guinea);
        } else if (str.contains("vatican")) {
            flagImageView.setImageResource(R.drawable.vatican);
        } else if (str.contains("somalia")) {
            flagImageView.setImageResource(R.drawable.somalia);
        } else if (str.contains("suriname")) {
            flagImageView.setImageResource(R.drawable.suriname);
        } else if (str.contains("togo")) {
            flagImageView.setImageResource(R.drawable.togo);
        } else if (str.contains("uae")) {
            flagImageView.setImageResource(R.drawable.uae);
        } else if (str.contains("fiji")) {
            flagImageView.setImageResource(R.drawable.fiji);
        } else if (str.contains("nicaragua")) {
            flagImageView.setImageResource(R.drawable.nicaragua);
        } else if (str.contains("salvador")) {
            flagImageView.setImageResource(R.drawable.salvador);
        } else if (str.contains("namibia")) {
            flagImageView.setImageResource(R.drawable.namibia);
        } else if (str.contains("french polynesia")) {
            flagImageView.setImageResource(R.drawable.french_polynesia);
        } else if (str.contains("trinidad")) {
            flagImageView.setImageResource(R.drawable.trinidad);
        } else if (str.contains("nigeria")) {
            flagImageView.setImageResource(R.drawable.nigeria);
        } else if (str.contains("paraguay")) {
            flagImageView.setImageResource(R.drawable.paraguay);
        } else if (str.contains("new zealand")) {
            flagImageView.setImageResource(R.drawable.new_zealand);
        } else if (str.contains("french guiana")) {
            flagImageView.setImageResource(R.drawable.french_guiana);
        } else if (str.contains("drc")) {
            flagImageView.setImageResource(R.drawable.congo);
        } else if (str.contains("réunion")) {
            flagImageView.setImageResource(R.drawable.reunion);
        } else if (str.contains("guam")) {
            flagImageView.setImageResource(R.drawable.guam);
        }  else if (str.contains("channel islands")) {
            flagImageView.setImageResource(R.drawable.channel);
        }  else if (str.contains("aruba")) {
            flagImageView.setImageResource(R.drawable.aruba);
        }  else if (str.contains("cura")) {
            flagImageView.setImageResource(R.drawable.curacao);
        }  else if (str.contains("faeroe islands")) {
            flagImageView.setImageResource(R.drawable.faeroe_islands);
        }  else if (str.contains("mayotte")) {
            flagImageView.setImageResource(R.drawable.mayotte);
        }  else if (str.contains("st. barth")) {
            flagImageView.setImageResource(R.drawable.barth);
        }  else if (str.contains("saint martin")) {
            flagImageView.setImageResource(R.drawable.saint_martin);
        }  else if (str.contains("bermuda")) {
            flagImageView.setImageResource(R.drawable.bermuda);
        }  else if (str.contains("cayman islands")) {
            flagImageView.setImageResource(R.drawable.cayman_islands);
        }  else if (str.contains("montserrat")) {
            flagImageView.setImageResource(R.drawable.montserrat);
        }  else if (str.contains("grenadines")) {
            flagImageView.setImageResource(R.drawable.grenadines);
        }  else if (str.contains("sint maarten")) {
            flagImageView.setImageResource(R.drawable.sint_maarten);
        }  else if (str.contains("eswatini")) {
            flagImageView.setImageResource(R.drawable.eswatini);
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

                    if (constraint.toString() == "Sort by Cases") {
                        List<CountriesStat> results = new ArrayList<CountriesStat>(values);

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
                        List<CountriesStat> results = new ArrayList<CountriesStat>(values);

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
                        List<CountriesStat> results = getFilteredResults(constraint);
                        filteredResults.count = results.size();
                        filteredResults.values = results;
                    }
                }

                return filteredResults;
            }
        };
    }



    private List<CountriesStat> getFilteredResults(final CharSequence constraint) {
        return values.stream().filter(p -> p.getCountryName().toLowerCase().startsWith(constraint.toString().toLowerCase())).collect(Collectors.toList());
    }
}
