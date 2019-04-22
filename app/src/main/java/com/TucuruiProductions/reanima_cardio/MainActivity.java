package com.TucuruiProductions.reanima_cardio;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.LayoutDirection;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity {
    ImageButton ImageButtonInitiate;
    ImageButton ImageButtonInformation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botão da tela inicial para iniciar procedimento
        ImageButtonInitiate = findViewById(R.id.Initiate);
        // Botão da tela inicial para se ter informações (Desenvolvedores, instituições responsáveis, etc...)
        ImageButtonInformation = findViewById(R.id.Information);
        // Tutorial (ainda falta o botão). Mostra o processo de reanimação passo a passo.




        // Ações dos botões
        ImageButtonInitiate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityConfirma();
            }
        });

    }

    public void openActivityConfirma(){
        Intent intent = new Intent(this, confirma.class);
        startActivity(intent);
    }



}
