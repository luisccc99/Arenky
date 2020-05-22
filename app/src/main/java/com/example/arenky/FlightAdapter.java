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

    private OnFlightListener mOnFlightListener;

    public FlightAdapter(List<FlightData> flightDataList, OnFlightListener onFlightListener){
        this.flightDataList = flightDataList;
        mOnFlightListener = onFlightListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filght_item, parent, false);
        return new ViewHolder(view, mOnFlightListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.flight = flightDataList.get(position);
        holder.gate.setText("De: "+flightDataList.get(position).gate);
        holder.price.setText(flightDataList.get(position).value + " MXN");
        holder.departDate.setText("Ida: "+flightDataList.get(position).departDate);
        holder.duration.setText(flightDataList.get(position).duration + " min");

    }

    @Override
    public int getItemCount() {
        return flightDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public FlightData flight;
        public final View mView;
        public final TextView gate;
        public final TextView price;
        public final TextView departDate;
        public final TextView duration;
        OnFlightListener onFlightListener;

        public ViewHolder(View itemView, OnFlightListener onFlightListener) {
            super(itemView);
            mView = itemView;
            gate = mView.findViewById(R.id.flight_gate);
            price = mView.findViewById(R.id.price);
            departDate = mView.findViewById(R.id.depart_date);
            duration = mView.findViewById(R.id.duration);
            this.onFlightListener = onFlightListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onFlightListener.onFlightClick(flightDataList.get(getAdapterPosition()));
        }
    }

    public interface OnFlightListener{
        void onFlightClick(FlightData flightData);
    }
}
