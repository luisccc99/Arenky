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

import com.example.arenky.hotels.EntitySuggestion;

import java.util.List;

public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.ViewHolder>
implements View.OnClickListener{

    private List<EntitySuggestion> entityHotels;
    private LayoutInflater mLayoutInflater;
    private View.OnClickListener mOnClickListener;

    public SuggestionsAdapter(Context context, List<EntitySuggestion> entityHotels) {
        mLayoutInflater = LayoutInflater.from(context);
        this.entityHotels = entityHotels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.
                inflate(R.layout.suggestion_item, parent, false);
        view.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        if (mOnClickListener != null) {
            mOnClickListener.onClick(v);
        }
    }

    public void setmOnClickListener(View.OnClickListener onClickListener){
        mOnClickListener = onClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        EntitySuggestion hotel;
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
