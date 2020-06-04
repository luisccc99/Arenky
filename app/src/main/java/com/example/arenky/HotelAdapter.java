package com.example.arenky;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.arenky.hotels.Price;
import com.example.arenky.hotels.RatePlan;
import com.example.arenky.hotels.SearchHotelsResult;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private final List<SearchHotelsResult> hotels;

    private LayoutInflater mLayoutInflater;

    public HotelAdapter(Context context, List<SearchHotelsResult> hotels) {
        mLayoutInflater = LayoutInflater.from(context);
        this.hotels = hotels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater
                .inflate(R.layout.hotel_item, parent, false);
        // set on click listener here
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.hotel = hotels.get(position);
        Glide.with(holder.imgHotel.getContext())
                .load(hotels.get(position).thumbnail)
                .into(holder.imgHotel);
        holder.textViewHotelName.setText(hotels.get(position).hotelName);
        holder.textViewHotelRating.setText("starRating: " + hotels.get(position).starRating);
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SearchHotelsResult hotel;
        final View mView;
        final ImageView imgHotel;
        final TextView textViewHotelName;
        final TextView textViewPrice;
        final TextView textViewHotelRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            imgHotel = mView.findViewById(R.id.img_hotel);
            textViewHotelName = mView.findViewById(R.id.hotel_name);
            textViewPrice = mView.findViewById(R.id.hotel_price);
            textViewHotelRating = mView.findViewById(R.id.hotel_rating);
        }
    }
}
