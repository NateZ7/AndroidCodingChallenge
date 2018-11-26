package com.opentable.opentable.Helpers;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils {

    private static String TAG = "Utils";

    /**
     * Creates a date from string, supports multiple formats
     * @param str - string to convert to date
     * @param formats - formats possible
     * @return converted Date if at least 1 format is possible, null otherwise
     */
    public static Date stringToDateByMultipleFormats(String str, List<String> formats) {
        for (String formatString : formats) {
            try {
                return new SimpleDateFormat(formatString).parse(str);
            } catch (ParseException e) {
                Log.e(TAG, e.getMessage());
                e.printStackTrace();
            }
        }

        return null;
    }
}
