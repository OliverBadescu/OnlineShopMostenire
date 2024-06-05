package products.service;

import products.models.Product;

public interface ProductCommandService {

    void loadData();

    void saveData();

    void stergeProdus(Product product);

    void adaugareProdus(Product product);

    void promoCraciun();

    void promoPaste();

    void anularePromoCraciun();

    void anularePromoPaste();

}
