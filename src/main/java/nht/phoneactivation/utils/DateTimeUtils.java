package nht.phoneactivation.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static LocalDate stringToLocalDate(String s) {
        if(StringUtils.isNotEmpty(s)) {
            return LocalDate.parse(s, dateTimeFormatter);
        }
        return null;
    }


    public static String localDateToString(LocalDate localDate) {
        return dateTimeFormatter.format(localDate);
    }
}
