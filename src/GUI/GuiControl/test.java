/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.GuiControl;

import DAO.HoadonDAO;
import DAO.LinhkienDAO;
import entities.Hoadon;
import entities.Linhkien;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Asus
 */
public class test {

    public static void main(String args[]){
        LinhkienDAO lkdao = new LinhkienDAO(Linhkien.class);
     
        lkdao.findAll(0).forEach(x->   System.out.println(x));
    }
}
