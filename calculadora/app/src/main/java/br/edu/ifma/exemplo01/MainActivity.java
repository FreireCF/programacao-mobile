package br.edu.ifma.exemplo01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView numberDisplay;
    private String numAtual;
    private String numAnterior;
    private String operacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Calculadora","Activity1-onCreate");
        setContentView(R.layout.activity_main);

        numberDisplay = findViewById(R.id.numberDisplay);

        Button buttonZero = findViewById(R.id.buttonZero);
        Button buttonOne = findViewById(R.id.buttonOne);
        Button buttonTwo = findViewById(R.id.buttonTwo);
        Button buttonThree = findViewById(R.id.buttonThree);
        Button buttonFour = findViewById(R.id.buttonFour);
        Button buttonFive = findViewById(R.id.buttonFive);
        Button buttonSix = findViewById(R.id.buttonSix);
        Button buttonSeven = findViewById(R.id.buttonSeven);
        Button buttonEight = findViewById(R.id.buttonEight);
        Button buttonNine = findViewById(R.id.buttonNine);

        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonResult = findViewById(R.id.buttonResult);

    View.OnClickListener numberClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            var botao = (Button) v;
            numAtual = botao.getText().toString();
            numberDisplay.setText(numAtual);
        }
    };
        buttonZero.setOnClickListener(numberClickListener);
        buttonOne.setOnClickListener(numberClickListener);
        buttonTwo.setOnClickListener(numberClickListener);
        buttonThree.setOnClickListener(numberClickListener);
        buttonFour.setOnClickListener(numberClickListener);
        buttonFive.setOnClickListener(numberClickListener);
        buttonSix.setOnClickListener(numberClickListener);
        buttonSeven.setOnClickListener(numberClickListener);
        buttonEight.setOnClickListener(numberClickListener);
        buttonNine.setOnClickListener(numberClickListener);

        buttonPlus.setOnClickListener(v -> setOperacao("+"));
        buttonMinus.setOnClickListener(v -> setOperacao("-"));
        buttonMultiply.setOnClickListener(v -> setOperacao("x"));
        buttonDivide.setOnClickListener(v -> setOperacao("/"));

        buttonResult.setOnClickListener(v -> calcular());
}
    private void setOperacao(String op) {
        if (!numAtual.isEmpty()) {
            numAnterior = numAtual;
            operacao = op;
            numAtual = "";
        }
    }
    public void calcular() {
        if (numAnterior.isEmpty() || numAtual.isEmpty()) return;

        double num1 = Double.parseDouble(numAnterior);
        double num2 = Double.parseDouble(numAtual);
        double resultado;

        switch (operacao){
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "x":
                resultado = num1 * num2;
                break;
            case "/":
                resultado = (num2!=0) ? (num1/num2) : Double.NaN;
                break;
            default:
                resultado = 0;
                break;
        }
        if (resultado == (long) resultado) {
            numAtual = String.valueOf((long) resultado);
        } else {
            numAtual = String.valueOf(resultado);
        }

        numberDisplay.setText(numAtual);
        numAnterior = "";
        operacao = "";
    }


    public void clickButton1(View v){
        Log.d("Calculadora","Activity1-Clicou botão proximo");
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Calculadora","Activity1-onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Calculadora","Activity1-onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Calculadora","Activity1-onResume");
        }
}