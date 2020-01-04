package com.myapplication.mainForRead;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myapplication.R;
import com.myapplication.mainForCreate.Artifacts;
import com.myapplication.mainForCreate.ArtifactsList;

import java.util.ArrayList;
import java.util.List;

/**
 * ReadActivity - view просмотра finish status c бд
 *
 * @author Anna Festun
 * @version 1.0.1
 */
public class ReadActivity extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<Artifacts> artifactsList;
    private ArtifactsList artifactsListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        databaseReference = FirebaseDatabase.getInstance().getReference("artifacts");
        artifactsList = new ArrayList<>();
        artifactsListAdapter = new ArtifactsList(ReadActivity.this, artifactsList);
        listView = findViewById(R.id.listViewDB);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                artifactsList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Artifacts artifacts = dataSnapshot1.getValue(Artifacts.class);
                    if (artifacts.getCheckedStatus() == 0) {
                        artifactsList.add(artifacts);
                    }
                }
                listView.setAdapter(artifactsListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        super.onStart();
    }
}
