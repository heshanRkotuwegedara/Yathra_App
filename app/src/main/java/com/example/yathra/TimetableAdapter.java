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
    private ArrayList routeName, tDate, arriveTime, departTime, trainName;

    public TimetableAdapter(Context context, ArrayList routeName, ArrayList tDate, ArrayList arriveTime, ArrayList departTime, ArrayList trainName) {
        this.context = context;
        this.routeName = routeName;
        this.tDate = tDate;
        this.arriveTime = arriveTime;
        this.departTime = departTime;
        this.trainName = trainName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.routeName.setText(String.valueOf(routeName.get(position)));
        holder.tDate.setText(String.valueOf(tDate.get(position)));
        holder.arriveTime.setText(String.valueOf(arriveTime.get(position)));
        holder.departTime.setText(String.valueOf(departTime.get(position)));
        holder.trainName.setText(String.valueOf(trainName.get(position)));

    }

    @Override
    public int getItemCount() {
        return routeName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView routeName, tDate, arriveTime, departTime, trainName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            routeName = itemView.findViewById(R.id.txtRouteNameDisplay);
            tDate = itemView.findViewById(R.id.txtDateDisplay);
            arriveTime = itemView.findViewById(R.id.txtArriveTimeDisplay);
            departTime = itemView.findViewById(R.id.txtDepartTimeDisplay);
            trainName = itemView.findViewById(R.id.txtTrainNameDisplay);
        }
    }
}
