package com.example.labfx;

public class SizeUtil {
    private static String string = "";

    public static String format(Size size){
        if (size == null){
            return null;
        }
        else{
            String length = Float.toString(size.getLength());
            String width = Float.toString(size.getWidth());
            String height = Float.toString(size.getHeight());
            string = length + " / " + width + " / " + height + " см";

            return string;
        }
    }

}
