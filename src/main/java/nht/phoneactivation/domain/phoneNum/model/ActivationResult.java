package nht.phoneactivation.domain.phoneNum.model;

import nht.phoneactivation.utils.DateTimeUtils;

import java.time.LocalDate;

public class ActivationResult {
    public String phoneNum;
    public LocalDate activationDate;

    public ActivationResult(String phoneNum, LocalDate from) {
        this.phoneNum = phoneNum;
        this.activationDate = from;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", this.phoneNum, DateTimeUtils.localDateToString(this.activationDate));
    }
}
