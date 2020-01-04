package com.myapplication.mainForActive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

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
 * ActiveActivity - создание входной точки - главного интерфейса
 *
 * @author Anna Fetsun [DA - 61]
 * @version 1.0.1
 *
 */

public class ActiveActivity extends AppCompatActivity implements ActiveContract.MvpViewActive{

    /**
     * @param DatabaseReference
     * @param listViewArt
     * @param artifactsList
     */

    private ListView listView;
    DatabaseReference databaseReference;
    private List<Artifacts> artifactsList;
    private ActivityAdapterList artifactsListAdapter;

    private ActivePresenter activePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active);

        databaseReference = FirebaseDatabase.getInstance().getReference("artifacts");
        listView = findViewById(R.id.listViewActiveDB);
        artifactsList = new ArrayList<>();
        artifactsListAdapter = new ActivityAdapterList(ActiveActivity.this, artifactsList);

        activePresenter = new ActivePresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub

        menu.add("Edit record ");
        menu.add("delete");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                artifactsList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Artifacts artifacts = dataSnapshot1.getValue(Artifacts.class);
                    if (artifacts.getCheckedStatus() == 1) {
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

    @Override
    public void showEditPage() {
        Toast.makeText(ActiveActivity.this, "edit page", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showClearView() {
        Toast.makeText(ActiveActivity.this, "clear", Toast.LENGTH_LONG).show();
    }
}
