package newspaper.service;

import users.models.Users;

public interface NewspaperCommandService {

    void loadData();
    void saveData();
    void update(String txt);


}
