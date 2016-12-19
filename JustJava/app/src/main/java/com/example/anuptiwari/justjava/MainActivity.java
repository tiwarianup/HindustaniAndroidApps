package com.example.anuptiwari.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;
import static com.example.anuptiwari.justjava.R.id.quantity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String name;
    int orderPrice;
    int quantity = 1;
    int pricePerOne = 5;
    int chocolatePrice = 2;
    int whippedCreamPrice = 1;
    boolean hasCholocate = false;
    boolean hasWhippedCream = false;


    public void remove(View v) {
        TextView quanTextView = (TextView) findViewById(R.id.quantity);
        if (quantity == 1) {
            Context context = getApplicationContext();
            CharSequence text = "Hi, " + customerName() + " .You can't order less than a single coffee!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        } else {
            quantity = quantity - 1;
        }
        quanTextView.setText("" + quantity);
    }

    public void add(View v) {
        TextView quanTextView = (TextView) findViewById(R.id.quantity);
        if (quantity == 100) {
            Context context = getApplicationContext();
            CharSequence text = "Hi, " + customerName() + " .You can't order more than a 100 coffees!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        } else {
            quantity = quantity + 1;
        }
        quanTextView.setText("" + quantity);
    }

    public String customerName() {
        EditText personName = (EditText) findViewById(R.id.personName);
        name = personName.getText().toString();
        return name;
    }

    public void addWhippedCream(View v) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.ifWhippedCream);
        if (whippedCream.isChecked()) {
            hasWhippedCream = true;
        } else {
            hasWhippedCream = false;
        }
    }

    public void addChocolate(View v) {
        CheckBox chocolate = (CheckBox) findViewById(R.id.ifChocolate);
        if (chocolate.isChecked()) {
            hasCholocate = true;
        } else {
            hasCholocate = false;
        }
    }

    public void createOrderSummary(View v) {
        String custName = customerName();
        orderPrice = calculateOrderPrice(quantity, pricePerOne, whippedCreamPrice, chocolatePrice, hasWhippedCream, hasCholocate);
        String orderSummary = "Name: " + custName + "\nQuantity: " + quantity + "\nTotal: $" + orderPrice + "\nThank you!";
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setType("plain/text");
        sendIntent.setData(Uri.parse("anup.tiwari39@gmail.com"));
        sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"anup.tiwari39@gmail.com"});
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order for Customer: " + custName);
        sendIntent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        startActivity(sendIntent);
    }

    private int calculateOrderPrice(int quantity, int pricePerHead, int whippedCreamPrice, int chocolatePrice, boolean hasWhippedCream, boolean hasCholocate) {
        int orderPrice;
        if (hasWhippedCream && hasCholocate) {
            orderPrice = quantity * (pricePerHead + chocolatePrice + whippedCreamPrice);
        } else if (hasCholocate) {
            orderPrice = quantity * (pricePerHead + chocolatePrice);
        } else if (hasWhippedCream) {
            orderPrice = quantity * (pricePerHead + whippedCreamPrice);
        } else {
            orderPrice = quantity * pricePerHead;
        }
        return orderPrice;
    }
}
