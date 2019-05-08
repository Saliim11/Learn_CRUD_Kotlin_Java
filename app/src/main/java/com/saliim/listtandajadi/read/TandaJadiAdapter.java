package com.saliim.listtandajadi.read;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.saliim.listtandajadi.R;
import com.saliim.listtandajadi.model.DataTandaJadi;

import java.util.ArrayList;
import java.util.List;

public class TandaJadiAdapter extends RecyclerView.Adapter<TandaJadiAdapter.TandaJadiViewHolder> {
    private List<DataTandaJadi> dataSet;

    public TandaJadiAdapter(ArrayList<DataTandaJadi> tempData) {
        dataSet = tempData;
    }

    @Override
    public TandaJadiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_tj, parent, false);

        return new TandaJadiViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TandaJadiViewHolder holder, int position) {
        DataTandaJadi dataTandaJadi = dataSet.get(position);
        holder.txtTandaJadi.setText(dataTandaJadi.getKategoriMotor());
        holder.txtCreateBy.setText(dataTandaJadi.getCreateBy());
    }

    @Override
    public int getItemCount() {
        if (dataSet == null) {
            return 0;
        } else {
            return dataSet.size();
        }
    }

    public class TandaJadiViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTandaJadi, txtCreateBy;

        public TandaJadiViewHolder(View itemView) {
            super(itemView);
            txtTandaJadi = itemView.findViewById(R.id.txt_tanda_jadi);
            txtCreateBy = itemView.findViewById(R.id.txt_create_by);

        }
    }
}

