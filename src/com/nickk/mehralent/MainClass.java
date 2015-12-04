/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nickk.mehralent;

import java.awt.*;
import java.awt.print.PageFormat;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;

/**
 *
 * @author nick
 */
class MainClass {
    // Change MySQL Config here. Don't mess else keep crying i won't listen.
    public String url = "jdbc:mysql://localhost:3306/mehrals";
    public String user = "root";
    public String pwd = "ExDb20Tra";
    // Stop. Don't dare to edit lines below. Else you will break your neck.
    public String cl = "java.sql.DriverManager";
    
    /* Experimental Print Support */
    
    public int print(Graphics g, PageFormat pf, int page)
    throws PrinterException {
    if (page > 0) {
        return NO_SUCH_PAGE;
    }

    Graphics2D g2d = (Graphics2D)g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());
    new list_all_data().printAll(g);
    return PAGE_EXISTS;
}



}
