/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab15;

import java.util.regex.Pattern;

/**
 *
 * @author epam
 */
public class TestEmail {
    
    
    public static void main(String []args){
        String email = "/!.#$%&'*+=?^`{|}~vad123@saaaa.neqwe";

/*        String regExp =
                "^([_a-z0-9-\\/\\!\\#\\$\\%\\&\\'\\*\\+\\=\\?\\^\\`\\{\\|\\}\\~]+"
                + "(\\.[_a-z0-9-\\/\\!\\#\\$\\%\\&\\'\\*\\+\\=\\?\\^\\`\\{\\|\\}\\~]+)*"
                + "@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,6}))*$";

*/        
        String regExp1 =
                "^([_a-z0-9-\\/\\!\\#\\$\\%\\&\\'\\*\\+\\=\\?\\^\\`\\{\\|\\}\\~]+"
                + "(\\.[_a-z0-9-\\/\\!\\#\\$\\%\\&\\'\\*\\+\\=\\?\\^\\`\\{\\|\\}\\~]+)*"
                + "@[[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,6})]{4,255})*$";
        // "(),:;<>@[\]   
        // /!.#$%&'*+=?^`{|}~
        
//        boolean res = Pattern.matches(regExp, email);
//        System.out.println(res ? "correct email" : "incorrect email");
        boolean res1 = Pattern.matches(regExp1, email);
        System.out.println(res1? "correct email" : "incorrect email");

        
        
        
    }
}
