package nht.phoneactivation;

import nht.phoneactivation.domain.phoneNum.PhoneService;
import nht.phoneactivation.domain.phoneNum.model.ActivationResult;
import nht.phoneactivation.utils.FileUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

public class Main {
    static List<String> rowPhoneList = Arrays.asList("0987000001,2016-03-01,2016-05-01",
            "0987000002,2016-02-01,2016-03-01",
            "0987000001,2016-01-01,2016-03-01",
            "0987000001,2016-12-01,",
            "0987000002,2016-03-01,2016-05-01",
            "0987000003,2016-01-01,2016-01-10",
            "0987000001,2016-09-01,2016-12-01",
            "0987000002,2016-05-01,",
            "0987000001,2016-06-01,2016-09-01");


    public static void main(String[] args) {
        List<String> strings = FileUtils.readCSV("input.txt");
        if (CollectionUtils.isNotEmpty(strings)) {
            PhoneService phoneService = new PhoneService();
            List<ActivationResult> lookup = phoneService.determineActivationDate(strings.subList(1, strings.size()));
            System.out.println(lookup);
        }
    }
}
