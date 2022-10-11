package com.holanda.holi.domain.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy - hh:mm");

    public static String toCustomDate(Date date){
        return dateFormat.format(date);
    }
}
