package com.FLGS.Store.Employees.commands;

import com.FLGS.Store.Employees.Demonstrator;

public class Demonstrate extends Introduce implements Command{
    public Demonstrate(Demonstrator demoer, Class<?> gameType, String customerName) {
        super(demoer, gameType, customerName, "Demonstrate");
    }
}