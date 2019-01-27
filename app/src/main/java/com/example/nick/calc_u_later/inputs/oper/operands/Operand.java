package com.example.nick.calc_u_later.inputs.oper.operands;

import com.example.nick.calc_u_later.inputs.Input;

import java.math.BigDecimal;

public class Operand extends Input
{
    private BigDecimal value;

    public Operand(BigDecimal value)
    {
        this.value = value;
    }

    public BigDecimal getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return value.toString();
    }

    @Override
    public boolean equals(Object other)
    {
        // Return true straight away if other is the same reference.
        if (this == other) return true;

        // Return false if other is not the same class as this one (Operand).
        if (other == null || getClass() != other.getClass()) return false;

        // Cast other to Operand, as we now know that it must be an Operand.
        Operand operand = (Operand) other;

        // Actually compare the internal BigDecimal value of the two classes.
        return value.equals(operand.getValue());
    }
}
