package com.example.arenky;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arenky.hotels.EntityHotel;
import com.example.arenky.hotels.SuggestionsFromSearch;

import java.util.List;

public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.ViewHolder> {

    private List<EntityHotel> entityHotels;
    private LayoutInflater mLayoutInflater;

    public SuggestionsAdapter(Context context, List<EntityHotel> entityHotels) {
        mLayoutInflater = LayoutInflater.from(context);
        this.entityHotels = entityHotels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.
                inflate(R.layout.suggestion_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.hotel = entityHotels.get(position);
        holder.nameSuggestion.setText(entityHotels.get(position).nameEntity);
        holder.typeSuggestion.setText(entityHotels.get(position).type);
        holder.caption.setText(Html.fromHtml(
                entityHotels.get(position).caption
        ));

    }

    @Override
    public int getItemCount() {
        return entityHotels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        EntityHotel hotel;
        final View mView;
        final TextView nameSuggestion;
        final TextView typeSuggestion;
        final TextView caption;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            nameSuggestion = mView.findViewById(R.id.name_suggestion);
            typeSuggestion = mView.findViewById(R.id.type_suggestion);
            caption = mView.findViewById(R.id.caption_suggestion);
        }
    }
}
