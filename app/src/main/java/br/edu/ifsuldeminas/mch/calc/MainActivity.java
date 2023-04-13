package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ifsuldeminas.mch.calc";

    private Button buttonZero;
    private Button buttonVirgula;
    private Button buttonIgual;
    private Button buttonUm;
    private Button buttonDois;
    private Button buttonTres;
    private Button buttonQuatro;
    private Button buttonCinco;
    private Button buttonSeis;
    private Button buttonSete;
    private Button buttonOito;
    private Button buttonNove;
    private Button buttonSoma;
    private Button buttonSubtracao;
    private Button buttonMultiplicacao;
    private Button buttonDivisao;
    private Button buttonPorcento;
    private Button buttonReset;
    private Button buttonDelete;

    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "0");
            }
        });

        buttonUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "1");
            }
        });

        buttonDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "2");
            }
        });

        buttonTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "3");
            }
        });

        buttonQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "4");
            }
        });

        buttonCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "5");
            }
        });

        buttonSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "6");
            }
        });

        buttonSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "7");
            }
        });

        buttonOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "8");
            }
        });

        buttonNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "9");
            }
        });

        buttonVirgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + ",");
            }
        });

        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "+");
            }
        });

        buttonSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "–");
            }
        });

        buttonMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "×");
            }
        });

        buttonDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "÷");
            }
        });

        buttonPorcento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "%");
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewResultado.setText("");
                textViewUltimaExpressao.setText("");
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString().substring(0, textViewResultado.length() - 1));
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculable avaliadorExpressao = null;
                try {
                    String expressao = textViewResultado.getText().toString().replaceAll("–","-").replaceAll("×","*").replaceAll("÷","/").replaceAll(",",".");

                    avaliadorExpressao = new ExpressionBuilder(expressao).build();

                    Double resultado = avaliadorExpressao.calculate();

                    textViewUltimaExpressao.setText(expressao.replaceAll("-","–").replaceAll("\\*","×").replaceAll("/","÷").replaceAll("\\.",","));
                    textViewResultado.setText(String.format("%.2f", resultado).replaceAll("\\.",","));
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
    }

    public void viewSetup() {
        buttonZero = findViewById(R.id.buttonZeroID);
        buttonVirgula = findViewById(R.id.buttonVirgulaID);
        buttonIgual = findViewById(R.id.buttonIgualID);
        buttonUm = findViewById(R.id.buttonUmID);
        buttonDois = findViewById(R.id.buttonDoisID);
        buttonTres = findViewById(R.id.buttonTresID);
        buttonQuatro = findViewById(R.id.buttonQuatroID);
        buttonCinco = findViewById(R.id.buttonCincoID);
        buttonSeis = findViewById(R.id.buttonSeisID);
        buttonSete = findViewById(R.id.buttonSeteID);
        buttonOito = findViewById(R.id.buttonOitoID);
        buttonNove = findViewById(R.id.buttonNoveID);
        buttonSoma = findViewById(R.id.buttonSomaID);
        buttonSubtracao = findViewById(R.id.buttonSubtracaoID);
        buttonMultiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        buttonDivisao = findViewById(R.id.buttonDivisaoID);
        buttonPorcento = findViewById(R.id.buttonPorcentoID);
        buttonReset = findViewById(R.id.buttonResetID);
        buttonDelete = findViewById(R.id.buttonDeleteID);

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);
    }

    // Transform symbols to calculate
//    public String dataFormat(String data) {
//        data.replaceAll("-","–");
//        data.replaceAll("\\*","×");
//        data.replaceAll("\\/","÷");
//        data.replaceAll(".",",");
//        return data;
//    }

    // Make text small if too many digits.
    private void exceedLength() {
        if (textViewResultado.getText().toString().length() > 10) {
            textViewResultado.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        }
        if (textViewResultado.getText().toString().length() > 16) {
            textViewResultado.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
        if (textViewResultado.getText().toString().length() > 32) {
            buttonZero.setEnabled(false);
            buttonVirgula.setEnabled(false);
            buttonUm.setEnabled(false);
            buttonDois.setEnabled(false);
            buttonTres.setEnabled(false);
            buttonQuatro.setEnabled(false);
            buttonCinco.setEnabled(false);
            buttonSeis.setEnabled(false);
            buttonSete.setEnabled(false);
            buttonOito.setEnabled(false);
            buttonNove.setEnabled(false);
            buttonSoma.setEnabled(false);
            buttonSubtracao.setEnabled(false);
            buttonMultiplicacao.setEnabled(false);
            buttonDivisao.setEnabled(false);
            buttonPorcento.setEnabled(false);
        }
    }
}