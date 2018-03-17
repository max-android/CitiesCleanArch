package com.myexamplemetcast.citiescleanarch.presentation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.myexamplemetcast.citiescleanarch.R;
import com.myexamplemetcast.citiescleanarch.data.repository.RepositoryProvider;
import com.myexamplemetcast.citiescleanarch.domain.model.Town;
import com.myexamplemetcast.citiescleanarch.domain.usecase.CitiesUseCase;
import com.myexamplemetcast.citiescleanarch.presentation.di.App;
import com.myexamplemetcast.citiescleanarch.presentation.general.Constants;
import com.myexamplemetcast.citiescleanarch.presentation.presenter.CitiesPresenter;
import com.myexamplemetcast.citiescleanarch.presentation.presenter.CitiesView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CitiesView {

       private EditText etLat;
       private EditText etLon;
       private Button btnStart;
       private CitiesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

    }


    private void initComponents(){

        App.getAppComponent().injectMainActivity(this);

       etLat =((TextInputLayout)findViewById(R.id.lat_input)).getEditText();
       etLon =((TextInputLayout)findViewById(R.id.lon_input)).getEditText();

        btnStart = (Button)findViewById(R.id.btnStart);

        btnStart.setOnClickListener(this::broadcastreceivingData);

    }


    private void broadcastreceivingData(View v){

        if (validateForm()) {

            RepositoryProvider repositoryProvider=new RepositoryProvider(etLat.getText().toString(),etLon.getText().toString());

          presenter = new CitiesPresenter(this, new CitiesUseCase(repositoryProvider.getCitiesRepository()));

            presenter.init();

        }else{
            showMessage(getString(R.string.fill_in_the_fields));
        }
    }


    private boolean validateForm() {
        boolean valid = true;

        if (TextUtils.isEmpty(etLat.getText().toString())) {
            etLat.setError("Required.");
            valid = false;
        } else {
            etLat.setError(null);
        }


        if (TextUtils.isEmpty(etLon.getText().toString())) {
            etLon.setError("Required.");
            valid = false;
        } else {
            etLon.setError(null);
        }
        return valid;
    }


    private void showMessage(String message){

        Toast.makeText(this,message, Toast.LENGTH_LONG).show();

    }


    private void launchListActivity(List<Town> towns){

        startActivity(new Intent(this,ListActivity.class).putExtra(Constants.KEY_DATA,new ArrayList<>(towns)));

    }


    @Override
    public void showCities(@NonNull List<Town> towns) {

        launchListActivity(towns);
    }

    @Override
    public void showError() {

        showMessage(getString(R.string.error));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.disposed();
    }



}
