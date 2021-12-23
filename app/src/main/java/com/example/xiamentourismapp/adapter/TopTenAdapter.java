package com.example.xiamentourismapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.entity.TopTenTourism;

import java.util.List;

public class TopTenAdapter extends RecyclerView.Adapter<TopTenAdapter.ViewHolder>
{
    private Context context;
    private List<TopTenTourism> tourismList;

    public TopTenAdapter(Context context,List<TopTenTourism> tourismList)
    {
        this.context = context;
        this.tourismList = tourismList;
    }

    @NonNull
    @Override
    public TopTenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.tourism_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopTenAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.tourismImgList.setImageResource(tourismList.get(position).tourismImg);
        holder.top10List.setText(tourismList.get(position).tourismName);
        holder.descriptionList.setText(tourismList.get(position).tourismDescriptions);

        holder.top10Card.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent viewLink = new Intent(Intent.ACTION_VIEW);
                viewLink.setData(Uri.parse(tourismList.get(position).tourismLink));
                context.startActivity(viewLink);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return tourismList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView top10List,descriptionList;
        private CardView top10Card;
        private ImageView tourismImgList;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            tourismImgList = itemView.findViewById(R.id.tourismImgList);
            top10Card = itemView.findViewById(R.id.top10Card);
            top10List = itemView.findViewById(R.id.top10List);
            descriptionList = itemView.findViewById(R.id.descriptionList);
        }
    }
}
