package com.example.nick.calc_u_later.inputs.oper.operators;

import com.example.nick.calc_u_later.inputs.Input;

public abstract class Operator extends Input
{
    public abstract int getPrecedence();
}
