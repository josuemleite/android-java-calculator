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

    private int equalsCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        viewSetup();

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForOverwriting();
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "0");
            }
        });

        buttonUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForOverwriting();
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "1");
            }
        });

        buttonDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForOverwriting();
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "2");
            }
        });

        buttonTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForOverwriting();
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "3");
            }
        });

        buttonQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForOverwriting();
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "4");
            }
        });

        buttonCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForOverwriting();
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "5");
            }
        });

        buttonSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForOverwriting();
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "6");
            }
        });

        buttonSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForOverwriting();
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "7");
            }
        });

        buttonOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForOverwriting();
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "8");
            }
        });

        buttonNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForOverwriting();
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "9");
            }
        });

        buttonVirgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForOverwriting();
                exceedLength();
                String currentText = textViewResultado.getText().toString();
                if (currentText.length() == 0 || !Character.isDigit(currentText.charAt(currentText.length() - 1))) {
                    textViewResultado.setText(currentText + "0,");
                } else {
                    textViewResultado.setText(currentText + ",");
                }
            }
        });

        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "+");
                checkForOverwriting();
                expressionValidator();
            }
        });

        buttonSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "–");
                checkForOverwriting();
                expressionValidator();
            }
        });

        buttonMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "×");
                checkForOverwriting();
                firstOperand();
                expressionValidator();
            }
        });

        buttonDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "÷");
                checkForOverwriting();
                firstOperand();
                expressionValidator();
            }
        });

        buttonPorcento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textViewResultado.setText(textViewResultado.getText().toString() + "%");
                checkForOverwriting();
                firstOperand();
                expressionValidator();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableButtons();
                textViewResultado.setText("");
                textViewUltimaExpressao.setText("");
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                enableButtons();
                textViewResultado.setText(textViewResultado.getText().toString().length() > 1 ? textViewResultado.getText().toString().substring(0, textViewResultado.length() - 1) : "");
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableButtons();
                String expressao = textViewResultado.getText().toString().replace("–","-").replace("×","*").replace("÷","/").replace(",",".");

                // Verifica se a expressão termina com um operador
                if (expressao.matches(".*[-+*/]$")) {
                    return; // Sai do método sem executar o cálculo
                }

                Calculable avaliadorExpressao = null;
                try {
                    avaliadorExpressao = new ExpressionBuilder(expressao).build();
                    Double resultado = avaliadorExpressao.calculate();

                    // Format the result to display only one or two decimal places
                    String resultadoFormatado;
                    if (resultado == Math.floor(resultado)) {
                        resultadoFormatado = String.format("%.1f", resultado);
                    } else {
                        resultadoFormatado = String.format("%.2f", resultado);
                    }

                    // Display the expression and the result
                    textViewUltimaExpressao.setText(expressao.replace("-","–").replace("*","×").replace("/","÷").replace(".",","));
                    textViewResultado.setText(resultadoFormatado.replace(".",","));
                    equalsCount = 1;
                } catch (Exception e) {
                    // Clear the screen if an exception occurs while evaluating the expression
                    textViewResultado.setText("");
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

    public void firstOperand() {
        StringBuilder expression = new StringBuilder(textViewResultado.getText().toString().replace("–","-").replace("×","*").replace("÷","/").replace(",","."));

        char firstChar = expression.charAt(0);
        if (firstChar == '+' || firstChar == '-' || firstChar == '*' || firstChar == '/' || firstChar == '%') {
            clearTextView();
            return;
        }
    }

    public void expressionValidator() {
        StringBuilder expression = new StringBuilder(textViewResultado.getText().toString().replace("–","-").replace("×","*").replace("÷","/").replace(",","."));
        int length = expression.length();

        // Verifica se a expressão tem pelo menos dois caracteres
        if (length < 2) {
            return;
        }

        char penultimateChar = expression.charAt(length - 2);
        if (penultimateChar == '+' || penultimateChar == '-' || penultimateChar == '*' || penultimateChar == '/' || penultimateChar == '%') {
            expression.setCharAt(length - 2, expression.charAt(length - 1));
            expression.deleteCharAt(length - 1);
            textViewResultado.setText(expression.toString().replace("-","–").replace("*","×").replace("/","÷").replace(".",","));
        }
    }

    private void checkForOverwriting() {
        String expression = textViewResultado.getText().toString();
        int length = expression.length();

        if (length < 1) {
            return;
        }

        // Verifica se o último caractere digitado é um número
        if (Character.isDigit(expression.charAt(expression.length() - 1))) {

            // Verifica se o TextView contém o resultado de uma operação anterior
            if (equalsCount == 1 || expression.equals("0")) {
                equalsCount = 0;
                clearTextView();
            }
        }
    }

    private void clearTextView() {
        textViewResultado.setText("");
    }

    private void disableButtons() {
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

    private void enableButtons() {
        buttonZero.setEnabled(true);
        buttonVirgula.setEnabled(true);
        buttonUm.setEnabled(true);
        buttonDois.setEnabled(true);
        buttonTres.setEnabled(true);
        buttonQuatro.setEnabled(true);
        buttonCinco.setEnabled(true);
        buttonSeis.setEnabled(true);
        buttonSete.setEnabled(true);
        buttonOito.setEnabled(true);
        buttonNove.setEnabled(true);
        buttonSoma.setEnabled(true);
        buttonSubtracao.setEnabled(true);
        buttonMultiplicacao.setEnabled(true);
        buttonDivisao.setEnabled(true);
        buttonPorcento.setEnabled(true);
    }

    // Make text small if too many digits.
    private void exceedLength() {
        if (textViewResultado.getText().toString().length() > 10) {
            textViewResultado.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        }
        if (textViewResultado.getText().toString().length() > 16) {
            textViewResultado.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
        if (textViewResultado.getText().toString().length() > 32) {
            disableButtons();
        } else if (textViewResultado.getText().toString().length() <= 10) {
            textViewResultado.setTextSize(TypedValue.COMPLEX_UNIT_SP, 60);
        }
    }
}
