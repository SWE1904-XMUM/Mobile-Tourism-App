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
import com.example.xiamentourismapp.entity.Food;
import com.example.xiamentourismapp.manager.session.SessionManager;
import com.example.xiamentourismapp.utils.ui.ToastCreator;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>
{
    private Context context;
    private List<Food> foodList;
    private AppCompatActivity activity;

    public FoodAdapter(Context context, List<Food> foodList, AppCompatActivity activity)
    {
        this.context = context;
        this.foodList = foodList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.food_list,parent,false);
        return new FoodAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.foodImageList.setImageResource(foodList.get(position).foodImg);
        holder.foodRestaurantList.setText(String.valueOf(foodList.get(position).foodRestaurant));
        holder.foodRatingList.setText(String.valueOf(foodList.get(position).foodRating));

        holder.foodCard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent viewLink = new Intent(Intent.ACTION_VIEW);
                viewLink.setData(Uri.parse(foodList.get(position).foodLink));
                context.startActivity(viewLink);
            }
        });

        holder.foodCallBtnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + foodList.get(position).foodNo));

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

        holder.foodAddBtnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String uname = SessionManager.getUsername();
                boolean insertBookmark = BookmarkDb.insertBookmark(uname,foodList.get(position).foodRestaurant,foodList.get(position).foodLink,foodList.get(position).foodNo,foodList.get(position).foodImg);

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
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView foodRestaurantList,foodRatingList;
        private CardView foodCard;
        private ImageView foodImageList,foodAddBtnList,foodCallBtnList;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            foodCard = itemView.findViewById(R.id.foodCard);
            foodRestaurantList = itemView.findViewById(R.id.foodRestaurantList);
            foodRatingList = itemView.findViewById(R.id.foodRatingList);
            foodImageList = itemView.findViewById(R.id.foodImageList);
            foodCallBtnList = itemView.findViewById(R.id.foodCallBtnList);
            foodAddBtnList = itemView.findViewById(R.id.foodAddBtnList);
        }
    }
}
