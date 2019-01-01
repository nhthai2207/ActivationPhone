package nht.phoneactivation.domain.phoneNum;

import nht.phoneactivation.domain.phoneNum.model.ActivationResult;
import nht.phoneactivation.domain.phoneNum.model.UsagePeriod;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneService {
    public List<ActivationResult> determineActivationDate(List<String> rowPhoneList) {
        Map<String, List<UsagePeriod>> usagePeriodMap = new HashMap<>();
        for (String s : rowPhoneList) {
            String[] split = s.split(",");
            if (usagePeriodMap.get(split[0]) == null) {
                usagePeriodMap.put(split[0], new ArrayList<>());
            }
            usagePeriodMap.get(split[0]).add(new UsagePeriod(split[1], split.length == 3 ? split[2] : ""));
        }

        List<ActivationResult> results = usagePeriodMap.entrySet().stream().map(entry -> lookupActivationDateOfNumber(entry.getKey(), entry.getValue())).collect(Collectors.toList());
        return results;
    }

    public ActivationResult lookupActivationDateOfNumber(String phoneNum, List<UsagePeriod> usagePeriodList) {
        // des sort for usagePeriodList by from
        Collections.sort(usagePeriodList, (o1, o2) -> o2.from.compareTo(o1.from));

        for (int i = 0; i < usagePeriodList.size() - 1; i++) {
            if (usagePeriodList.get(i).from.compareTo(usagePeriodList.get(i + 1).to) > 0) {
                return new ActivationResult(phoneNum, usagePeriodList.get(i).from);
            }
        }
        return new ActivationResult(phoneNum, usagePeriodList.get(usagePeriodList.size() - 1).from);
    }
}
