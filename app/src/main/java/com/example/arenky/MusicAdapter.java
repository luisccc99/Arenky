package com.example.arenky;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arenky.music.TrackData;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    private final List<TrackData> trackDataList;

    private LayoutInflater mLayoutInflater;

    public MusicAdapter(Context context, List<TrackData> trackDataList) {
        mLayoutInflater = LayoutInflater.from(context);
        this.trackDataList = trackDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater
                .inflate(R.layout.track_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.trackData = trackDataList.get(position);
        holder.rankAndName.setText("#" + (position + 1)
                + " " + trackDataList.get(position).name);
        holder.artist.setText("" + trackDataList.get(position).artist);

    }

    @Override
    public int getItemCount() {
        return trackDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TrackData trackData;
        final View mView;
        final TextView rankAndName;
        final TextView artist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            rankAndName = mView.findViewById(R.id.track_name);
            artist = mView.findViewById(R.id.artist);
        }
    }
}
