package com.example.calc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class calcclassjava extends AppCompatActivity {

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnac,btndelete,btndivide,btnmulti
            ,btnadd,btnsub,btnequal,btndot;

    private TextView textviewresult, textviewhistory;

    private  String number = null;

    double firstnumer = 0;
    double lastnumber = 0;

    String status = null;
    boolean operator = false;

    DecimalFormat myformatter = new DecimalFormat("######.######");

    String history, currentresult;

    boolean dot = true;

    boolean btnaccontrol = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcclassjava);

        //find the id's of the buttons and also textview here

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.bt1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.bt4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.bt7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnac = findViewById(R.id.btnac);
        btnadd = findViewById(R.id.btnadd);
        btndivide = findViewById(R.id.btndivide);
        btndelete = findViewById(R.id.btndel);
        btnmulti = findViewById(R.id.btnmulti);
        btnsub = findViewById(R.id.btnsub);
        btnequal = findViewById(R.id.btnequal);
        btndot = findViewById(R.id.btndot);


        textviewresult = findViewById(R.id.text2);
        textviewhistory = findViewById(R.id.text1);



        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("0");
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("1");
            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("2");
            }
        });



        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("3");
            }
        });




        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("4");
            }
        });




        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("5");
            }
        });




        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("6");
            }
        });



        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("9");
            }
        });

        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"TEXT CLEARED",Toast.LENGTH_LONG).show();

                number = null;
                status = null;
                textviewresult.setText("0");
                textviewhistory.setText("");
                firstnumer = 0;
                lastnumber = 0;
                dot = true;
                btnaccontrol = true;

            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnaccontrol){
                    textviewresult.setText("0");
                }
                else {
                    number = number.substring(0,number.length()-1);
                    if(number.length() == 0){
                        btndelete.setClickable(false);
                    }
                    else if(number.contains(".")){
                        dot = false;
                    }
                    else {
                        dot = true;
                    }
                    textviewresult.setText(number);
                }




              

            }
        });

        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textviewhistory.getText().toString();
                currentresult = textviewresult.getText().toString();
                textviewhistory.setText(history+currentresult+"/");



                if(operator) {
                    if (status == "multiplication") {
                        multiple();
                    } else if (status == "sum") {
                        plus();
                    } else if (status == "subtraction") {
                        minus();
                    } else {
                        divide();
                    }
                }
                status = "division";
                operator = false;
                number = null;

            }


        });


        btnmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                history = textviewhistory.getText().toString();
                currentresult = textviewresult.getText().toString();
                textviewhistory.setText(history+currentresult+"*");


              if(operator){
                  if(status == "sum"){
                      plus();
                  }
                  else  if (status == "division"){
                      divide();
                  }
                  else if (status == "subtraction"){
                      minus();
                  }

                  else {
                      multiple();
                  }

              }

              status = "multiplication";
              operator = false;
              number = null;
                }


        });

        btnsub.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                history = textviewhistory.getText().toString();
                currentresult = textviewresult.getText().toString();
                textviewhistory.setText(history+currentresult+"-");


                if(operator){
                    if(status == "multiplication"){
                        multiple();
                    }
                    else  if (status == "division"){
                        divide();
                    }
                    else  if (status == "sum"){
                        plus();
                    }
                    else {
                        minus();
                    }
                }
                status = "subtraction";
                operator = false;
                number = null;

            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textviewhistory.getText().toString();
                currentresult = textviewresult.getText().toString();
                textviewhistory.setText(history+currentresult+"+");

                if(operator){
                    if(status == "multiplication"){
                        multiple();
                    }
                    else if (status == "division"){
                        divide();
                    }
                    else  if (status == "subtraction"){
                        minus();
                    }
                    else {
                        plus();
                    }
                }
                status = "sum";
                operator = false;
                number = null;

            }
        });

        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(operator){
                    if(status == "sum"){
                        plus();
                    }
                    else if(status == "subtraction"){
                        minus();
                    }
                    else if(status == "multiplication"){
                        multiple();
                    }
                    else if(status == "division"){
                        divide();
                    }
                    else {
                        firstnumer = Double.parseDouble(textviewresult.getText().toString());

                    }
                }

                operator = false;


            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dot){

                    if(number == null){
                        number = "0.";

                    }
                    else {
                        number = number + ".";
                    }

                }


                textviewresult.setText(number);
                dot = false;

            }
        });
    }

    private void numberclick(String view){
        if(number == null ){
            number = view;
        }
        else {
            number = number + view;
        }
        textviewresult.setText(number);
        operator = true;
        btnaccontrol = false;
        btndelete.setClickable(true);
    }

    public  void plus(){
        lastnumber = Double.parseDouble(textviewresult.getText().toString());
        firstnumer = firstnumer + lastnumber;

        textviewresult.setText(myformatter.format(firstnumer));

        dot = true;
    }
    public void minus(){
        if(firstnumer == 0){
            firstnumer = Double.parseDouble(textviewresult.getText().toString());


        }
        else {
            lastnumber = Double.parseDouble(textviewresult.getText().toString());
            firstnumer = firstnumer - lastnumber;

        }
        textviewresult.setText(myformatter.format(firstnumer));
        dot = true;


    }
    public  void multiple(){
        if(firstnumer == 0){
            firstnumer = 0;
            lastnumber = Double.parseDouble(textviewresult.getText().toString());
            firstnumer = firstnumer + lastnumber;
        }
        else {
            lastnumber = Double.parseDouble(textviewresult.getText().toString());
            firstnumer = firstnumer*lastnumber;
        }
        textviewresult.setText(myformatter.format(firstnumer));
        dot = true;

    }

    public  void divide(){
        if(firstnumer == 0){
            lastnumber = Double.parseDouble(textviewresult.getText().toString());
            firstnumer = lastnumber/1;
        }
        else {
            lastnumber = Double.parseDouble(textviewresult.getText().toString());
            firstnumer = firstnumer/lastnumber;
        }
        textviewresult.setText(myformatter.format(firstnumer));
        dot = true;

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitbybackkey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }



    protected  void  exitbybackkey(){

        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setTitle("EXIT !");
        alertdialog.setMessage("DO YOU WANT TO EXIT ?");
        alertdialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertdialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();


    }
}