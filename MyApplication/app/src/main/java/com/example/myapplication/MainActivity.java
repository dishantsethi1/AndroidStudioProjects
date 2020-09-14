package com.example.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TextView t=new TextView((this));
//        t.setText("Wow!");
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox=(CheckBox) findViewById(R.id.wipped_cream_checkbox);
        boolean hasWhippedCream=whippedCreamCheckbox.isChecked();
        CheckBox chocolateCheckbox=(CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate=chocolateCheckbox.isChecked();
        EditText nameText=(EditText) findViewById(R.id.name_field);
        String value=nameText.getText().toString();

        int price=calculatePrice(hasWhippedCream,hasChocolate);

        String priceMessage=createOrder(price,hasWhippedCream,hasChocolate,value);
        //displayMessage(priceMessage);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order for "+value);
        intent.putExtra(intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }
    public void increment(View view){

        quantity=quantity+1;
        if(quantity>100){ quantity=100;
        Toast.makeText(this,"not above 100 ",Toast.LENGTH_SHORT).show();}
        display(quantity);
    }
    public void decrement(View view){

        quantity=quantity-1;
        if(quantity<1){ quantity=1;
            Toast.makeText(this,"not below 1",Toast.LENGTH_SHORT).show();}
        display(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**
     * Calculates the price of the order.
     *
     *
     */
    private int calculatePrice(boolean wc,boolean choco) {
        int price = 5;
        if(wc==true) price+=1;
        if(choco==true) price+=2;
        price=price*quantity;
        return price;
    }
    private String createOrder(int price,boolean add,boolean choco,String name){
        String priceMessage="NAme : "+name+"\n";
        priceMessage+="Whipped Cream : "+add;
        priceMessage+="\nChocolate ? "+choco;
        priceMessage=priceMessage+"\nQuantity :"+quantity;

                priceMessage=priceMessage+"\nTotal: $"+price;
        priceMessage=priceMessage+"\nThank YOu!";

        return priceMessage;

    }
}