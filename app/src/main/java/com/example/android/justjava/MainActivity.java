/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;
    String message = "You total due is: $";
    int pricePerCup = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        boolean hasWippedCream =((CheckBox) findViewById(R.id.whipped_cream_box)).isChecked();
        boolean hasChocolate = ((CheckBox) findViewById(R.id.chocolate_box)).isChecked();
        //String nameClient = ((EditText) findViewById(R.id.input_name)).getText().toString();
        String name = getName();
        displayMessage(createOrderSummary(price, name, quantity, hasWippedCream, hasChocolate));
    }


    /**
     * @param summary calculated price
     * @return
     */
    private void displayMessage(String summary) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(summary);
    }

    /**
     * @param price    total price
     * @param name           of the client
     * @param quantity of ordered cups
     * @return summary of order
     */

    private String createOrderSummary(int price, String name, int quantity,
                                      boolean whipped, boolean chocolate) {
        String textSummary;

        if (whipped && chocolate) {
            textSummary = "Name: " + name + "\nTopping: Whipped Cream" + "\nToppings: Chocolate"
                    + "\nQuantity: " + quantity
                    + "\nTotal Price: $" + price + "\nThank you!";
        }
        else if (chocolate) {
            textSummary = "Name: " + name + "\nToppings: Chocolate" + "\nQuantity: " + quantity
                    + "\nTotal Price: $" + price + "\nThank you!";
        }
        else if (whipped) {
            textSummary = "Name: " + name + "\nToppings: Whipped Cream" + "\nQuantity: " + quantity
                    + "\nTotal Price: $" + price + "\nThank you!";
        }
        else {
            textSummary = "Name: " + name + "\nQuantity: " + quantity
                    + "\nTotal Price: $" + price + "\nThank you!";
        }
            return textSummary;

    }
    private String getName() {
        String nameClient = ((EditText) findViewById(R.id.input_name)).getText().toString();
        if (!nameClient.equals("")) {
            return nameClient;
        }
        else {
            nameClient = "Phil Djambazoff";
            return nameClient;
        }
    }


    /**
     * @return total price
     */
    private int calculatePrice() {
        return quantity * pricePerCup;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * @param view xml view id
     */
    public void increase(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * @param view xml view id
     */
    public void decrease(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

}
