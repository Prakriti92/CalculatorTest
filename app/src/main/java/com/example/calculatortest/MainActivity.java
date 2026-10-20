package com.example.calculatortest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    EditText initialPrice;
    EditText tax;
    EditText fullPrice;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initialPrice = findViewById(R.id.InitialPrice);
        tax = findViewById(R.id.Tax);
        fullPrice = findViewById(R.id.Result);
        calculate = findViewById(R.id.Calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                float price = Float.parseFloat(initialPrice.getText().toString());
                float taxRate = Float.parseFloat(tax.getText().toString());
                float taxAmount = price * taxRate / 100;
                float total = price + taxAmount;
                fullPrice.setText(String.valueOf(total));

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}