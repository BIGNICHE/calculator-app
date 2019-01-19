package com.example.nick.calc_u_later;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    StringBuilder sb = new StringBuilder();
    StringBuilder singlenumbersb = new StringBuilder();
    static void stack_push(Stack<String> operatorStack, String operator){
        operatorStack.push(operator);
    }
    String stack_pop(Stack<String> operatorStack, String operator){
        operator = operatorStack.pop();
        return operator;
    }

    ArrayList<String> inputList = new ArrayList<>();
    Queue<BigDecimal> outputQueue = new LinkedList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //identify the buttons
//--------------------------------------------------------------------------------------------------

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonequals = findViewById(R.id.buttonequals);
        Button buttonclr = findViewById(R.id.buttonclr);
        Button buttonplus = findViewById(R.id.buttonplus);
        Button buttonminus = findViewById(R.id.buttonminus);
        Button buttonmult = findViewById(R.id.buttonmult);
        Button buttondiv = findViewById(R.id.buttondiv);
        Button buttondec = findViewById(R.id.buttondec);
        Button buttonsin = findViewById(R.id.buttonsin);

        //set listeners
//--------------------------------------------------------------------------------------------------

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonequals.setOnClickListener(this);
        buttonclr.setOnClickListener(this);
        buttonplus.setOnClickListener(this);
        buttonminus.setOnClickListener(this);
        buttonmult.setOnClickListener(this);
        buttondiv.setOnClickListener(this);
        buttondec.setOnClickListener(this);
        buttonsin.setOnClickListener(this);

        //initialise textview
        //------------------------------------------------------------------------------------------
        textView=(TextView)findViewById(R.id.textView);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                singlenumbersb.append(0); //The stringbuilder singlenumbersb is used because multiple buttons need to be pressed in order to write operands above 9
                sb.append("0"); // The stringbuilder sb is shown onscreen, ie your input is shown directly onscreen without any maths going on in the background
                displayupdate(); // update the TextView with the current string of user inputs
                break;
            case R.id.button1:
                singlenumbersb.append(1);
                sb.append("1");
                displayupdate();
                break;
            case R.id.button2:
                singlenumbersb.append(2);
                sb.append("2");
                displayupdate();
                break;
            case R.id.button3:
                singlenumbersb.append(3);
                sb.append("3");
                displayupdate();
                break;
            case R.id.button4:
                singlenumbersb.append(4);
                sb.append("4");
                displayupdate();
                break;
            case R.id.button5:
                singlenumbersb.append(5);
                sb.append("5");
                displayupdate();
                break;
            case R.id.button6:
                singlenumbersb.append(6);
                sb.append("6");
                displayupdate();
                break;
            case R.id.button7:
                singlenumbersb.append(7);
                sb.append("7");
                displayupdate();
                break;
            case R.id.button8:
                singlenumbersb.append(8);
                sb.append("8");
                displayupdate();
                break;
            case R.id.button9:
                singlenumbersb.append(9);
                sb.append("9");
                displayupdate();
                break;
            case R.id.buttonequals:
                bigMaths();
                break;
            case R.id.buttonclr:
                sb.setLength(0);
                displayupdate();
                break;
            case R.id.buttonplus:
                toSingleOperand();
                inputList.add("+");
                sb.append("+");
                displayupdate();
                break;
            case R.id.buttonminus:
                toSingleOperand();
                inputList.add("-");
                sb.append("-");
                displayupdate();
                break;
            case R.id.buttonmult:
                toSingleOperand();
                inputList.add("×");
                sb.append("×");
                displayupdate();
                break;
            case R.id.buttondiv:
                toSingleOperand();
                inputList.add("÷");
                sb.append("÷");
                displayupdate();
                break;
            case R.id.buttondec:
                sb.append(".");
                displayupdate();
                break;
            case R.id.buttonsin:
                sb.append("sin(");
                displayupdate();

        }
    }

    public void displayupdate() {
        String outputtext = sb.toString();
        textView.setText(outputtext);
    }

    public void toSingleOperand() {
        String singleOperand = singlenumbersb.toString();
        inputList.add(singleOperand);
    }

    public void bigMaths() {
        //SHUNTING YARD ALGORITHM ------------------------------------------------------------------




        //BigDecimal value = new BigDecimal(1);
        //value.divide(new BigDecimal(2));
        //Deque<BigDecimal> operands = new ArrayDeque<BigDecimal>();


    }




}