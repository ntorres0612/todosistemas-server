package com.ntorres.task.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class Dates {
    private static Dates instance = null;
    private Dates() {}
    public static Dates getInstance() {
        if (instance == null)
            instance = new Dates();

        return instance ;
    }

    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillis = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillis,TimeUnit.MILLISECONDS);
    }
}