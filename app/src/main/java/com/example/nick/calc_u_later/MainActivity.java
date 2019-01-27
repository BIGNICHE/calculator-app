
package com.example.nick.calc_u_later;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nick.calc_u_later.inputs.Input;
import com.example.nick.calc_u_later.inputs.oper.operands.Operand;
import com.example.nick.calc_u_later.inputs.oper.operators.Divide;
import com.example.nick.calc_u_later.inputs.oper.operators.Multiply;
import com.example.nick.calc_u_later.inputs.oper.operators.Plus;
import com.example.nick.calc_u_later.inputs.oper.operators.Minus;

import java.math.BigDecimal;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    TextView textView;
    StringBuilder display = new StringBuilder();
    StringBuilder singlenumbersb = new StringBuilder();
    // static void stack_push(Stack<String> operatorStack, String operator){
    //      operatorStack.push(operator);
    // }
    // String stack_pop(Stack<String> operatorStack, String operator){
    //     operator = operatorStack.pop();
    //     return operator;
    // }

    Stack<Input> inputList = new Stack<>();

    BigMaths bigMaths = new BigMaths();

    String currentOperand = "";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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
        textView = (TextView) findViewById(R.id.textView);

        //initialise the operator stack


    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button0:
                singlenumbersb.append("0"); //The stringbuilder singlenumbersb is used because
                // multiple buttons need to be pressed in order to write operands above 9
                display.append("0"); // The stringbuilder display is shown onscreen, ie your input is shown
                // directly onscreen without any maths going on in the background
                displayupdate(); // update the TextView with the current string of user inputs
                break;
            case R.id.button1:
                singlenumbersb.append("1");
                display.append("1");
                break;
            case R.id.button2:
                singlenumbersb.append("2");
                display.append("2");
                break;
            case R.id.button3:
                singlenumbersb.append("3");
                display.append("3");
                break;
            case R.id.button4:
                singlenumbersb.append("4");
                display.append("4");
                break;
            case R.id.button5:
                singlenumbersb.append("5");
                display.append("5");
                break;
            case R.id.button6:
                singlenumbersb.append("6");
                display.append("6");
                break;
            case R.id.button7:
                singlenumbersb.append("7");
                display.append("7");
                break;
            case R.id.button8:
                singlenumbersb.append("8");
                display.append("8");
                break;
            case R.id.button9:
                singlenumbersb.append("9");
                display.append("9");
                break;
            case R.id.buttonequals:
                Queue output = bigMaths.shuntingYard(inputList);
                break;
            case R.id.buttonclr:
                display.setLength(0);
                break;
            case R.id.buttonplus:
                toSingleOperand();
                inputList.add(new Plus());
                display.append("+");
                break;
            case R.id.buttonminus:
                toSingleOperand();
                inputList.add(new Minus());
                display.append("-");
                break;
            case R.id.buttonmult:
                toSingleOperand();
                inputList.add(new Multiply());
                display.append("×");
                break;
            case R.id.buttondiv:
                toSingleOperand();
                inputList.add(new Divide());
                display.append("÷");
                break;
            case R.id.buttondec:
                singlenumbersb.append(".");
                display.append(".");
                break;
            case R.id.buttonsin:
                //display.append("sin(");
                //displayupdate();
                break;

        }

        displayupdate();
    }

    public void displayupdate()
    {
        String outputtext = display.toString();
        textView.setText(outputtext);
    }

    public void toSingleOperand()
    {
        String singleOperand = singlenumbersb.toString();
        Operand operand = new Operand(new BigDecimal(singleOperand));
        inputList.add(operand);
    }

}