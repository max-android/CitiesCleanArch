package com.myexamplemetcast.citiescleanarch.presentation.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myexamplemetcast.citiescleanarch.R;
import com.myexamplemetcast.citiescleanarch.domain.model.Town;

import java.util.List;


public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {

    private List<Town> towns;



    private final TownClickListener listener;


    public CitiesAdapter(List<Town> towns, TownClickListener listener) {
        this.towns = towns;

        this.listener = listener;
    }

    @Override
    public CitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());

        View view=inflater.inflate(R.layout.item_town,parent,false);

        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CitiesAdapter.ViewHolder holder, int position) {

        Town town=towns.get(position);
        holder.bindTo(town);

    }

    @Override
    public int getItemCount() {
        return towns.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvTown;
        private final TextView tvCountry;

        private Town town;


        public ViewHolder(View itemView) {
            super(itemView);

            tvTown=(TextView)itemView.findViewById(R.id.tvTown);
            tvCountry=(TextView)itemView.findViewById(R.id.tvCountry);

                itemView.setOnClickListener(this::launchTown );
        }


        private void launchTown(View view){

            listener.onTownClick(town);

        }

        public  void bindTo(Town town){

            this.town=town;
            tvTown.setText(town.getCity());
            tvCountry.setText(town.getLocalizedCountryName());

        }
    }


public interface TownClickListener {
    void onTownClick(Town town);
}

}
