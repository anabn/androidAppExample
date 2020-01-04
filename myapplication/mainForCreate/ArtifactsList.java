package com.myapplication.mainForCreate;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.myapplication.R;
import java.util.List;


/**
 * Responsible for Adapter.class to retrieve the data from Firebase RealTime
 *
 */
public class ArtifactsList extends ArrayAdapter<Artifacts> {

    private Activity context;
    private List<Artifacts> artifactsList;

    public ArtifactsList(Activity context, List<Artifacts> artifactsList){
        super(context, R.layout.simple_layout, artifactsList);
        this.context = context;
        this.artifactsList = artifactsList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.simple_layout, null, true);

        Artifacts artifacts = artifactsList.get(position);

        TextView textViewName = listViewItem.findViewById(R.id.title_read);
        TextView textViewAuthor = listViewItem.findViewById(R.id.author_read);

        textViewName.setText("The title for this book : " + artifacts.getNameOfTittle());
        if(artifacts.getNameOfAuthor() == null | artifacts.getNameOfAuthor().equals("")){
            textViewAuthor.setText(" Created by : " + " not specified ");
        } else {
            textViewAuthor.setText("Created by : "  + artifacts.getNameOfAuthor());
        }
        return listViewItem;
    }
}
