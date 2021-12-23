package com.example.xiamentourismapp.adapter;

import static android.Manifest.permission.CALL_PHONE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.constant.RequestCode;
import com.example.xiamentourismapp.entity.Hotel;
import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder>
{
    private Context context;
    private List<Hotel> hotelList;
    private AppCompatActivity activity;

    public HotelAdapter(Context context, List<Hotel> hotelList, AppCompatActivity activity)
    {
        this.context = context;
        this.hotelList = hotelList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.hotel_list,parent,false);
        return new HotelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.hotelImageList.setImageResource(hotelList.get(position).hotelImage);
        holder.hotelNameList.setText(hotelList.get(position).hotelName);
        holder.hotelRatingList.setText(String.valueOf(hotelList.get(position).hotelRating));

        holder.hotelCard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent viewLink = new Intent(Intent.ACTION_VIEW);
                viewLink.setData(Uri.parse(hotelList.get(position).hotelLink));
                context.startActivity(viewLink);
            }
        });

        holder.callBtnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + hotelList.get(position).hotelNo));

                if (ContextCompat.checkSelfPermission(activity,CALL_PHONE)== PackageManager.PERMISSION_GRANTED)
                {
                    context.startActivity(i);
                }

                else
                {
                    activity.requestPermissions(new String[]{CALL_PHONE}, RequestCode.PHONE_CALL);
                }
            }
        });

        holder.addBtnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // TODO -> add to bookmark db
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return hotelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView hotelNameList,hotelRatingList;
        private CardView hotelCard;
        private ImageView hotelImageList,addBtnList,callBtnList;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            hotelCard = itemView.findViewById(R.id.hotelCard);
            hotelNameList = itemView.findViewById(R.id.hotelNameList);
            hotelRatingList = itemView.findViewById(R.id.hotelRatingList);
            hotelImageList = itemView.findViewById(R.id.hotelImageList);
            callBtnList = itemView.findViewById(R.id.callBtnList);
            addBtnList = itemView.findViewById(R.id.addBtnList);
        }
    }
}
