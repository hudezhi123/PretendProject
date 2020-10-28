package com.hdz.pretendproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hdz.pretendproject.R;


public class IpFileGetActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgBack;
    TextView textAccount;
    EditText editAmount;
    EditText editKey;
    EditText editCode;
    TextView textSendCode;
    ImageView imgScan;
    Button btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_file_get);
        init();
    }

    private void init() {
        textAccount = findViewById(R.id.text_account_file_coin);
        editAmount = findViewById(R.id.edit_can_use_file_coin);
        editKey = findViewById(R.id.edit_key_file_coin);
        editCode = findViewById(R.id.edit_auth_code_file_coin);
        imgScan = findViewById(R.id.img_scan_file_coin);
        textSendCode = findViewById(R.id.text_send_code_file_coin);
        btnGet = findViewById(R.id.btn_get_file_coin);
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.text_send_code_file_coin:
                sendSmsCode();
                break;
            case R.id.btn_get_file_coin:
                getFileCoin();
                break;
            case R.id.img_scan_file_coin:
                scanCode();
                break;
        }
    }

    private void sendSmsCode(){

    }

    private void scanCode(){

    }

    private void getFileCoin(){

    }
}
