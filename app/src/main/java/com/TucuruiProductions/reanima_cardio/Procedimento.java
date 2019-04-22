package com.TucuruiProductions.reanima_cardio;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Procedimento extends AppCompatActivity {

    // Declaram-se os cronometros (texto) autoexplicativos
    TextView temporizadorGeral;
    TextView temporizadorPulso;
    TextView temporizadorEpinefrina;
    TextView temporizadorDesfribilador;
    TextView temporizadorAntArritmico;
    // Declarm-se variáveis úteis para os cronometros autoexplicativo
    long tempoInicial=0L;
    long tempoParaAcao=0L;
    long checarPulso = (long) 2 * 1000 * 60;
    long darEpinefrina= (long) 3 * 1000 * 600;
    long aplicarDesfribilador= (long) 2 * 1000 * 60 ;
    long darAntiarritmico= (long) 3 * 1000 * 60;
    long tempoAtual=0L;

    // Rotina para criação de comunicação com a UI de thread no backgroung
    Handler periodico = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_tres);


        // inicia uma variável com o tempo de começo do código(possibilitando fácil reset).
        tempoInicial = SystemClock.uptimeMillis();

        // identifica contadores na UI
        temporizadorGeral = findViewById(R.id.Contador1);
        temporizadorPulso = findViewById(R.id.contador2);
        temporizadorEpinefrina = findViewById(R.id.contador3);
        temporizadorDesfribilador = findViewById(R.id.contador4);
        temporizadorAntArritmico = findViewById(R.id.contador5);


        // Chama a Thread para atualizar cronometros
        periodico.postDelayed(AtualizarCronometros, 0);
    }


    // Rotina para atualizar cronometros chamada periodicamente
    Runnable AtualizarCronometros = new Runnable() {
        @Override
        public void run() {

            // Cronometro geral (atualiza texto do cronometro geral)
            tempoAtual = SystemClock.uptimeMillis() - tempoInicial;   // Gera tempo atual do código, em Milisegundos
            // Processamento do tempo em unidades inteligíveis
            int secs = (int) (tempoAtual/1000);
            int mins = secs/60;
            int hrs = mins/60;
            secs%=60;
            // Atualização do texto com diferentes instancias dependendo do conteúdo
            if( hrs > 0){
                temporizadorGeral.setText(" " + hrs + " : " + String.format("%02d", mins) + " : " + String.format("%02d", secs));
            }else{
                temporizadorGeral.setText(" " + String.format("%02d", mins) + " : " + String.format("%02d", secs));
            }

            // Cronometro de checar pulso
            tempoParaAcao = checarPulso - tempoAtual;
            // Checar se não chagou a hora da ação
            if(tempoParaAcao < 0){
                checarPulso = checarPulso + 2 * 1000 * 60;                   // Se sim, atualizar tempo para a ação
            }
            // Processamento do tempo em unidades inteligíveis
            int secs2 = (int) (tempoParaAcao/1000) + 1;
            int mins2 = secs2/60;
            secs2%=60;
            // Atualização do texto com diferentes instancias dependendo do conteúdo
            temporizadorPulso.setText(" " + String.format("%02d", mins2) + ":" + String.format("%02d", secs2));

            // Cronometro epinefrina
            tempoParaAcao = darEpinefrina - tempoAtual;
            // Checar se não chagou a hora da ação
            if(tempoParaAcao < 0){
                darEpinefrina = darEpinefrina + 3 * 1000 * 60;                  // Se sim, atualizar tempo para a ação
            }
            // Processamento do tempo em unidades inteligíveis
            secs = (int) (tempoParaAcao/1000) + 1;
            mins = secs/60;
            secs%= 60;
            // Atualização do texto com diferentes instancias dependendo do conteúdo
            temporizadorEpinefrina.setText(" " + String.format("%02d", mins) + ":" + String.format("%02d", secs));

            // Cronometro desfribilador
            tempoParaAcao = aplicarDesfribilador - tempoAtual;
            // Checar se não chagou a hora da ação
            if(tempoParaAcao < 0){
                aplicarDesfribilador = aplicarDesfribilador + 2 * 1000 * 60;    // Se sim, atualizar tempo para a ação
            }
            // Processamento do tempo em unidades inteligíveis
            secs = (int) (tempoParaAcao/1000) + 1;
            mins = secs/60;
            secs%= 60;
            // Atualização do texto com diferentes instancias dependendo do conteúdo
            temporizadorDesfribilador.setText(" " + String.format("%02d", mins) + ":" + String.format("%02d", secs));


            // Cronometro antiarritmico
            tempoParaAcao = darAntiarritmico - tempoAtual;
            // Checar se não chagou a hora da ação
            if(tempoParaAcao < 0){
                darAntiarritmico = darAntiarritmico + 3 * 1000 * 60;      // Se sim, atualizar tempo para a ação
            }
            // Processamento do tempo em unidades inteligíveis
            secs = (int) (tempoParaAcao/1000) + 1;
            mins = secs/60;
            secs%= 60;
            // Atualização do texto com diferentes instancias dependendo do conteúdo
            temporizadorAntArritmico.setText(" " + String.format("%02d", mins) + ":" + String.format("%02d", secs));

            //Repetir
            periodico.postDelayed(this,0);

        }
    };





}
