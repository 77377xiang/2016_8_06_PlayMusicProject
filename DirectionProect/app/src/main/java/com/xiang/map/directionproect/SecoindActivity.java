package com.xiang.map.directionproect;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/6.
 */
public class SecoindActivity extends Activity implements View.OnClickListener{
    Button paly;
    Button pause;
    Button stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        paly= (Button) findViewById(R.id.play);
        pause= (Button) findViewById(R.id.pause);
        stop= (Button) findViewById(R.id.stop);
        paly.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.play :
                Toast.makeText(SecoindActivity.this,"sss",Toast.LENGTH_LONG).show();
                MyPlayer. playTone(this,0);

            break;
            case  R.id.pause :
                MyPlayer.stopTheTone(this,0);
                break;
            case  R.id.stop :
                break;
        }
    }
}
