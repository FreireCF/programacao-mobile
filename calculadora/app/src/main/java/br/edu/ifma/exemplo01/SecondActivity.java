package br.edu.ifma.exemplo01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("Exemplo01","Activity2-onCreate");

        String param=getIntent().getStringExtra("parametro1");
        TextView textView = (TextView) findViewById(R.id.textView1);
        textView.setText(param);
    }

    public void clickButton2(View v){
        Log.d("Exemplo01","Activity2-Clicou botão voltar");
        super.onBackPressed();
        //super.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Exemplo01","Activity2-onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Exemplo01","Activity2-onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Exemplo01","Activity2-onResume");
    }
}