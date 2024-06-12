import org.junit.Test;
import products.models.Product;
import products.service.ProductCommandServiceImpl;
import products.service.ProductQueryServiceImpl;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProductServiceTests {

    ProductCommandServiceImpl commandService;
    ProductQueryServiceImpl queryService;
    ArrayList<Product> list = new ArrayList<>();

    @Test

    public void GivenAvailableDataCheckIfGetsLoaded(){

        queryService = new ProductQueryServiceImpl();

        Product product= queryService.findProductById(1);

        assertEquals(1, product.getId());



    }

    @Test

    public void afisareSortare(){

        queryService = new ProductQueryServiceImpl();
        commandService = new ProductCommandServiceImpl();

        queryService.afisare();
        queryService.afisareLaptopuri();
        queryService.afisareMonitor();
        queryService.afisareSmartWatch();
        queryService.afisareTelefoane();

        queryService.sortareDupaPretCrescator();
        queryService.sortareDupaPretDescrescator();

        int id = queryService.generateId();

        commandService.promoPaste();
        commandService.promoCraciun();
        commandService.anularePromoPaste();
        commandService.anularePromoCraciun();
    }

    @Test

    public void GivenAvailableProductIdCheckIfGetsFound(){

        queryService = new ProductQueryServiceImpl();

        Product product= queryService.findProductById(1);
        Product none = queryService.findProductById(11);

        assertEquals(1, product.getId());
        assertNull(none);

    }

    @Test

    public void GivenAvailableProductNameCheckIfGetsFound(){

        queryService = new ProductQueryServiceImpl();

        Product product = queryService.findByName("Samsung S21");
        Product none = queryService.findByName("111");

        assertEquals("Samsung S21", product.getName());
        assertNull(none);

    }


}
