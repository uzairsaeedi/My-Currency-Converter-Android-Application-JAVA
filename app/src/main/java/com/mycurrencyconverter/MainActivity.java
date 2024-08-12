package com.mycurrencyconverter;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText edt_amount;
    private Spinner spinner_from;
    private Spinner spinner_to;
    private Button btn_convert,btn_history;
    private TextView tv_result;
    DatabaseHandler databaseHandler = new DatabaseHandler(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_amount = findViewById(R.id.edt_amount);
        spinner_from = findViewById(R.id.spinnerFrom);
        spinner_to = findViewById(R.id.spinnerTo);
        btn_convert = findViewById(R.id.btn_convert);
        tv_result = findViewById(R.id.tv_result);
        btn_history = findViewById(R.id.btn_history);


        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, History.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> currencyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getCurrencyCodes());
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_to.setAdapter(currencyAdapter);
        spinner_from.setAdapter(currencyAdapter);

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double tot = null;
                double amount = Double.parseDouble(edt_amount.getText().toString());

                if((spinner_from.getSelectedItem().toString() == "USD") && (spinner_to.getSelectedItem().toString() == "INR")) {
                    tot = amount * 83.23;
                    tv_result.setText(tot.toString());
                }else if((spinner_from.getSelectedItem().toString() == "USD") && (spinner_to.getSelectedItem().toString() == "USD")) {
                    tot = amount * 1;
                    tv_result.setText(tot.toString());
                }

                else if(spinner_from.getSelectedItem().toString() == "USD" && spinner_to.getSelectedItem().toString() == "EUR")
                {
                    tot=amount*0.95;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "USD" && spinner_to.getSelectedItem().toString() == "GBP")
                {
                    tot=amount*0.83;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "USD" && spinner_to.getSelectedItem().toString() == "JPY")
                {
                    tot=amount*150.40;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "USD" && spinner_to.getSelectedItem().toString() == "CAD")
                {
                    tot=amount*1.38;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "USD" && spinner_to.getSelectedItem().toString() == "AUD")
                {
                    tot=amount*1.59;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "USD" && spinner_to.getSelectedItem().toString() == "CHF")
                {
                    tot=amount*0.90;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "USD" && spinner_to.getSelectedItem().toString() == "CNY")
                {
                    tot=amount*7.32;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "USD" && spinner_to.getSelectedItem().toString() == "INR")
                {
                    tot=amount*83.24;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "USD" && spinner_to.getSelectedItem().toString() == "PKR")
                {
                    tot=amount*280.17;
                    tv_result.setText(tot.toString());
                }
                if(spinner_from.getSelectedItem().toString() == "EUR" && spinner_to.getSelectedItem().toString() == "USD")
                {
                    tot=amount*1.05;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "EUR" && spinner_to.getSelectedItem().toString() == "GBP")
                {
                    tot=amount*0.87;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "EUR" && spinner_to.getSelectedItem().toString() == "EUR")
                {
                    tot=amount*1;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "EUR" && spinner_to.getSelectedItem().toString() == "JPY")
                {
                    tot=amount*158.44;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "EUR" && spinner_to.getSelectedItem().toString() == "CAD")
                {
                    tot=amount*1.46;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "EUR" && spinner_to.getSelectedItem().toString() == "AUD")
                {
                    tot=amount*1.67;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "EUR" && spinner_to.getSelectedItem().toString() == "CHF")
                {
                    tot=amount*0.95;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "EUR" && spinner_to.getSelectedItem().toString() == "CNY")
                {
                    tot=amount*7.72;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "EUR" && spinner_to.getSelectedItem().toString() == "INR")
                {
                    tot=amount*87.83;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "EUR" && spinner_to.getSelectedItem().toString() == "PKR")
                {
                    tot=amount*295.44;
                    tv_result.setText(tot.toString());
                }
                if(spinner_from.getSelectedItem().toString() == "GBP" && spinner_to.getSelectedItem().toString() == "USD")
                {
                    tot=amount*1.21;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "GBP" && spinner_to.getSelectedItem().toString() == "EUR")
                {
                    tot=amount*1.15;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "GBP" && spinner_to.getSelectedItem().toString() == "GBP")
                {
                    tot=amount*1;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "GBP" && spinner_to.getSelectedItem().toString() == "JPY")
                {
                    tot=amount*181.93;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "GBP" && spinner_to.getSelectedItem().toString() == "CAD")
                {
                    tot=amount*1.67;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "GBP" && spinner_to.getSelectedItem().toString() == "AUD")
                {
                    tot=amount*1.92;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "GBP" && spinner_to.getSelectedItem().toString() == "CHF")
                {
                    tot=amount*1.09;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "GBP" && spinner_to.getSelectedItem().toString() == "CNY")
                {
                    tot=amount*8.86;
                    tv_result.setText(tot.toString());
                }else if(spinner_from.getSelectedItem().toString() == "GBP" && spinner_to.getSelectedItem().toString() == "INR")
                {
                    tot=amount*100.84;
                    tv_result.setText(tot.toString());
                }  else if(spinner_from.getSelectedItem().toString() == "GBP" && spinner_to.getSelectedItem().toString() == "PKR")
                {
                    tot=amount*339.23;
                    tv_result.setText(tot.toString());
                }
                if(spinner_from.getSelectedItem().toString() == "JPY" && spinner_to.getSelectedItem().toString() == "USD")
                {
                    tot=amount*0.0067;
                    tv_result.setText(tot.toString());
                }else if(spinner_from.getSelectedItem().toString() == "JPY" && spinner_to.getSelectedItem().toString() == "EUR")
                {
                    tot=amount*0.0063;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "JPY" && spinner_to.getSelectedItem().toString() == "GBP")
                {
                    tot=amount*0.0055;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "JPY" && spinner_to.getSelectedItem().toString() == "JPY")
                {
                    tot=amount*1;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "JPY" && spinner_to.getSelectedItem().toString() == "CAD")
                {
                    tot=amount*0.0092;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "JPY" && spinner_to.getSelectedItem().toString() == "AUD")
                {
                    tot=amount*0.011;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "JPY" && spinner_to.getSelectedItem().toString() == "CHF")
                {
                    tot=amount*0.0060;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "JPY" && spinner_to.getSelectedItem().toString() == "CNY")
                {
                    tot=amount*0.048;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "JPY" && spinner_to.getSelectedItem().toString() == "INR")
                {
                    tot=amount*0.55;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "JPY" && spinner_to.getSelectedItem().toString() == "PKR")
                {
                    tot=amount*1.86;
                    tv_result.setText(tot.toString());
                }
                if(spinner_from.getSelectedItem().toString() == "CAD" && spinner_to.getSelectedItem().toString() == "USD")
                {
                    tot=amount*0.72;
                    tv_result.setText(tot.toString());
                }else if(spinner_from.getSelectedItem().toString() == "CAD" && spinner_to.getSelectedItem().toString() == "EUR")
                {
                    tot=amount*0.69;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CAD" && spinner_to.getSelectedItem().toString() == "GBP")
                {
                    tot=amount*0.60;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CAD" && spinner_to.getSelectedItem().toString() == "JPY")
                {
                    tot=amount*108.81;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CAD" && spinner_to.getSelectedItem().toString() == "CAD")
                {
                    tot=amount*1;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CAD" && spinner_to.getSelectedItem().toString() == "AUD")
                {
                    tot=amount*1.15;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CAD" && spinner_to.getSelectedItem().toString() == "CHF")
                {
                    tot=amount*0.65;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "CAD" && spinner_to.getSelectedItem().toString() == "CNY")
                {
                    tot=amount*5.30;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "CAD" && spinner_to.getSelectedItem().toString() == "INR")
                {
                    tot=amount*60.25;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "CAD" && spinner_to.getSelectedItem().toString() == "PKR")
                {
                    tot=amount*202.81;
                    tv_result.setText(tot.toString());
                }
                if(spinner_from.getSelectedItem().toString() == "AUD" && spinner_to.getSelectedItem().toString() == "USD")
                {
                    tot=amount*0.63;
                    tv_result.setText(tot.toString());
                }else if(spinner_from.getSelectedItem().toString() == "AUD" && spinner_to.getSelectedItem().toString() == "EUR")
                {
                    tot=amount*0.60;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "AUD" && spinner_to.getSelectedItem().toString() == "GBP")
                {
                    tot=amount*0.52;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "AUD" && spinner_to.getSelectedItem().toString() == "JPY")
                {
                    tot=amount*94.91;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "AUD" && spinner_to.getSelectedItem().toString() == "CAD")
                {
                    tot=amount*0.87;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "AUD" && spinner_to.getSelectedItem().toString() == "AUD")
                {
                    tot=amount*1;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "AUD" && spinner_to.getSelectedItem().toString() == "CHF")
                {
                    tot=amount*0.57;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "AUD" && spinner_to.getSelectedItem().toString() == "CNY")
                {
                    tot=amount*4.62;
                    tv_result.setText(tot.toString());
                }else if(spinner_from.getSelectedItem().toString() == "AUD" && spinner_to.getSelectedItem().toString() == "INR")
                {
                    tot=amount*52.60;
                    tv_result.setText(tot.toString());
                }  else if(spinner_from.getSelectedItem().toString() == "AUD" && spinner_to.getSelectedItem().toString() == "PKR")
                {
                    tot=amount*177.0;
                    tv_result.setText(tot.toString());
                }
                if(spinner_from.getSelectedItem().toString() == "CHF" && spinner_to.getSelectedItem().toString() == "USD")
                {
                    tot=amount*1.11;
                    tv_result.setText(tot.toString());
                }else if(spinner_from.getSelectedItem().toString() == "VHF" && spinner_to.getSelectedItem().toString() == "EUR")
                {
                    tot=amount*1.06;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CHF" && spinner_to.getSelectedItem().toString() == "GBP")
                {
                    tot=amount*0.92;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CHF" && spinner_to.getSelectedItem().toString() == "JPY")
                {
                    tot=amount*167.33;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CHF" && spinner_to.getSelectedItem().toString() == "CAD")
                {
                    tot=amount*1.54;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CHF" && spinner_to.getSelectedItem().toString() == "AUD")
                {
                    tot=amount*1.76;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CHF" && spinner_to.getSelectedItem().toString() == "CHF")
                {
                    tot=amount*1;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "CHF" && spinner_to.getSelectedItem().toString() == "CNY")
                {
                    tot=amount*8.16;
                    tv_result.setText(tot.toString());
                }else if(spinner_from.getSelectedItem().toString() == "CHF" && spinner_to.getSelectedItem().toString() == "INR")
                {
                    tot=amount*92.74;
                    tv_result.setText(tot.toString());
                }  else if(spinner_from.getSelectedItem().toString() == "CHF" && spinner_to.getSelectedItem().toString() == "PKR")
                {
                    tot=amount*311.70;
                    tv_result.setText(tot.toString());
                }
                if(spinner_from.getSelectedItem().toString() == "CNY" && spinner_to.getSelectedItem().toString() == "USD")
                {
                    tot=amount*0.14;
                    tv_result.setText(tot.toString());
                }else if(spinner_from.getSelectedItem().toString() == "CNY" && spinner_to.getSelectedItem().toString() == "EUR")
                {
                    tot=amount*0.13;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CNY" && spinner_to.getSelectedItem().toString() == "GBP")
                {
                    tot=amount*0.11;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CNY" && spinner_to.getSelectedItem().toString() == "JPY")
                {
                    tot=amount*20.97;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CNY" && spinner_to.getSelectedItem().toString() == "CAD")
                {
                    tot=amount*0.19;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CNY" && spinner_to.getSelectedItem().toString() == "AUD")
                {
                    tot=amount*0.22;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "CNY" && spinner_to.getSelectedItem().toString() == "CHF")
                {
                    tot=amount*0.12;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "CNY" && spinner_to.getSelectedItem().toString() == "CNY")
                {
                    tot=amount*1;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "CNY" && spinner_to.getSelectedItem().toString() == "INR")
                {
                    tot=amount*11.46;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "CNY" && spinner_to.getSelectedItem().toString() == "PKR")
                {
                    tot=amount*38.29;
                    tv_result.setText(tot.toString());
                }
                if(spinner_from.getSelectedItem().toString() == "INR" && spinner_to.getSelectedItem().toString() == "USD")
                {
                    tot=amount*0.012;
                    tv_result.setText(tot.toString());
                }else if(spinner_from.getSelectedItem().toString() == "INR" && spinner_to.getSelectedItem().toString() == "EUR")
                {
                    tot=amount*0.011;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "INR" && spinner_to.getSelectedItem().toString() == "GBP")
                {
                    tot=amount*0.0099;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "INR" && spinner_to.getSelectedItem().toString() == "JPY")
                {
                    tot=amount*1.80;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "INR" && spinner_to.getSelectedItem().toString() == "CAD")
                {
                    tot=amount*0.017;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "INR" && spinner_to.getSelectedItem().toString() == "AUD")
                {
                    tot=amount*0.019;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "INR" && spinner_to.getSelectedItem().toString() == "CHF")
                {
                    tot=amount*0.011;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "INR" && spinner_to.getSelectedItem().toString() == "CNY")
                {
                    tot=amount*0.088;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "INR" && spinner_to.getSelectedItem().toString() == "INR")
                {
                    tot=amount*1;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "INR" && spinner_to.getSelectedItem().toString() == "PKR")
                {
                    tot=amount*3.37;
                    tv_result.setText(tot.toString());
                }if(spinner_from.getSelectedItem().toString() == "PKR" && spinner_to.getSelectedItem().toString() == "USD")
                {
                    tot=amount*0.0036;
                    tv_result.setText(tot.toString());
                }else if(spinner_from.getSelectedItem().toString() == "PKR" && spinner_to.getSelectedItem().toString() == "EUR")
                {
                    tot=amount*0.0034;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "PKR" && spinner_to.getSelectedItem().toString() == "GBP")
                {
                    tot=amount*0.0029;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "PKR" && spinner_to.getSelectedItem().toString() == "JPY")
                {
                    tot=amount*0.54;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "PKR" && spinner_to.getSelectedItem().toString() == "CAD")
                {
                    tot=amount*0.0049;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "PKR" && spinner_to.getSelectedItem().toString() == "AUD")
                {
                    tot=amount*0.0057;
                    tv_result.setText(tot.toString());
                }
                else if(spinner_from.getSelectedItem().toString() == "PKR" && spinner_to.getSelectedItem().toString() == "CHF")
                {
                    tot=amount*0.0032;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "PKR" && spinner_to.getSelectedItem().toString() == "CNY")
                {
                    tot=amount*0.026;
                    tv_result.setText(tot.toString());
                }else if(spinner_from.getSelectedItem().toString() == "PKR" && spinner_to.getSelectedItem().toString() == "INR")
                {
                    tot=amount*0.30;
                    tv_result.setText(tot.toString());
                } else if(spinner_from.getSelectedItem().toString() == "PKR" && spinner_to.getSelectedItem().toString() == "PKR")
                {
                    tot=amount*1;
                    tv_result.setText(tot.toString());
                }
                insertConversionHistory(
                        spinner_from.getSelectedItem().toString(),
                        spinner_to.getSelectedItem().toString(),
                        amount,
                        tot
                );




            }
        });
    }
    private String[] getCurrencyCodes() {
        return new String[]{"USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY", "INR", "PKR"};
    }
    private void insertConversionHistory(String fromCurrency, String toCurrency, double amount, double result) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.COLUMN_FROM_CURRENCY, fromCurrency);
        values.put(DatabaseHandler.COLUMN_TO_CURRENCY, toCurrency);
        values.put(DatabaseHandler.COLUMN_AMOUNT, amount);
        values.put(DatabaseHandler.COLUMN_RESULT, result);
        db.insert(DatabaseHandler.TABLE_NAME, null, values);
        db.close();
    }

}











