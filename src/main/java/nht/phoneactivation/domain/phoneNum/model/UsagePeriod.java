package nht.phoneactivation.domain.phoneNum.model;

import nht.phoneactivation.utils.DateTimeUtils;

import java.time.LocalDate;

public class UsagePeriod {

    public LocalDate from;
    public LocalDate to;
    public UsagePeriod(String from, String to){
        this.from = DateTimeUtils.stringToLocalDate(from);
        this.to = DateTimeUtils.stringToLocalDate(to);
    }

}
