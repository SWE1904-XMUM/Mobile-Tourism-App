package com.example.xiamentourismapp.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.adapter.BookmarkAdapter;
import com.example.xiamentourismapp.db.BookmarkDb;
import com.example.xiamentourismapp.entity.Bookmark;
import com.example.xiamentourismapp.manager.session.SessionManager;

import java.util.List;

public class Bookmarks extends Fragment
{
    private RecyclerView bookmarkRecyclerView;
    private List<Bookmark> bookmarkList;
    private BookmarkAdapter bookmarkAdapter;
    private FrameLayout noBookmarkFrame;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Bookmarks");
        return inflater.inflate(R.layout.fragment_bookmarks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // set view component
        bookmarkRecyclerView = view.findViewById(R.id.bookmarkRecyclerView);
        noBookmarkFrame = view.findViewById(R.id.noBookmarkFrame);

        storeDataIntoList();
        updateRecyclerView();

        if (bookmarkAdapter.getItemCount() == 0)
        {
            noBookmarkFrame.setVisibility(View.VISIBLE);
        }

        else
        {
            noBookmarkFrame.setVisibility(View.GONE);
        }
    }

    private void storeDataIntoList()
    {
        String uname = SessionManager.getUsername();
        bookmarkList = BookmarkDb.getUserBookmarkByUsername(uname);
    }

    public void updateRecyclerView()
    {
        bookmarkAdapter = new BookmarkAdapter(getActivity(), bookmarkList, (AppCompatActivity) getActivity());
        bookmarkRecyclerView.setAdapter(bookmarkAdapter);
        bookmarkRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}