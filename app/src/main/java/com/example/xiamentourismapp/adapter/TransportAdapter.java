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
import com.example.xiamentourismapp.db.BookmarkDb;
import com.example.xiamentourismapp.entity.Transport;
import com.example.xiamentourismapp.manager.session.SessionManager;
import com.example.xiamentourismapp.utils.ui.ToastCreator;

import java.util.List;

public class TransportAdapter extends RecyclerView.Adapter<TransportAdapter.ViewHolder>
{
    private Context context;
    private List<Transport> transportList;
    private AppCompatActivity activity;

    public TransportAdapter(Context context, List<Transport> transportList, AppCompatActivity activity)
    {
        this.context = context;
        this.transportList = transportList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TransportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.transport_list,parent,false);
        return new TransportAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.transportImageList.setImageResource(transportList.get(position).transportImg);
        holder.transportNameList.setText(transportList.get(position).transportName);

        holder.transportCard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent viewLink = new Intent(Intent.ACTION_VIEW);
                viewLink.setData(Uri.parse(transportList.get(position).transportLink));
                context.startActivity(viewLink);
            }
        });

        holder.transportCallBtnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + transportList.get(position).transportNo));

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

        holder.transportAddBtnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String uname = SessionManager.getUsername();
                boolean insertBookmark = BookmarkDb.insertBookmark(uname,transportList.get(position).transportName,transportList.get(position).transportLink,transportList.get(position).transportNo,transportList.get(position).transportImg);

                if (insertBookmark)
                {
                    ToastCreator.createToast(activity,"Added to bookmark.");
                }

                else
                {
                    ToastCreator.createToast(activity,"Fail to add bookmark.");
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return transportList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView transportNameList;
        private CardView transportCard;
        private ImageView transportImageList,transportAddBtnList,transportCallBtnList;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            transportCard = itemView.findViewById(R.id.transportCard);
            transportNameList = itemView.findViewById(R.id.transportNameList);
            transportImageList = itemView.findViewById(R.id.transportImageList);
            transportCallBtnList = itemView.findViewById(R.id.transportCallBtnList);
            transportAddBtnList = itemView.findViewById(R.id.transportAddBtnList);
        }
    }
}

