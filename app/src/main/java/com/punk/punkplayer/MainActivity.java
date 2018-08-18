package com.punk.punkplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     EditText inputUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         inputUrl = (EditText) findViewById(R.id.et_input_url);
        Button startPlay = (Button) findViewById(R.id.btn_play);
        Button btn1 = (Button) findViewById(R.id.btn_one);
        Button btn2 = (Button) findViewById(R.id.btn_two);
        startPlay.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:
                Intent intent = new Intent(MainActivity.this,MediaPlayerActivity.class);
                intent.putExtra("videoUrl",inputUrl.getText().toString());
                startActivity(intent);
                break;
            case R.id.btn_one:
//https://www.fcw57.com/get_file/1/884b860fe73faffa410d23c1d457adfe028fc83971/21000/21030/21030.mp4
               inputUrl.setText("https://media1.fcw67.com/remote_control.php?time=1533383650&cv=d8245dcb441085a90345fa02d9378a8b&lr=0&cv2=263896c7a0190b1de44db49b56ed8050&file=%2Fvideos%2F21000%2F21030%2F21030.mp4&cv3=6668a556364b2301f0e6af7744f20e10");
                break;
            case R.id.btn_two:

                inputUrl.setText("https://www.fcw57.com/get_file/1/f41ab1f4a4d730ae0fde38c25f7f6d88cce9a1886c/21000/21030/21030.mp4/?download=true&amp;download_filename=21f624114b0311c6226d3b3072d082cc.mp4");
                break;
        }
    }
}
