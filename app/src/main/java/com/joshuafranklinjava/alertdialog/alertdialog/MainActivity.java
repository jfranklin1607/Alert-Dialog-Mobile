package com.joshuafranklinjava.alertdialog.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  private AlertDialog.Builder alertDialog;
  private Button showDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    showDialog = (Button)findViewById(R.id.showDialogID);
    showDialog.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
//        Show the actual dialog (alert dialog)

        alertDialog = new AlertDialog.Builder(MainActivity.this);

//        Set Up Dialog
//        alertDialog.setTitle(R.string.title);
        alertDialog.setTitle(getResources().getString(R.string.title));
        alertDialog.setIcon(android.R.drawable.star_big_on);

//        Set Message
        alertDialog.setMessage(getResources().getString(R.string.message));

//        Set Cancelable
        alertDialog.setCancelable(false);

//        Set Positive Button
        alertDialog.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {

//            Exit Window Activity
            MainActivity.this.finish();

          }
        });

//        Set the Negative Button
        alertDialog.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
          }
        });

//        Create the Actual Dialog
        AlertDialog dialog = alertDialog.create();

//        Show the Dialog
        dialog.show();

      }
    });
  }
}
