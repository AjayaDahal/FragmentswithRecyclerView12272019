package com.example.fragmentswithrecyclerview12272019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements personAdapter.ItemClicked {

    TextView tvName, tvPhone;
    EditText etName, etPhone;
    Button btnAddContact;
    ListFrag listFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvNumber);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etNumber);
        btnAddContact = findViewById(R.id.btnAddContact);

        fragmentManager = this.getSupportFragmentManager();
        listFrag = (ListFrag)fragmentManager.findFragmentById(R.id.listFrag);



        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    ApplicationClass.people.add(new Person(etName.getText().toString().trim(),etPhone.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Person added sucessful!", Toast.LENGTH_SHORT).show();
                    etName.setText(null);
                    etPhone.setText(null);
                    listFrag.notifyDataChange();
                }
            }
        });
        onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {
        tvName.setText(ApplicationClass.people.get(index).getName());
        tvPhone.setText(ApplicationClass.people.get(index).getTelNumber());
    }
}
