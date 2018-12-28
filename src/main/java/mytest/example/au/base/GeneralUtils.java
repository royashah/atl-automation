package mytest.example.au.base;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rora.
 */
public class  GeneralUtils {

    public static String getRandString(int lenght) {
        String ALLCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randstr = new StringBuilder();
        Random rnd = new Random();
        while (randstr.length() < lenght) {
            int indx  = ThreadLocalRandom.current().nextInt(ALLCHARS.length());
            randstr.append(ALLCHARS.charAt(indx));
        }
        return randstr.toString();
        }
}
