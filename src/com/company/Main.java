package com.company;

import domain.Senate;
import services.AuditLog;

public class Main
{
    public static void main(String[] args)
    {
        AuditLog.open();
        Senate spqr = new Senate();
        spqr.readSoldiers();
        spqr.rating();
        spqr.writeSoldiers();
        AuditLog.close();
    }
}
