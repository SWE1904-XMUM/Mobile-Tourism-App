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
import com.example.xiamentourismapp.constant.GetFragment;
import com.example.xiamentourismapp.constant.RequestCode;
import com.example.xiamentourismapp.db.BookmarkDb;
import com.example.xiamentourismapp.entity.Bookmark;
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

        holder.deleteBtnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                boolean deleteBookmark = BookmarkDb.deleteBookmark(bookmarkList.get(position).bookmarkName);

                if (deleteBookmark)
                {
                    bookmarkList.remove(position);
                    notifyDataSetChanged();
                    notifyItemRemoved(position);

                    if (getItemCount() == 0)
                    {
                        /*Bookmarks bookmarks = new Bookmarks();
                        bookmarks.updateView();*/
                    }
                    ToastCreator.createToast(activity,"Bookmark deleted.");
                }

                else
                {
                    ToastCreator.createToast(activity,"Fail to delete bookmark.");
                }
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
        private ImageView bookmarkImageList,deleteBtnList,callBtnList;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            bookmarkCard = itemView.findViewById(R.id.bookmarkCard);
            bookmarkNameList = itemView.findViewById(R.id.bookmarkNameList);
            bookmarkImageList = itemView.findViewById(R.id.bookmarkImageList);
            callBtnList = itemView.findViewById(R.id.bookmarkCallBtnList);
            deleteBtnList = itemView.findViewById(R.id.deleteBtnList);
        }
    }
}
