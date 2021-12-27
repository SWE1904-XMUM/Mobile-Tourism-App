package com.example.xiamentourismapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.constant.GetFragment;
import com.example.xiamentourismapp.db.BookmarkDb;
import com.example.xiamentourismapp.db.NotesDb;
import com.example.xiamentourismapp.entity.Bookmark;
import com.example.xiamentourismapp.manager.FragmentManager;
import com.example.xiamentourismapp.manager.session.SessionManager;
import com.example.xiamentourismapp.utils.ui.ToastCreator;

import java.security.PrivateKey;
import java.util.List;

public class AddNotes extends Fragment
{
    private List<Bookmark> bookmarkList;
    private ImageView bookmarkImg;
    private TextView bookmarkName;
    private EditText notes;
    private Button addNotesBtn;

    String bookmarkId, noteTxt;
    String uname = SessionManager.getUsername();
    Integer noteId;
    boolean checkNote = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Add notes");
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_add_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // get argument pass by Bookmarks fragment
        Bundle bundle = this.getArguments();
        bookmarkId = bundle.getString("id");

        // set view component
        bookmarkImg = view.findViewById(R.id.bookmarkImg);
        bookmarkName = view.findViewById(R.id.bookmarkName);
        notes = view.findViewById(R.id.notes);
        addNotesBtn = view.findViewById(R.id.addNotesBtn);

        storeDataIntoList();
        displayDataFromDb();
        getEditText();

        noteId = NotesDb.checkExistingNote(uname,Integer.parseInt(bookmarkId));

        checkNoteAndDisplay();

        addNotesBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getEditText();

                if (noteTxt.equals(""))
                {
                    ToastCreator.createToast(getActivity(),"No note entered.");
                    return;
                }

                if (checkNote == false)
                {
                    boolean insertNote = NotesDb.insertNote(Integer.parseInt(bookmarkId),uname,noteTxt);

                    if (insertNote)
                    {
                        ToastCreator.createToast(getActivity(),"Note inserted!");
                        FragmentManager.beginNewFragment((AppCompatActivity) getActivity(), GetFragment.getBookmarksFragment());
                    }

                    else
                    {
                        ToastCreator.createToast(getActivity(),"Fail to insert note.");
                    }
                }

                else
                {
                    boolean updateNote = NotesDb.updateNotes(noteId,noteTxt);

                    if (updateNote)
                    {
                        ToastCreator.createToast(getActivity(),"Note updated!");
                        FragmentManager.beginNewFragment((AppCompatActivity) getActivity(), GetFragment.getBookmarksFragment());
                    }

                    else
                    {
                        ToastCreator.createToast(getActivity(),"Fail to update note.");
                    }
                }
            }
        });
    }

    private void storeDataIntoList()
    {
        bookmarkList = BookmarkDb.getBookmarkByBookmarkId(bookmarkId);
    }

    private void getEditText()
    {
        noteTxt = notes.getText().toString();
    }

    private void checkNoteAndDisplay()
    {
        if (noteId == -1)
        {
            notes.setText("");
            addNotesBtn.setText("Add notes");
            checkNote = false;
        }

        else
        {
            String note = NotesDb.getNotesByNoteId(noteId);
            notes.setText(note);
            addNotesBtn.setText("Update notes");
            checkNote = true;
        }
    }

    private void displayDataFromDb()
    {
        bookmarkImg.setImageResource(bookmarkList.get(0).bookmarkImage);
        bookmarkName.setText(bookmarkList.get(0).bookmarkName);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.delete_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.deleteBtn)
        {
            boolean deleteBookmark = BookmarkDb.deleteBookmark(bookmarkId);

            if (deleteBookmark)
            {
                if (checkNote == true)
                {
                    if (NotesDb.deleteNotes(noteId))
                    {
                        ToastCreator.createToast(getActivity(),"Bookmark & notes deleted.");
                    }
                }

                else
                {
                    ToastCreator.createToast(getActivity(),"Bookmark deleted.");
                }

                FragmentManager.beginNewFragment((AppCompatActivity) getActivity(), GetFragment.getBookmarksFragment());
            }

            else
            {
                ToastCreator.createToast(getActivity(),"Fail to delete bookmark.");
            }

            return true;
        }

        else if (id == R.id.backBtn)
        {
            FragmentManager.beginNewFragment((AppCompatActivity) getActivity(), GetFragment.getBookmarksFragment());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}