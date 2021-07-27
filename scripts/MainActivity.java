package com.example.wakeonlan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText IpAd, macAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IpAd = (EditText) findViewById(R.id.IpAd);
        macAd = (EditText) findViewById(R.id.macAd);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ip = IpAd.getText().toString();
                final String mac = macAd.getText().toString();

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            WakeOnLan.main(new String[]{ip, mac });
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });
    }
}