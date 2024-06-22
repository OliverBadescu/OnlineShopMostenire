package newspaper.service;

import users.models.Users;

import java.util.ArrayList;

public interface NewspaperQueryService {

    void loadData();
    void afisare();
    void notifyUsers();
    String toString();

}
