package com.example.nick.calc_u_later.inputs;

public abstract class Input
{
    @Override
    public boolean equals(Object other)
    {
        // Return true straight away if other is the same reference.
        if (this == other) return true;

        // Return false if other is null.
        if (other == null) return false;

        // Return true if other is the same class as this one, false otherwise.
        return getClass() == other.getClass();
    }
}
