package com.company;

import domain.Senate;
import tools.Defaults;

public class Main
{
    public static void main(String[] args)
    {
        Senate spqr = new Senate();
        spqr.readSoldiers();
        spqr.rating();
        spqr.writeSoldiers();
    }
}
