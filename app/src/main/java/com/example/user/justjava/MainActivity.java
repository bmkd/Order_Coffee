package com.example.user.justjava;

         import android.content.Intent;
         import android.net.Uri;
         import android.os.Bundle;
         import android.support.v7.app.AppCompatActivity;
         import android.util.Log;
         import android.view.View;
         import android.widget.CheckBox;
         import android.widget.EditText;
         import android.widget.TextView;
         import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int noofcoffee=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price=20;
      if(noofcoffee!=0)
      { CheckBox whippedcreamcheckbox=(CheckBox) findViewById(R.id.whipped_cream_checkbox);
      boolean x= whippedcreamcheckbox.isChecked();
      if(x==true)
          price+=5;
      CheckBox chocolatecheckbox=(CheckBox) findViewById(R.id.chocolate_checkbox);
      boolean y=chocolatecheckbox.isChecked();
      if(y==true)
          price+=10;
          EditText et=(EditText) findViewById(R.id.name_text);
          String name=et.getText().toString();
          Intent intent = new Intent(Intent.ACTION_SENDTO);
          intent.setData(Uri.parse("mailto:"));//only email app should handle this
          intent.putExtra(Intent.EXTRA_SUBJECT, "coffee ordered by "+name);
          intent.putExtra(Intent.EXTRA_TEXT,createOrderSummery(x,y,price,name));
          if (intent.resolveActivity(getPackageManager()) != null)
              startActivity(intent);
        //displayMessage(createOrderSummery(x,y,price,name));
        noofcoffee=0;
        display(noofcoffee);
      }
    }
    public String createOrderSummery(boolean x,boolean y,int price,String name)
    {

        String pricemessage="Name: "+name;
    pricemessage=pricemessage+"\nOrdered coffee: "+ noofcoffee;
    pricemessage+="\nAdd whipped Cream? "+x;
    pricemessage+="\nAdd Chocolate? "+y;
        pricemessage=pricemessage + "\nTotal: " +"Rs."+ noofcoffee*price;
        pricemessage=pricemessage + "\nThank you!";
        return pricemessage;
    }
    public void  increment(View view)
    { if(noofcoffee<100)
        noofcoffee++;
        display(noofcoffee);
    }
    public void  decrement(View view)
    { if(noofcoffee>=2)
        noofcoffee--;
        display(noofcoffee);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */

    /*private void displayMessage(String message) {
        TextView ordersummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        ordersummaryTextView.setText(message);
    }*/

}
