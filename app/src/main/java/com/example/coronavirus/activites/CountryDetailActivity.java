package com.example.coronavirus.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coronavirus.R;
import com.example.coronavirus.models.CountryModelList;

public class CountryDetailActivity extends AppCompatActivity {

    private TextView mHeaderText;
    private TextView mCasesText;
    private TextView mDeathsText;
    private TextView mRecovered;
    private TextView mNewDeathsText;
    private TextView mNewCasesText;
    private TextView mSeriousText;
    private TextView mTotal;
    private ImageView mFlagImage;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        mHeaderText = (TextView) findViewById(R.id.headerText);
        mCasesText = (TextView) findViewById(R.id.casesText);
        mDeathsText = (TextView) findViewById(R.id.deathsText);
        mRecovered = (TextView) findViewById(R.id.totalRecoveredText);
        mNewDeathsText = (TextView) findViewById(R.id.newDeathsText);
        mNewCasesText = (TextView) findViewById(R.id.newCasesText);
        mSeriousText = (TextView) findViewById(R.id.seriousText);
        mTotal = (TextView) findViewById(R.id.activeCasesText);
        mFlagImage = (ImageView) findViewById(R.id.flagImage);
        mBackButton = (Button) findViewById(R.id.backButton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountryDetailActivity.this.finish();
            }
        });

        CountryModelList country = (CountryModelList) getIntent().getSerializableExtra("Country");

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Corona VIRUS");
        mToolbar.setSubtitle(country.getCountryName().toUpperCase());

        mHeaderText.setText(country.getCountryName() + " details");
        mCasesText.setText(country.getCases());
        mDeathsText.setText(country.getDeaths());
        mRecovered.setText(country.getTotalRecovered());
        mNewDeathsText.setText(country.getNewDeaths());
        mNewCasesText.setText(country.getNewCases());
        mSeriousText.setText(country.getSeriousCritical());
        mTotal.setText(country.getTotalCasesPer1mPopulation());
        mFlagImage.setImageResource(country.getFlagResourceId());
    }
}
