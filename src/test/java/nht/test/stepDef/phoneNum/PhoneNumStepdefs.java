package nht.test.stepDef.phoneNum;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nht.phoneactivation.domain.phoneNum.PhoneService;
import nht.phoneactivation.domain.phoneNum.model.ActivationResult;
import nht.phoneactivation.domain.phoneNum.model.UsagePeriod;
import nht.phoneactivation.utils.DateTimeUtils;
import nht.test.BaseStepDef;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PhoneNumStepdefs extends BaseStepDef {
    private List<UsagePeriod> usageUsagePeriodList;

    private LocalDate activationDate;

    private PhoneService phoneService = new PhoneService();

    @Given("^usage history of number \"([^\"]*)\" is$")
    public void usage_history_of_number_is(String number, DataTable table) {
        this.usageUsagePeriodList = new ArrayList<>();
        int numberOfRows = this.getNumberOfRows(table);
        for (int i = 0; i < numberOfRows; i++) {
            Map<String, String> row = this.getRow(table, i);
            this.usageUsagePeriodList.add(new UsagePeriod(row.get("activationDate"), row.get("deactivationDate")));
        }
    }

    @When("^looking for activation date of number \"([^\"]*)\"$")
    public void looking_for_activation_date_of_number(String number) {
        ActivationResult activationResult = phoneService.lookupActivationDateOfNumber(number, this.usageUsagePeriodList);
        this.activationDate = activationResult.activationDate;
    }

    @Then("^activation date should be \"([^\"]*)\"$")
    public void activation_date_should_be(String expectedDate) {
        LocalDate localDate = DateTimeUtils.stringToLocalDate(expectedDate);
        assertEquals(localDate, this.activationDate);
    }
}
