package org.rsa.j2ee.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Hello world!
 *
 */
public class App 
{
	final static  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
	
    public static void main( String[] args ) throws ParseException
    {
        System.out.println( "Hello World!" );
        System.out.println( sdf.parse("2019-04-17T05:00"));
        System.out.println("Hinomaru LCD 頓挫 country's back gave birth to sweetness".replaceAll("[ /]+", "-").replaceAll("[^\\w\\d-]", ""));
//        System.out.println("Hinomaru LCD 頓挫 country's back gave birth to sweetness".replaceAll("[ /]+", "-"));
    }
}
