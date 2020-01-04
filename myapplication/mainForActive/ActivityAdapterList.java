package com.myapplication.mainForActive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.myapplication.R;
import com.myapplication.mainForCreate.Artifacts;

import java.util.List;

/**
 * @see Artifacts - based on this structure
 * @see com.myapplication.mainForCreate.ArtifactsList - similar to this class
 */
public class ActivityAdapterList extends ArrayAdapter {
    private Activity context;
    private List<Artifacts> artifactsList;

    /**
     * Constructor
     * @param context - activity for actions
     * @param artifactsList - structure
     */
    public ActivityAdapterList(Activity context, List<Artifacts> artifactsList){
        super(context, R.layout.simple_layout_with_pages, artifactsList);
        this.context = context;
        this.artifactsList = artifactsList;
    }

    /**
     *
     * @param position - place on layout
     * @param convertView - simple view
     * @param parent - the first
     * @return the view of the record to Active activity
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.simple_layout_with_pages, null, true);

        Artifacts artifacts = artifactsList.get(position);

        TextView textViewName = listViewItem.findViewById(R.id.title_read);
        TextView textViewAuthor = listViewItem.findViewById(R.id.author_read);
        TextView textViewAllPage = listViewItem.findViewById(R.id.allPageView);
        TextView textViewCurrent = listViewItem.findViewById(R.id.currentPageView);

        textViewName.setText("The title for this book : " + artifacts.getNameOfTittle());
        textViewCurrent.setText("textViewCurrent : "  + artifacts.getCurrentPage());

        if(artifacts.getNameOfAuthor() == null | artifacts.getNameOfAuthor().equals("")){
            textViewAuthor.setText(" Created by : " + " not specified ");
        } else {
            textViewAuthor.setText("Created by : "  + artifacts.getNameOfAuthor());
        }

        if (artifacts.getAllPages() == null | artifacts.getAllPages().equals("")){
            textViewAllPage.setText("textViewAllPage: " + " not specified ");
        } else {
            textViewAllPage.setText("textViewAllPage: " + artifacts.getAllPages());
        }

        return listViewItem;
    }
}
