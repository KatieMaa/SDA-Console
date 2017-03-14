package xmlFactoryTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.model.User;
import pl.sdacademy.service.DataService;


public class DataServiceTest {

    private DataService dataService;
    private String xmlUser = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";
    private User userFromLoad;
    private User userXML;


    @Before //ma to wykonac przed kazdym testem
    public void setUp() throws Exception {
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
}
