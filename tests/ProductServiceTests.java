import org.junit.Test;
import products.baza.Product;
import products.service.ProductService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProductServiceTests {

    ProductService productService;

    @Test

    public void GivenAvailableDataCheckIfGetsLoaded(){

        productService = new ProductService();

        Product product= productService.findProductById(1);

        assertEquals(1, product.getId());



    }

    @Test

    public void afisareSortare(){

        productService = new ProductService();

        productService.afisare();
        productService.afisareLaptopuri();
        productService.afisareMonitor();
        productService.afisareSmartWatch();
        productService.afisareTelefoane();

        productService.sortareDupaPretCrescator();
        productService.sortareDupaPretDescrescator();

        int id = productService.generateId();

        productService.promoPaste();
        productService.promoCraciun();
        productService.anularePromoPaste();
        productService.anularePromoCraciun();
    }

    @Test

    public void GivenAvailableProductIdCheckIfGetsFound(){

        productService = new ProductService();

        Product product= productService.findProductById(1);
        Product none = productService.findProductById(11);

        assertEquals(1, product.getId());
        assertNull(none);

    }

    @Test

    public void GivenAvailableProductNameCheckIfGetsFound(){

        productService = new ProductService();

        Product product = productService.findByName("Samsung S21");
        Product none = productService.findByName("111");

        assertEquals("Samsung S21", product.getName());
        assertNull(none);

    }


}
