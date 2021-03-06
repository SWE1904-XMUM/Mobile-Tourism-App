package com.example.xiamentourismapp.adapter;

import static android.Manifest.permission.CALL_PHONE;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.constant.GetFragment;
import com.example.xiamentourismapp.constant.RequestCode;
import com.example.xiamentourismapp.db.BookmarkDb;
import com.example.xiamentourismapp.entity.Bookmark;
import com.example.xiamentourismapp.fragment.AddNotes;
import com.example.xiamentourismapp.fragment.Bookmarks;
import com.example.xiamentourismapp.manager.FragmentManager;
import com.example.xiamentourismapp.utils.ui.ToastCreator;

import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.ViewHolder>
{
    private Context context;
    private List<Bookmark> bookmarkList;
    private AppCompatActivity activity;

    public BookmarkAdapter(Context context, List<Bookmark> bookmarkList, AppCompatActivity activity)
    {
        this.context = context;
        this.bookmarkList = bookmarkList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BookmarkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.bookmark_list,parent,false);
        return new BookmarkAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.bookmarkImageList.setImageResource(bookmarkList.get(position).bookmarkImage);
        holder.bookmarkNameList.setText(bookmarkList.get(position).bookmarkName);

        holder.bookmarkCard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent viewLink = new Intent(Intent.ACTION_VIEW);
                viewLink.setData(Uri.parse(bookmarkList.get(position).bookmarkLink));
                context.startActivity(viewLink);
            }
        });

        holder.callBtnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + bookmarkList.get(position).bookmarkPhone));

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

        holder.editBtnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Bundle id = new Bundle();
                id.putString("id",bookmarkList.get(position).bookmarkId.toString());
                Fragment addNotes = GetFragment.getAddNotesFragment();
                addNotes.setArguments(id);
                FragmentManager.beginNewFragment(activity,addNotes);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return bookmarkList != null ? bookmarkList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView bookmarkNameList;
        private CardView bookmarkCard;
        private ImageView bookmarkImageList,editBtnList,callBtnList;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            bookmarkCard = itemView.findViewById(R.id.bookmarkCard);
            bookmarkNameList = itemView.findViewById(R.id.bookmarkNameList);
            bookmarkImageList = itemView.findViewById(R.id.bookmarkImageList);
            callBtnList = itemView.findViewById(R.id.bookmarkCallBtnList);
            editBtnList = itemView.findViewById(R.id.editBtnList);
        }
    }
}
