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

    public void createProduct(Product product, PictureLink pictureLink, ProductDescription productDescription){
        webshopDAO.createProduct(product, pictureLink, productDescription);


    }

    public void updateProduct(Product product){
        webshopDAO.updateProduct(product);
    }

    public List<Product> getProductList(){
        return webshopDAO.getListOfProducts();
    }

    public Product getProduct(long id){
        return webshopDAO.getProduct(id);
    }




}
