package com.ifsc.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActivity extends AppCompatActivity {

    String nome;
    Double peso, altura;
    TextView tvNome, tvPeso, tvAltura, tvIMC;
    DecimalFormat decimalFormat = new DecimalFormat("##,###,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Bundle bundle = getIntent().getExtras();
        nome = bundle.getString("nome");
        peso = bundle.getDouble("peso");
        altura = bundle.getDouble("altura");

        tvNome = findViewById(R.id.tvNome);
        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvIMC = findViewById(R.id.tvIMC);

    }

    @Override
    protected void onStart() {
        super.onStart();

        tvNome.setText(nome);
        tvPeso.setText(peso.toString());
        tvAltura.setText(altura.toString());
        tvIMC.setText(decimalFormat.format(calculaIMC(peso, altura)));

    }

    public Double calculaIMC(Double peso, Double altura){
        Double imc = peso/(altura*altura);
        return imc;
    }

}