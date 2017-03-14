package pl.sdacademy.service;

import pl.sdacademy.model.User;

public class UserService {

    public boolean authenticate(User user) {
        DataService dataService = new DataService();
        User userFromFile = dataService.loadData();
        //pobieramy password z user;gdy mamy wiecej niz jednego usera


        //pobieramy userFromFile czyli usera z pliku
        return user.equals(userFromFile);
    }
}
