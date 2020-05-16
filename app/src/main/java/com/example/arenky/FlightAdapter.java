package com.example.arenky;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.arenky.flight.FlightData;

import java.util.List;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.ViewHolder> {

    public final List<FlightData> flightDataList ;

    public FlightAdapter(List<FlightData> flightDataList){
        this.flightDataList = flightDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filght_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.flight = flightDataList.get(position);
        holder.gate.setText(flightDataList.get(position).gate);
        holder.price.setText(flightDataList.get(position).value + "");
        holder.departDate.setText(flightDataList.get(position).departDate);
        holder.duration.setText(flightDataList.get(position).duration + "");

        // implementar listener

    }

    @Override
    public int getItemCount() {
        return flightDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public FlightData flight;
        public final View mView;
        public final TextView gate;
        public final TextView price;
        public final TextView departDate;
        public final TextView duration;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            gate = mView.findViewById(R.id.flight_gate);
            price = mView.findViewById(R.id.price);
            departDate = mView.findViewById(R.id.depart_date);
            duration = mView.findViewById(R.id.duration);
        }
    }
}
