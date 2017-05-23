package com.example.ariel.calculadoraandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cliqueBotao(View quemClicou){
        EditText operando1 = (EditText) findViewById(R.id.operando1);
        EditText operando2 = (EditText) findViewById(R.id.operando2);

        if(operando1.getText().toString().trim().equalsIgnoreCase("")){
            operando1.setError("o operando deve ser informado");
            return;
        }
        if(operando2.getText().toString().trim().equalsIgnoreCase("")){
            operando2.setError("o operando deve ser informado");
            return;
        }

        int op1= Integer.parseInt(operando1.getText().toString());
        int op2= Integer.parseInt(operando2.getText().toString());

        double resultado=0;

        RadioGroup rd_group = (RadioGroup) findViewById(R.id.rbOpcoes);
        switch (rd_group.getCheckedRadioButtonId()){
            case R.id.rbSoma:
                resultado = op1+op2;
                break;
            case R.id.rbSubtracao:
                resultado = op1-op2;
                break;
            case R.id.rbMultiplicacao:
                resultado = op1*op2;
                break;
            case R.id.rbDivisao:
                if(0 == op2){
                    Toast toast = Toast.makeText(this.getApplicationContext(), "o operando 2 tem que ser diferente de zero!", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
                resultado = op1/op2;
                break;
        }

        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        tvResultado.setText("res/values/strings.xml/resultado"+resultado);



    }

}
