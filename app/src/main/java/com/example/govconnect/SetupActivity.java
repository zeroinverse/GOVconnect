package com.example.govconnect;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.govconnect.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetupActivity extends AppCompatActivity {

    private EditText userName, eMail;
    private CircleImageView profilePic;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        userName = (EditText) findViewById(R.id.setup_name);
        eMail = (EditText) findViewById(R.id.setup_email);
        save = (Button) findViewById(R.id.setup_button);
        profilePic = (CircleImageView) findViewById(R.id.setup_pic);
    }

}
