package products.service;

import products.models.*;

public interface ProductQueryService {

     void loadData();
     void afisare();
     void afisareTelefoane();
     void afisareLaptopuri();
     void afisareMonitor();
     void afisareSmartWatch();
     void sortareDupaPretCrescator();
     void sortareDupaPretDescrescator();
     Product findProductById(int id);
     Product findByName(String name);
     String toString();
     int generateId();

}
