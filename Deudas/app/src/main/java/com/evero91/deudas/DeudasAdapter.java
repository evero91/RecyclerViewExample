package com.evero91.deudas;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeudasAdapter extends RecyclerView.Adapter<DeudasAdapter.DeudasViewHolder> {

    private List<String> mData;
    private LayoutInflater mInlater;
    private Listener listener;

    public static interface Listener {
        public void onClick(int position);
    }

    public DeudasAdapter(Context context, List<String> myData) {
        this.mInlater = LayoutInflater.from(context);
        mData = myData;
    }

    public static class DeudasViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public DeudasViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.titulo_deuda);
        }
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public DeudasAdapter.DeudasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mInlater.inflate(R.layout.deuda_row, parent, false);
        return new DeudasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DeudasViewHolder holder, final int position) {
        holder.textView.setText(mData.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
