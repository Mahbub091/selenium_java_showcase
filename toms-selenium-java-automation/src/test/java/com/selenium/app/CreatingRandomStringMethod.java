package com.selenium.app;

public class CreatingRandomStringMethod {

    // function to generate a random string of length n
    static String getAlphaNumericString(int n)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        int n = 13;
        System.out.println(getAlphaNumericString(n));
    }
}
