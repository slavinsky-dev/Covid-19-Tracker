package com.slavinskydev.covid19tracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.slavinskydev.covid19tracker.R;
import com.slavinskydev.covid19tracker.pojo.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countries;
    private String date;
    private Context context;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
        notifyDataSetChanged();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_country, parent, false);
        context = parent.getContext();
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countries.get(position);
        if (country.getCountry().equals("")) {
            holder.textViewCountryName.setVisibility(View.GONE);
        } else {
            String countryName = country.getCountry().replaceFirst("^ *", "");
            holder.textViewCountryName.setText(countryName);
            holder.textViewNewConfirmed.setText(String.valueOf(country.getNewConfirmed()));
            holder.textViewTotalConfirmed.setText(String.valueOf(country.getTotalConfirmed()));
            holder.textViewNewDeaths.setText(String.valueOf(country.getNewDeaths()));
            holder.textViewTotalDeaths.setText(String.valueOf(country.getTotalDeaths()));
            holder.textViewNewRecovered.setText(String.valueOf(country.getNewRecovered()));
            holder.textViewTotalRecovered.setText(String.valueOf(country.getTotalRecovered()));

            holder.textViewNewConfirmed.setTextColor(context.getResources().getColor(R.color.textColor));
            holder.textViewNewConfirmedTitle.setTextColor(context.getResources().getColor(R.color.textColor));
            holder.textViewTotalConfirmed.setTextColor(context.getResources().getColor(R.color.textColor));
            holder.textViewTotalConfirmedTitle.setTextColor(context.getResources().getColor(R.color.textColor));
            holder.textViewNewDeaths.setTextColor(context.getResources().getColor(R.color.textColor));
            holder.textViewNewDeathsTitle.setTextColor(context.getResources().getColor(R.color.textColor));
            holder.textViewTotalDeaths.setTextColor(context.getResources().getColor(R.color.textColor));
            holder.textViewTotalDeathsTitle.setTextColor(context.getResources().getColor(R.color.textColor));

            if (country.getTotalRecovered() != 0) {
                holder.textViewTotalRecovered.setTextColor(context.getResources().getColor(R.color.textColorRecovered));
                holder.textViewTotalRecoveredTitle.setTextColor(context.getResources().getColor(R.color.textColorRecovered));
            } else {
                holder.textViewTotalRecovered.setTextColor(context.getResources().getColor(R.color.textColor));
                holder.textViewTotalRecoveredTitle.setTextColor(context.getResources().getColor(R.color.textColor));
            }
            if (country.getNewRecovered() != 0) {
                holder.textViewNewRecovered.setTextColor(context.getResources().getColor(R.color.textColorRecovered));
                holder.textViewNewRecoveredTitle.setTextColor(context.getResources().getColor(R.color.textColorRecovered));
            } else {
                holder.textViewNewRecovered.setTextColor(context.getResources().getColor(R.color.textColor));
                holder.textViewNewRecoveredTitle.setTextColor(context.getResources().getColor(R.color.textColor));
            }

            if (country.getTotalDeaths() != 0) {
                holder.textViewTotalDeaths.setTextColor(context.getResources().getColor(R.color.textColorStage5));
                holder.textViewTotalDeathsTitle.setTextColor(context.getResources().getColor(R.color.textColorStage5));
            } else {
                holder.textViewTotalDeaths.setTextColor(context.getResources().getColor(R.color.textColor));
                holder.textViewTotalDeathsTitle.setTextColor(context.getResources().getColor(R.color.textColor));
            }
            if (country.getNewDeaths() != 0) {
                holder.textViewNewDeaths.setTextColor(context.getResources().getColor(R.color.textColorStage5));
                holder.textViewNewDeathsTitle.setTextColor(context.getResources().getColor(R.color.textColorStage5));
            } else {
                holder.textViewNewDeaths.setTextColor(context.getResources().getColor(R.color.textColor));
                holder.textViewNewDeathsTitle.setTextColor(context.getResources().getColor(R.color.textColor));
            }

            if (country.getTotalConfirmed() != 0) {
                holder.textViewTotalConfirmed.setTextColor(context.getResources().getColor(R.color.textColorStage2));
                holder.textViewTotalConfirmedTitle.setTextColor(context.getResources().getColor(R.color.textColorStage2));
            } else {
                holder.textViewTotalConfirmed.setTextColor(context.getResources().getColor(R.color.textColor));
                holder.textViewTotalConfirmedTitle.setTextColor(context.getResources().getColor(R.color.textColor));
            }
            if (country.getNewConfirmed() != 0) {
                holder.textViewNewConfirmed.setTextColor(context.getResources().getColor(R.color.textColorStage2));
                holder.textViewNewConfirmedTitle.setTextColor(context.getResources().getColor(R.color.textColorStage2));
            } else {
                holder.textViewNewConfirmed.setTextColor(context.getResources().getColor(R.color.textColor));
                holder.textViewNewConfirmedTitle.setTextColor(context.getResources().getColor(R.color.textColor));
            }

            holder.textViewCountryName.setTextColor(context.getResources().getColor(R.color.textColor));
            int stage1 = 10;
            int stage2 = 100;
            int stage3 = 1000;
            int stage4 = 10000;
            int stage5 = 100000;
            int stage6 = 1000000;
            int stage7 = 10000000;
            if (0 < country.getTotalConfirmed() && country.getTotalConfirmed() < stage1) {
                holder.textViewCountryName.setTextColor(context.getResources().getColor(R.color.textColorStage1));
            } else if (stage1 < country.getTotalConfirmed() && country.getTotalConfirmed() < stage2) {
                holder.textViewCountryName.setTextColor(context.getResources().getColor(R.color.textColorStage2));
            } else if (stage2 < country.getTotalConfirmed() && country.getTotalConfirmed() < stage3) {
                holder.textViewCountryName.setTextColor(context.getResources().getColor(R.color.textColorStage3));
            } else if (stage3 < country.getTotalConfirmed() && country.getTotalConfirmed() < stage4) {
                holder.textViewCountryName.setTextColor(context.getResources().getColor(R.color.textColorStage4));
            } else if (stage4 < country.getTotalConfirmed() && country.getTotalConfirmed() < stage5) {
                holder.textViewCountryName.setTextColor(context.getResources().getColor(R.color.textColorStage5));
            } else if (stage5 < country.getTotalConfirmed() && country.getTotalConfirmed() < stage6) {
                holder.textViewCountryName.setTextColor(context.getResources().getColor(R.color.textColorStage6));
            } else if (stage6 < country.getTotalConfirmed() && country.getTotalConfirmed() < stage7) {
                holder.textViewCountryName.setTextColor(context.getResources().getColor(R.color.textColorStage7));
            }
        }
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewCountryName;
        private TextView textViewNewConfirmed;
        private TextView textViewNewConfirmedTitle;
        private TextView textViewTotalConfirmed;
        private TextView textViewTotalConfirmedTitle;
        private TextView textViewNewDeaths;
        private TextView textViewNewDeathsTitle;
        private TextView textViewTotalDeaths;
        private TextView textViewTotalDeathsTitle;
        private TextView textViewNewRecovered;
        private TextView textViewNewRecoveredTitle;
        private TextView textViewTotalRecovered;
        private TextView textViewTotalRecoveredTitle;

        CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCountryName = itemView.findViewById(R.id.textViewCountryName);
            textViewNewConfirmed = itemView.findViewById(R.id.textViewNewConfirmed);
            textViewNewConfirmedTitle = itemView.findViewById(R.id.textViewNewConfirmedTitle);
            textViewTotalConfirmed = itemView.findViewById(R.id.textViewTotalConfirmed);
            textViewTotalConfirmedTitle = itemView.findViewById(R.id.textViewTotalConfirmedTitle);
            textViewNewDeaths = itemView.findViewById(R.id.textViewNewDeaths);
            textViewNewDeathsTitle = itemView.findViewById(R.id.textViewNewDeathsTitle);
            textViewTotalDeaths = itemView.findViewById(R.id.textViewTotalDeaths);
            textViewTotalDeathsTitle = itemView.findViewById(R.id.textViewTotalDeathsTitle);
            textViewNewRecovered = itemView.findViewById(R.id.textViewNewRecovered);
            textViewNewRecoveredTitle = itemView.findViewById(R.id.textViewNewRecoveredTitle);
            textViewTotalRecovered = itemView.findViewById(R.id.textViewTotalRecovered);
            textViewTotalRecoveredTitle = itemView.findViewById(R.id.textViewTotalRecoveredTitle);


            textViewCountryName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (textViewNewConfirmed.getVisibility() == View.GONE) {
                        textViewNewConfirmed.setVisibility(View.VISIBLE);
                        textViewNewConfirmedTitle.setVisibility(View.VISIBLE);
                        textViewTotalConfirmed.setVisibility(View.VISIBLE);
                        textViewTotalConfirmedTitle.setVisibility(View.VISIBLE);
                        textViewNewDeaths.setVisibility(View.VISIBLE);
                        textViewNewDeathsTitle.setVisibility(View.VISIBLE);
                        textViewTotalDeaths.setVisibility(View.VISIBLE);
                        textViewTotalDeathsTitle.setVisibility(View.VISIBLE);
                        textViewNewRecovered.setVisibility(View.VISIBLE);
                        textViewNewRecoveredTitle.setVisibility(View.VISIBLE);
                        textViewTotalRecovered.setVisibility(View.VISIBLE);
                        textViewTotalRecoveredTitle.setVisibility(View.VISIBLE);
                    } else {
                        textViewNewConfirmed.setVisibility(View.GONE);
                        textViewNewConfirmedTitle.setVisibility(View.GONE);
                        textViewTotalConfirmed.setVisibility(View.GONE);
                        textViewTotalConfirmedTitle.setVisibility(View.GONE);
                        textViewNewDeaths.setVisibility(View.GONE);
                        textViewNewDeathsTitle.setVisibility(View.GONE);
                        textViewTotalDeaths.setVisibility(View.GONE);
                        textViewTotalDeathsTitle.setVisibility(View.GONE);
                        textViewNewRecovered.setVisibility(View.GONE);
                        textViewNewRecoveredTitle.setVisibility(View.GONE);
                        textViewTotalRecovered.setVisibility(View.GONE);
                        textViewTotalRecoveredTitle.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
}
