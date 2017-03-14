package xmlFactoryTest;

//import junit.framework.TestCase; - zrezygnowalismy z tego framework'a
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.model.User;
import pl.sdacademy.xml.XMLFactory;

public class XMLFactoryTest {

    private String login;
    private String password;
    private String xmlUser = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";

    public XMLFactoryTest() {
    }

//    setUp - przed wykonaniem testow, do ustawienia obiektow zmiennych

    @Before
    public void setUp() throws Exception {
        login = "kowalski";
        password = "abc123";
    }

    @Test
    public void objectToXML() {

        XMLFactory<User> xmlFactory = new XMLFactory<User>(User.class);
        User user = new User(login, password);
        String xmlUser = xmlFactory.objectToXML(user);
        System.out.println(xmlUser);
//        assertTrue(true);
//        Assert.assertTrue(true);

//        samodzielna praca test

        Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>", xmlUser);

    }

    @Test
    public void xmlToObject() {

        XMLFactory<User> xmlFactory = new XMLFactory<User>(User.class);
        User userFromXml = xmlFactory.xmlToObject(xmlUser);
        User user = new User (login, password);

        Assert.assertTrue(user.equals(userFromXml));
    }
}
