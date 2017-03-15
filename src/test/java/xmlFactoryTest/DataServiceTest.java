package xmlFactoryTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.model.Address;
import pl.sdacademy.model.Company;
import pl.sdacademy.model.StreetPrefix;
import pl.sdacademy.model.User;
import pl.sdacademy.service.DataService;

import java.util.List;


public class DataServiceTest {

    private DataService dataService;
    private String xmlUser = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";
    private User userFromLoad;
    private User userXML;
    private Company company;


    @Before //ma to wykonac przed kazdym testem
    public void setUp() throws Exception {
        company = new Company();
        company.setName("Biedronka");
        company.setAddress(new Address("Polna", "4", "7", "23-234", "Poznan", "Poland", StreetPrefix.STREET));
        company.setNIP("2345235");
        dataService = new DataService();
        userXML = new User("kowalski", "abc123");
    }

    public void loadData() {
        userFromLoad = dataService.loadData();
    }

    public void saveData() {
        dataService.saveData(xmlUser);
    }

    @Test
    public void saveAndLoadData() {
        saveData();
        loadData();
        Assert.assertTrue(userFromLoad.equals(userXML));
    }

    @Test
    public void printCompanyInfo() {
        List<String> companyInfo = dataService.printCompanyInfo(company);
        boolean resultAssert = true;
        resultAssert &= companyInfo.get(0).equals("Biedronka");
        System.out.println("resultAssert" + resultAssert);
        resultAssert &= companyInfo.get(1).equals("ul.Polna 4/7\n23-234 Poznan");
        System.out.println("resultAssert" + resultAssert);
        resultAssert &= companyInfo.get(2).equals("2345235");
        System.out.println("resultAssert" + resultAssert);

        for (String line : companyInfo) {
            System.out.println(line);
        }
        Assert.assertTrue(resultAssert);
    }
}
