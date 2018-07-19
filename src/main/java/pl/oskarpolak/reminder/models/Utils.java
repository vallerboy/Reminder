package pl.oskarpolak.reminder.models;

import org.omg.CORBA.DATA_CONVERSION;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static LocalDate stringToDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(ConfigModel.DATE_FORMAT);
        return LocalDate.parse(date, dateTimeFormatter);
    }

}
