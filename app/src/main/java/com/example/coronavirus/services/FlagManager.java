package com.example.coronavirus.services;

import com.example.coronavirus.R;
import com.example.coronavirus.models.CountriesStat;

import javax.inject.Inject;

public class FlagManager {

    @Inject
    public FlagManager() {}

    public int getFlagResource(CountriesStat country) {
        String str = country.getCountryName().trim().toLowerCase();

        if (str.contains("poland")) {
            return R.drawable.poland;
        } else if (str.contains("china")) {
            return R.drawable.china;
        } else if (str.contains("italy")) {
            return R.drawable.italy;
        } else if (str.contains("spain")) {
            return R.drawable.spain;
        } else if (str.contains("iran")) {
            return R.drawable.iran;
        } else if (str.contains("germany")) {
            return R.drawable.germany;
        } else if (str.contains("usa")) {
            return R.drawable.usa;
        } else if (str.contains("france")) {
            return R.drawable.france;
        } else if (str.contains("s. korea")) {
            return R.drawable.s_korea;
        } else if (str.contains("switzerland")) {
            return R.drawable.switzerland;
        } else if (str.contains("uk")) {
            return R.drawable.uk;
        } else if (str.contains("netherlands")) {
            return R.drawable.netherlands;
        } else if (str.contains("austria")) {
            return R.drawable.austria;
        } else if (str.contains("norway")) {
            return R.drawable.norway;
        } else if (str.contains("belgium")) {
            return R.drawable.belgium;
        } else if (str.contains("sweden")) {
            return R.drawable.sweden;
        } else if (str.contains("denmark")) {
            return R.drawable.denmark;
        } else if (str.contains("japan")) {
            return R.drawable.japan;
        } else if (str.contains("malaysia")) {
            return R.drawable.malaysia;
        } else if (str.contains("canada")) {
            return R.drawable.canada;
        } else if (str.contains("portugal")) {
            return R.drawable.portugal;
        } else if (str.contains("australia")) {
            return R.drawable.australia;
        } else if (str.contains("brazil")) {
            return R.drawable.brazil;
        } else if (str.contains("czechia")) {
            return R.drawable.czechia;
        } else if (str.contains("qatar")) {
            return R.drawable.qatar;
        } else if (str.contains("israel")) {
            return R.drawable.israel;
        } else if (str.contains("greece")) {
            return R.drawable.greece;
        } else if (str.contains("ireland")) {
            return R.drawable.ireland;
        } else if (str.contains("finland")) {
            return R.drawable.finland;
        } else if (str.contains("singapore")) {
            return R.drawable.singapore;
        } else if (str.contains("pakistan")) {
            return R.drawable.pakistan;
        } else if (str.contains("slovenia")) {
            return R.drawable.slovenia;
        } else if (str.contains("romania")) {
            return R.drawable.romania;
        } else if (str.contains("estonia")) {
            return R.drawable.estonia;
        } else if (str.contains("bahrain")) {
            return R.drawable.bahrain;
        } else if (str.contains("iceland")) {
            return R.drawable.iceland;
        } else if (str.contains("saudi arabia")) {
            return R.drawable.saudi;
        } else if (str.contains("chile")) {
            return R.drawable.chile;
        } else if (str.contains("indonesia")) {
            return R.drawable.indonesia;
        } else if (str.contains("thailand")) {
            return R.drawable.thailand;
        } else if (str.contains("egypt")) {
            return R.drawable.egypt;
        } else if (str.contains("luxembourg")) {
            return R.drawable.luxembourg;
        } else if (str.contains("philippines")) {
            return R.drawable.philippines;
        } else if (str.contains("hong kong")) {
            return R.drawable.hong;
        } else if (str.contains("turkey")) {
            return R.drawable.turkey;
        } else if (str.contains("india")) {
            return R.drawable.india;
        } else if (str.contains("ecuador")) {
            return R.drawable.ecuador;
        } else if (str.contains("iraq")) {
            return R.drawable.iraq;
        } else if (str.contains("kuwait")) {
            return R.drawable.kuwait;
        } else if (str.contains("russia")) {
            return R.drawable.russia;
        } else if (str.contains("peru")) {
            return R.drawable.peru;
        } else if (str.contains("san marino")) {
            return R.drawable.san;
        } else if (str.contains("lebanon")) {
            return R.drawable.lebanon;
        } else if (str.contains("mexico")) {
            return R.drawable.mexico;
        } else if (str.contains("south africa")) {
            return R.drawable.south_africa;
        } else if (str.contains("armenia")) {
            return R.drawable.armenia;
        } else if (str.contains("panama")) {
            return R.drawable.panama;
        } else if (str.contains("taiwan")) {
            return R.drawable.taiwan;
        } else if (str.contains("slovakia")) {
            return R.drawable.slovakia;
        } else if (str.contains("colombia")) {
            return R.drawable.colombia;
        } else if (str.contains("croatia")) {
            return R.drawable.croatia;
        } else if (str.contains("argentina")) {
            return R.drawable.argentina;
        } else if (str.contains("serbia")) {
            return R.drawable.serbia;
        } else if (str.contains("bulgaria")) {
            return R.drawable.bulgaria;
        } else if (str.contains("latvia")) {
            return R.drawable.latvia;
        } else if (str.contains("uruguay")) {
            return R.drawable.uruguay;
        } else if (str.contains("vietnam")) {
            return R.drawable.vietnam;
        } else if (str.contains("algeria")) {
            return R.drawable.algeria;
        } else if (str.contains("hungary")) {
            return R.drawable.hungary;
        } else if (str.contains("costa rica")) {
            return R.drawable.costa;
        } else if (str.contains("brunei")) {
            return R.drawable.brunei;
        } else if (str.contains("albania")) {
            return R.drawable.albania;
        } else if (str.contains("cyprus")) {
            return R.drawable.cyprus;
        } else if (str.contains("jordan")) {
            return R.drawable.jordan;
        } else if (str.contains("morocco")) {
            return R.drawable.morocco;
        } else if (str.contains("andorra")) {
            return R.drawable.andorra;
        } else if (str.contains("sri lanka")) {
            return R.drawable.sri;
        } else if (str.contains("belarus")) {
            return R.drawable.belarus;
        } else if (str.contains("malta")) {
            return R.drawable.malta;
        } else if (str.contains("kazakhstan")) {
            return R.drawable.kazakhstan;
        } else if (str.contains("palestine")) {
            return R.drawable.palestine;
        } else if (str.contains("north macedonia")) {
            return R.drawable.macedonia;
        } else if (str.contains("georgia")) {
            return R.drawable.georgia;
        } else if (str.contains("oman")) {
            return R.drawable.oman;
        } else if (str.contains("bosnia")) {
            return R.drawable.bosnia;
        } else if (str.contains("cambodia")) {
            return R.drawable.cambodia;
        } else if (str.contains("moldova")) {
            return R.drawable.moldova;
        } else if (str.contains("senegal")) {
            return R.drawable.senegal;
        } else if (str.contains("venezuela")) {
            return R.drawable.venezuela;
        } else if (str.contains("dominican")) {
            return R.drawable.dominican;
        } else if (str.contains("azerbaijan")) {
            return R.drawable.azerbaijan;
        } else if (str.contains("lithuania")) {
            return R.drawable.lithuania;
        } else if (str.contains("guadeloupe")) {
            return R.drawable.guadeloupe;
        } else if (str.contains("tunisia")) {
            return R.drawable.tunisia;
        } else if (str.contains("new zeland")) {
            return R.drawable.new_zealand;
        } else if (str.contains("liechtenstein")) {
            return R.drawable.liechtenstein;
        } else if (str.contains("burkina faso")) {
            return R.drawable.burkina;
        } else if (str.contains("martinique")) {
            return R.drawable.martinique;
        } else if (str.contains("uzbekistan")) {
            return R.drawable.uzbekistan;
        } else if (str.contains("afghanistan")) {
            return R.drawable.afghanistan;
        } else if (str.contains("bangladesh")) {
            return R.drawable.bangladesh;
        } else if (str.contains("macao")) {
            return R.drawable.macao;
        } else if (str.contains("ukraine")) {
            return R.drawable.ukraine;
        } else if (str.contains("jamaica")) {
            return R.drawable.jamaica;
        } else if (str.contains("reunion")) {
            return R.drawable.reunion;
        } else if (str.contains("cameroon")) {
            return R.drawable.cameroon;
        } else if (str.contains("maldives")) {
            return R.drawable.maldives;
        } else if (str.contains("bolivia")) {
            return R.drawable.bolivia;
        } else if (str.contains("honduras")) {
            return R.drawable.honduras;
        } else if (str.contains("cuba")) {
            return R.drawable.cuba;
        } else if (str.contains("rwanda")) {
            return R.drawable.rwanda;
        } else if (str.contains("monaco")) {
            return R.drawable.monaco;
        } else if (str.contains("ivory coast")) {
            return R.drawable.ivory_coast;
        } else if (str.contains("guatemala")) {
            return R.drawable.guatemala;
        } else if (str.contains("gibraltar")) {
            return R.drawable.gibraltar;
        } else if (str.contains("montenegro")) {
            return R.drawable.montenegro;
        } else if (str.contains("ghana")) {
            return R.drawable.ghana;
        } else if (str.contains("kenya")) {
            return R.drawable.kenya;
        } else if (str.contains("ethiopia")) {
            return R.drawable.ethiopia;
        } else if (str.contains("mongolia")) {
            return R.drawable.mongolia;
        } else if (str.contains("puerto rico")) {
            return R.drawable.puerto_rico;
        } else if (str.contains("seychelles")) {
            return R.drawable.seychelles;
        } else if (str.contains("guyana")) {
            return R.drawable.guyana;
        } else if (str.contains("equatorial")) {
            return R.drawable.equatorial;
        } else if (str.contains("gabon")) {
            return R.drawable.gabon;
        } else if (str.contains("kyrgyzstan")) {
            return R.drawable.kyrgyzstan;
        } else if (str.contains("mauritius")) {
            return R.drawable.mauritius;
        } else if (str.contains("tanzania")) {
            return R.drawable.tanzania;
        } else if (str.contains("sudan")) {
            return R.drawable.sudan;
        } else if (str.contains("barbados")) {
            return R.drawable.barbados;
        } else if (str.contains("benin")) {
            return R.drawable.benin;
        } else if (str.contains("greenland")) {
            return R.drawable.greenland;
        } else if (str.contains("liberia")) {
            return R.drawable.liberia;
        } else if (str.contains("mauritania")) {
            return R.drawable.mauritania;
        } else if (str.contains("new caledonia")) {
            return R.drawable.new_caledonia;
        } else if (str.contains("saint lucia")) {
            return R.drawable.saint_lucia;
        } else if (str.contains("u.s. virgin islands")) {
            return R.drawable.virgin;
        } else if (str.contains("zambia")) {
            return R.drawable.zambia;
        } else if (str.contains("nepal")) {
            return R.drawable.nepal;
        } else if (str.contains("antigua and barbuda")) {
            return R.drawable.barbuda;
        } else if (str.contains("bahamas")) {
            return R.drawable.bahamas;
        } else if (str.contains("bhutan")) {
            return R.drawable.bhutan;
        } else if (str.contains("congo")) {
            return R.drawable.congo;
        } else if (str.contains("djibouti")) {
            return R.drawable.djibouti;
        } else if (str.contains("gambia")) {
            return R.drawable.gambia;
        } else if (str.contains("guinea")) {
            return R.drawable.guinea;
        } else if (str.contains("vatican")) {
            return R.drawable.vatican;
        } else if (str.contains("somalia")) {
            return R.drawable.somalia;
        } else if (str.contains("suriname")) {
            return R.drawable.suriname;
        } else if (str.contains("togo")) {
            return R.drawable.togo;
        } else if (str.contains("uae")) {
            return R.drawable.uae;
        } else if (str.contains("fiji")) {
            return R.drawable.fiji;
        } else if (str.contains("nicaragua")) {
            return R.drawable.nicaragua;
        } else if (str.contains("salvador")) {
            return R.drawable.salvador;
        } else if (str.contains("namibia")) {
            return R.drawable.namibia;
        } else if (str.contains("french polynesia")) {
            return R.drawable.french_polynesia;
        } else if (str.contains("trinidad")) {
            return R.drawable.trinidad;
        } else if (str.contains("nigeria")) {
            return R.drawable.nigeria;
        } else if (str.contains("paraguay")) {
            return R.drawable.paraguay;
        } else if (str.contains("new zealand")) {
            return R.drawable.new_zealand;
        } else if (str.contains("french guiana")) {
            return R.drawable.french_guiana;
        } else if (str.contains("drc")) {
            return R.drawable.congo;
        } else if (str.contains("réunion")) {
            return R.drawable.reunion;
        } else if (str.contains("guam")) {
            return R.drawable.guam;
        }  else if (str.contains("channel islands")) {
            return R.drawable.channel;
        }  else if (str.contains("aruba")) {
            return R.drawable.aruba;
        }  else if (str.contains("cura")) {
            return R.drawable.curacao;
        }  else if (str.contains("faeroe islands")) {
            return R.drawable.faeroe_islands;
        }  else if (str.contains("mayotte")) {
            return R.drawable.mayotte;
        }  else if (str.contains("st. barth")) {
            return R.drawable.barth;
        }  else if (str.contains("saint martin")) {
            return R.drawable.saint_martin;
        }  else if (str.contains("bermuda")) {
            return R.drawable.bermuda;
        }  else if (str.contains("cayman islands")) {
            return R.drawable.cayman_islands;
        }  else if (str.contains("montserrat")) {
            return R.drawable.montserrat;
        }  else if (str.contains("grenadines")) {
            return R.drawable.grenadines;
        }  else if (str.contains("sint maarten")) {
            return R.drawable.sint_maarten;
        }  else if (str.contains("eswatini")) {
            return R.drawable.eswatini;
        }
        return R.drawable.default_flag;
    }
}
