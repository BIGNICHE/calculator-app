package com.example.nick.calc_u_later.inputs.oper.operators;

public class Plus extends Operator
{
    public int getPrecedence()
    {
        return 1;
    }

    @Override
    public String toString()
    {
        return "+";
    }
}
