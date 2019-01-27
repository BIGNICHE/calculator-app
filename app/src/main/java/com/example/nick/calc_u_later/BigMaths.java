package com.example.nick.calc_u_later;

import com.example.nick.calc_u_later.inputs.Input;
import com.example.nick.calc_u_later.inputs.LeftBracket;
import com.example.nick.calc_u_later.inputs.RightBracket;
import com.example.nick.calc_u_later.inputs.oper.operators.Operator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BigMaths
{
    public BigMaths()
    {

    }

    public Queue<Input> shuntingYard(Stack<Input> input)
    {
        Stack<Input> operatorStack = new Stack<>();
        Queue<Input> outputQueue = new LinkedList<>();

        //SHUNTING YARD ALGORITHM ------------------------------------------------------------------
        //Everything comes into here as a string
        //Plan is to convert our numbers from string to big decimal once everything is in order
        //or more accurately, before the operators are pushed to the output queue.
        //This prevents type mismatch, although i expect it will end up being an issue.
        //first things first, control structure that empties input list


        Input currentOperator;


        while (!input.isEmpty())
        {
            //second things second, i am the realest
            //but in all seriousness, now we can push numbers to the output while saving brackets
            //for later
            Input currentOperand = input.pop();
            //Check if it's a bracket or not


            if (currentOperand instanceof LeftBracket)
            {
                operatorStack.push(new LeftBracket());
            }
            else if (currentOperand instanceof RightBracket)
            {
                do
                {
                    currentOperator = operatorStack.pop();
                    outputQueue.add(currentOperator);
                } while (!(currentOperator instanceof LeftBracket));
            }
            else if (currentOperand instanceof Operator)
            {
                operatorStack.push(currentOperand);
            }
            else
            {
                outputQueue.add(currentOperand);
            }
        }
        //no more inputs remain
        //push everything off the stack into the output queue
        while (!operatorStack.isEmpty())
        {
            currentOperator = operatorStack.pop();
            outputQueue.add(currentOperator);
        }
        // our output queue is now full


        //BigDecimal value = new BigDecimal(1);
        //value.divide(new BigDecimal(2));
        //Deque<BigDecimal> operands = new ArrayDeque<BigDecimal>();

        return outputQueue;
    }

}
