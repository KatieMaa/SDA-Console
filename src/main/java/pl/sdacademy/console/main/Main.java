package pl.sdacademy.console.main;

import pl.sdacademy.model.User;
import pl.sdacademy.service.DataService;
import pl.sdacademy.service.UserService;
import pl.sdacademy.xml.XMLFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        login(scanner);
    }

    //DataService dataService = new DataService();

//        zapisujemy od razu do stworzonego pliku

    //User user = new User();

    //XMLFactory xf = new XMLFactory();
    //String xmlUser = xf.objectToXML(user);

    //dataService.saveData(xmlUser);


//        metoda pobierajaca z konsoli

    private static void login(Scanner scanner) {
        UserService userService = new UserService();
        boolean isLogin = false;
        while (!isLogin) {
            System.out.println("Login: ");
            String login = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();

            User user = new User(login, password);

//        sprawdzenie poprawnosci loginu i hasla - nowa klasa UserService

            isLogin = userService.authenticate(user);
            if (isLogin = userService.authenticate(user)) {
                System.out.println("You are log in");
            } else {
                System.out.println("Wrong password");
            }
        }
    }
}
