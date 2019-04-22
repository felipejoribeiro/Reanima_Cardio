package com.TucuruiProductions.reanima_cardio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class confirma extends AppCompatActivity {

    Button ImageButtonCancel;
    Button ImageButtonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm);

        // Botão para cancelar o protocolo de atendimento. (volta)
        ImageButtonCancel = findViewById(R.id.cancel_button);
        // Botão para confirmar o protocolo. (prossegue para a tela 3)
        ImageButtonConfirm = findViewById(R.id.confirm_button);


        // Ações dos botões
        ImageButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoltarTelaInicial();
            }
        });
        ImageButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IniciarProcedimento();
            }
        });


    }


    public void VoltarTelaInicial(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void IniciarProcedimento(){
        Intent intent = new Intent(this, Procedimento.class);
        startActivity(intent);
    }
}
