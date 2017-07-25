package com.jx372.implictinent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this); //onClick method 구현된 글레스값을 매개변수로 넣어주어야 함
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        System.out.println("---------------------------->" + viewId);

        switch (viewId) {
            case R.id.button: {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel: 010-4444-4444"));

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Log.e("MainActivity", "Call Permission denied");
                    return;
                }

                startActivity(intent);
                break;
            }
            case R.id.button2: {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.naver.com"));
                startActivity(intent);
                break;
            }
            case R.id.button3: {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:38.899533,-77.036476"));
                startActivity(intent);
                break;
            }
            case R.id.button4:{
                Intent intent = new Intent("com.jx372.android.action.SHARE_ACTION");
                startActivity(intent);
                break;
            }
            default:
                break;
        }
    }
}
