package jDBC;

import  java.util.*;
import java.text.*;
 
public class test {
   public static void main(String args[]) throws ParseException {
    String date = "2012-2-13 12:23:45";
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      formatter.setLenient(false);
      Date newDate= formatter.parse(date);
      //formatter = new SimpleDateFormat("yyyy-MM-dd");
      System.out.println("ok");
      System.out.println(formatter.format(newDate));
   }

}
