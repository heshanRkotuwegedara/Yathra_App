package com.example.yathra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.MyViewHolder> {

    private Context context;
    private ArrayList timeID, routeName, startStation, endStation, trainName;

    TimetableAdapter(Context context,
                     ArrayList timeID,
                     ArrayList routeName,
                     ArrayList startStation,
                     ArrayList endStation,
                     ArrayList trainName){

        this.context = context;
        this.timeID = timeID;
        this.routeName = routeName;
        this.startStation = startStation;
        this.endStation = endStation;
        this.trainName = trainName;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_timetable_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.timeID.setText(String.valueOf(timeID.get(position)));
        holder.routeName.setText(String.valueOf(routeName.get(position)));
        holder.startStation.setText(String.valueOf(startStation.get(position)));
        holder.endStation.setText(String.valueOf(endStation.get(position)));
        holder.trainName.setText(String.valueOf(trainName.get(position)));

    }

    @Override
    public int getItemCount() {
        return timeID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView timeID, routeName, startStation, endStation, trainName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            timeID = itemView.findViewById(R.id.txtIDTR);
           routeName = itemView.findViewById(R.id.txtRouteNameTD);
           startStation = itemView.findViewById(R.id.txtStartStationTD);
           endStation = itemView.findViewById(R.id.txtEndStationTD);
           trainName = itemView.findViewById(R.id.txtTrainNameTR);
        }
    }
}
