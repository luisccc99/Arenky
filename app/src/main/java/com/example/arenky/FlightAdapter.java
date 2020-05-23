package com.example.arenky;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arenky.flight.FlightData;

import java.util.List;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.ViewHolder> implements View.OnClickListener {

    private final List<FlightData> flightDataList;

    private LayoutInflater mLayoutInflater;

    private View.OnClickListener mOnClickListener;

    public FlightAdapter(Context context, List<FlightData> flightDataList) {
        mLayoutInflater = LayoutInflater.from(context);
        this.flightDataList = flightDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater
                .inflate(R.layout.filght_item, parent, false);

        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.flight = flightDataList.get(position);
        holder.gate.setText(flightDataList.get(position).gate);
        holder.price.setText(flightDataList.get(position).value + " MXN");
        holder.departDate.setText("Ida: " + flightDataList.get(position).departDate);
        holder.duration.setText(flightDataList.get(position).duration + " min");

    }

    @Override
    public int getItemCount() {
        return flightDataList.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnClickListener != null) {
            // pasar la lista
            mOnClickListener.onClick(v);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        FlightData flight;
        final View mView;
        final TextView gate;
        final TextView price;
        final TextView departDate;
        final TextView duration;

        ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            gate = mView.findViewById(R.id.flight_gate);
            price = mView.findViewById(R.id.price);
            departDate = mView.findViewById(R.id.depart_date);
            duration = mView.findViewById(R.id.duration);
        }

    }
}
