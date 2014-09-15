/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab14;

import java.util.regex.Pattern;
import java.lang.String;
/**
 *
 * @author epam
 */
public class TestLeapYear {
    public static void main(String []args){
        
        String year = "2016";
        String regExp = "((\\d*(([02468][048])|([13579][26 ]))00)|"
                + "\\d*(([02468][48])|([2468][048])|([13579][26]))|[048])";
        boolean res = Pattern.matches(regExp, year);
        System.out.println(res?"leap-year":"non leap year");
        
    }
}
