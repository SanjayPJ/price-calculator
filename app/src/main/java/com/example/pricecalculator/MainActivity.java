package com.example.pricecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int total_amount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment_quantity(View view){
        quantity++;
        display_quantity(quantity);
    }

    public void decrement_quantity(View view){
        quantity--;
        display_quantity(quantity);
    }

    public void order(View view){
        total_amount = 10 * quantity;
        display_total_amount(total_amount);
    }

    private void display_total_amount(int total_amount){
        TextView totalAmountTextView = (TextView) findViewById(R.id.total_amount_text_view);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

//        totalAmountTextView.setText("Total : $" + Integer.toString(total_amount) + "\nThank you!!!!");
//        Toast.makeText(this, Boolean.toString(hasChocolate), Toast.LENGTH_SHORT).show();

        String order_summary = createOrderSummary(total_amount, hasWhippedCream, hasChocolate);
        totalAmountTextView.setText(order_summary);
    }

    private void display_quantity(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(Integer.toString(number));
    }

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: Lyla the Labyrinth";
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }
}