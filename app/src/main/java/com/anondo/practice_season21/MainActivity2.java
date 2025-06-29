package com.anondo.practice_season21;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView2;
    TextView textView2_1,getTextView2_2;
    FloatingActionButton fabButton;
    TextToSpeech textToSpeech;

    public static String TITLE="";
    public static String DESCRIPTION="";
    public static Bitmap my_Bitmap=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView2=findViewById(R.id.imageview2);
        textView2_1=findViewById(R.id.textView2_1);
        getTextView2_2=findViewById(R.id.textView2_2);
        fabButton=findViewById(R.id.fabButton);

        textView2_1.setText(TITLE);
        getTextView2_2.setText(DESCRIPTION);

        if (my_Bitmap!=null) imageView2.setImageBitmap(my_Bitmap);

        textToSpeech=new TextToSpeech(MainActivity2.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fabButton.getTag()!=null && fabButton.getTag().toString().contains("NOT_PLAYING")) {


                    String text = getTextView2_2.getText().toString();
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
                    fabButton.setImageResource(R.drawable.pause_icon);
                    fabButton.setTag("PLAYING");

                }
                else {
                    if (textToSpeech!=null) textToSpeech.stop();
                    fabButton.setImageResource(R.drawable.voice_icon);
                    fabButton.setTag("NOT_PLAYING");
                }




            }
        });


    }
/*
    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
    }
 */

    @Override
    public void onBackPressed() {

        if(textToSpeech!=null) {
            textToSpeech.stop();
        }

        super.onBackPressed();
    }


}