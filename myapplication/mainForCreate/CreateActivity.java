package com.myapplication.mainForCreate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.myapplication.R;
import com.myapplication.databinding.ActivityCreateBinding;
import com.myapplication.databinding.ActivityMainBinding;
import com.myapplication.main.MainActivity;

import java.util.regex.Pattern;

/**
 * CreateActivity - view создания record ->
 *                  переход от главного интерфейса кнопкой <b>create</b>
 *                  занесение данных в базу данных <b>Firebase</b>
 * @author Anna Festun
 * @version 1.0.1
 */

public class CreateActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * @param
     *
     * @return clear view для записи нового record
     */

    private LinearLayout linearLayoutForPages;
    private RadioGroup radioGroup;
    private Button addRecord;
    private EditText strTittle, strAuthor;
    private boolean statusDoubleCheck;
    private  static final Pattern PAGES_PATTERN = Pattern.compile("\\d+?");

    private EditText getFromEditNew;
    private EditText getFromEditNewAll;
    DatabaseReference databaseAtrifacts;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        databaseAtrifacts = FirebaseDatabase.getInstance().getReference("artifacts");

        strTittle = findViewById(R.id.strTittle);
        strAuthor = findViewById(R.id.strAuthor);
        linearLayoutForPages = findViewById(R.id.LinearLayoutForEdit);
        radioGroup = findViewById(R.id.validateStatus);

        addRecordToDB();
        addReadingLayout();
    }

    /**
     *
     * @see MainActivity
     */
    public void addReadingLayout(){

        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.radioButtonRead:
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                                        ViewGroup.LayoutParams.WRAP_CONTENT,
                                        ViewGroup.LayoutParams.WRAP_CONTENT);

                                TextView textCurrentPage = new TextView(CreateActivity.this);
                                textCurrentPage.setText("Current page : ");
                                textCurrentPage.setPadding(50, 0, 30, 0);

                                EditText editText = new EditText(CreateActivity.this);
                                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
//                                editText.setPadding(0,0,0,0);
                                editText.setMinWidth(130);
                                editText.setHint("123");
//                                editText.setId(CreateActivity.);

                                TextView textAllPage = new TextView(CreateActivity.this);
                                textAllPage.setText("all page : ");
                                textAllPage.setPadding(50, 0, 30, 0);

                                EditText editAllText = new EditText(CreateActivity.this);
                                editAllText.setInputType(InputType.TYPE_CLASS_NUMBER);
                                editAllText.setMinWidth(130);
                                editAllText.setHint("123");

                                linearLayoutForPages.addView(textCurrentPage, layoutParams);
                                linearLayoutForPages.addView(editText, layoutParams);
                                linearLayoutForPages.addView(textAllPage, layoutParams);
                                linearLayoutForPages.addView(editAllText, layoutParams);

                                getFromEditNew = editText;
                                getFromEditNewAll = editAllText;
                                statusDoubleCheck = false;
                                break;
                            case R.id.radioButtonFinish:
                                Toast.makeText(CreateActivity.this, "he", Toast.LENGTH_LONG).show();
                                linearLayoutForPages.removeAllViews();
                                statusDoubleCheck = true;
//                                Toast.makeText(CreateActivity.this, "radioButtonFinished", Toast.LENGTH_SHORT).show();
                                break;

                        }
                    }
                }
        );
    }

    @Override
    public void onClick(View view){

    }

    /**
     * @param
     * {@addRecordToDB()}
     */
   public void addRecordToDB(){
       addRecord = findViewById(R.id.buttonAddRecord);
       addRecord.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View view){
                       addStringToRecord();
                   }
               }
       );

   }

    /**
     *
     */
    private void addStringToRecord(){
        String nameTittle = strTittle.getText().toString().trim();
        String nameAuthor = strAuthor.getText().toString().trim();
        String countPages = getFromEditNew.getText().toString().trim();
        String allPages = getFromEditNewAll.getText().toString().trim();

        int checked;

        if (TextUtils.isEmpty(nameTittle) && statusDoubleCheck) {
            strTittle.setError("empty title");
        } else if (!TextUtils.isEmpty(nameTittle)) {
            String id = databaseAtrifacts.push().getKey();
            if (!statusDoubleCheck){
                checked = 1;
                if (!TextUtils.isEmpty(countPages)){
                    Artifacts artifacts = new Artifacts(id, nameTittle, nameAuthor, checked, countPages, allPages);
                    databaseAtrifacts.child(id).setValue(artifacts);
                    Toast.makeText(CreateActivity.this, "record added to db", Toast.LENGTH_LONG).show();
                    } else if (TextUtils.isEmpty(countPages)) {
                        getFromEditNew.setError("empty tittle");
                        Toast.makeText(CreateActivity.this, "empty count pages", Toast.LENGTH_LONG).show();
                    }
                } else {
                    checked = 0;
                    Artifacts artifacts = new Artifacts(id, nameTittle, nameAuthor, checked);
                    databaseAtrifacts.child(id).setValue(artifacts);
                    Toast.makeText(CreateActivity.this, "record added to db finished book", Toast.LENGTH_LONG).show();
                }

            } else {
                strTittle.setError("empty title");
            }
        strTittle.setText("");
        strAuthor.setText("");
        getFromEditNew.setText("");
        getFromEditNewAll.setText("");
    }

}
