package com.example.nick.calc_u_later;

import com.example.nick.calc_u_later.inputs.Input;
import com.example.nick.calc_u_later.inputs.LeftBracket;
import com.example.nick.calc_u_later.inputs.RightBracket;
import com.example.nick.calc_u_later.inputs.oper.operands.Operand;
import com.example.nick.calc_u_later.inputs.oper.operators.Multiply;
import com.example.nick.calc_u_later.inputs.oper.operators.Plus;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BigMathsTest
{
    @Test
    public void onePlusOne()
    {
        BigMaths bigMaths = new BigMaths();

        Stack<Input> input = new Stack<>();
        input.push(new Operand(new BigDecimal(1)));
        input.push(new Plus());
        input.push(new Operand(new BigDecimal(1)));

        Queue<Input> output = bigMaths.shuntingYard(input);

        Queue<Input> expected = new LinkedList<>();
        expected.add(new Operand(new BigDecimal(1)));
        expected.add(new Operand(new BigDecimal(1)));
        expected.add(new Plus());

        Assert.assertEquals(expected, output);
    }

    @Test
    public void Brackets()
    {
        BigMaths bigMaths = new BigMaths();

        Stack<Input> input = new Stack<>();
        input.push(new LeftBracket());
        input.push(new Operand(new BigDecimal(1)));
        input.push(new Plus());
        input.push(new Operand(new BigDecimal(1)));
        input.push(new RightBracket());
        input.push(new Multiply());
        input.push(new Operand(new BigDecimal(2)));

        Queue<Input> output = bigMaths.shuntingYard(input);

        Queue<Input> expected = new LinkedList<>();
        expected.add(new Operand(new BigDecimal(1)));
        expected.add(new Operand(new BigDecimal(1)));
        input.push(new Operand(new BigDecimal(2)));
        input.push(new Multiply());
        input.push(new Plus());

        Assert.assertEquals(expected, output);
    }

}