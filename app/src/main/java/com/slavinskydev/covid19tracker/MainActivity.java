package com.slavinskydev.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.slavinskydev.covid19tracker.adapters.CountryAdapter;
import com.slavinskydev.covid19tracker.api.ApiFactory;
import com.slavinskydev.covid19tracker.api.ApiService;
import com.slavinskydev.covid19tracker.pojo.CountriesResponse;
import com.slavinskydev.covid19tracker.pojo.Country;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    private RecyclerView recyclerViewCountries;
    private CountryAdapter countryAdapter;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCountries = findViewById(R.id.recyclerViewCountries);
        countryAdapter = new CountryAdapter();
        countryAdapter.setCountries(new ArrayList<Country>());
        recyclerViewCountries.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCountries.setAdapter(countryAdapter);

        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        disposable = apiService.getCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CountriesResponse>() {
                    @Override
                    public void accept(CountriesResponse countriesResponse) throws Exception {
                        countryAdapter.setCountries(countriesResponse.getCountries());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.toast_back_exit), Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
