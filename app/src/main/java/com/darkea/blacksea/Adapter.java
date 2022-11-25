package com.darkea.blacksea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Instance> instanceArrayList;
    private Context context;

    // constructor
    public Adapter(ArrayList<Instance> instanceArrayList, Context context) {
        this.instanceArrayList = instanceArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewer = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_items, parent, false);
        return new ViewHolder(viewer);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Instance modal = instanceArrayList.get(position);
        holder.Name_Text.setText(modal.getName());
        holder.Bio_Text.setText(modal.getBio());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return instanceArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView Name_Text, Bio_Text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            Name_Text = itemView.findViewById(R.id.historyItems_txt_name);
            Bio_Text = itemView.findViewById(R.id.historyItems_txt_bio);
        }
    }
}