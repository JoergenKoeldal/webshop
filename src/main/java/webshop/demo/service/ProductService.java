package webshop.demo.service;

import org.springframework.stereotype.Service;
import webshop.demo.data.repository.WebshopDAO;
import webshop.demo.model.PictureLink;
import webshop.demo.model.Product;
import webshop.demo.model.ProductDescription;

import java.util.List;

@Service
public class ProductService {

    private final WebshopDAO webshopDAO;

    public ProductService(WebshopDAO webshopDAO) {
        this.webshopDAO = webshopDAO;
    }

    public void createProduct(Product product){
        webshopDAO.createProduct(product);

    }

    public void createProductDescription(ProductDescription productDescription) {
        webshopDAO.createDescription(productDescription);
    }

    public void createPictureLink(PictureLink pictureLink) {
        webshopDAO.createPictureLink(pictureLink);
    }

    public List<Product> getProductList(){
        return webshopDAO.getListOfProducts();
    }

    public Product getProduct(long id){
        return webshopDAO.getProduct(id);
    }




}
