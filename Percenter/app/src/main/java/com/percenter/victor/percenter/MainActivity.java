package com.percenter.victor.percenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText editText;
    TextView gorjetaTv;
    TextView percentLb;
    SeekBar percentSb;
    TextView totalTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        gorjetaTv = (TextView) findViewById(R.id.gorjetaBar);
        percentLb = (TextView) findViewById(R.id.percentLb);
        percentSb = (SeekBar) findViewById(R.id.percentBar);
        totalTv = (TextView) findViewById(R.id.totalBar);
        createListeners();
    }

    private void createListeners()
    {
        editText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                calcularValores();
            }

            @Override
            public void afterTextChanged(Editable s){}
        });

        percentSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                calcularValores();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar){}
        });
    }

    private void calcularValores()
    {
        try
        {
            double valor = Double.parseDouble(editText.getText().toString());
            double valorGorjeta = (percentSb.getProgress() * valor) / 100;
            percentLb.setText(percentSb.getProgress() + "%");
            gorjetaTv.setText(valorGorjeta + "");
            totalTv.setText(valor + valorGorjeta + "");
        } catch (Exception e){}
    }
}
