package com.myapplication.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.myapplication.mainForActive.ActiveActivity;
import com.myapplication.databinding.ActivityMainBinding;
import com.myapplication.mainForCreate.CreateActivity;
import com.myapplication.R;
import com.myapplication.mainForRead.ReadActivity;

/**
 * MainActivity - создание входной точки - главного интерфейса <br>
 * <b> Displays the main screen </b> <br>
 *  created using MVP pattern
 * @author Anna Fetsun [DA - 61]
 * @version 1.0.1
 *
 * data: 11/25/2019 for creating doxygen
 *
 */
public class MainActivity extends AppCompatActivity implements MainContract.MvpView{
    /**
     *
     * {@value} represent a main presenter for the first page
     * @see ActiveActivity ,
     * @see CreateActivity ,
     * @see ReadActivity - were intent using the relevant buttons
     * @param savedInstanceState - super при создании
     *
     */
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        addListenerOnButton();
    }

//    @Override
//    protected void onStart(){
//        super.onStart();
//    }
//
//    @Override
//    protected void onResume(){
//        super.onResume();
//    }

//    public void addListenerOnButton(){
//        btn_create = findViewById(R.id.buttonCreate);
//        btn_active = findViewById(R.id.buttonActive);
//        btn_read = findViewById(R.id.buttonRead);
//
//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                switch (view.getId()) {
//                    case R.id.buttonCreate:
//                        Intent intentToCreate = new Intent("android.intent.action.CreateActivity");
//                        startActivity(intentToCreate);
//                        break;
//                    case R.id.buttonActive:
//                        Intent intentToActive = new Intent("android.intent.action.ActiveActivity");
//                        startActivity(intentToActive);
//                        break;
//                    case R.id.buttonRead:
//                        Intent intentToRead = new Intent("android.intent.action.ReadActivity");
//                        startActivity(intentToRead);
//                        break;
//                }
//            }
//        };
//        btn_create.setOnClickListener(onClickListener);
//        btn_active.setOnClickListener(onClickListener);
//        btn_read.setOnClickListener(onClickListener);
//    }

    @Override
    public void showCreateActivity() {
        Intent intentToCreate = new Intent("android.intent.action.CreateActivity");
        startActivity(intentToCreate);
    }

    @Override
    public void showActiveActivity() {
        Intent intentToActive = new Intent("android.intent.action.ActiveActivity");
        startActivity(intentToActive);

    }

    @Override
    public void showReadActivity() {
        Intent intentToRead = new Intent("android.intent.action.ReadActivity");
        startActivity(intentToRead);
    }

    @Override
    public void showLoginForm() {
        Intent intentToLoginForm = new Intent("android.intent.action.LoginActivity");
        startActivity(intentToLoginForm);
    }
}
