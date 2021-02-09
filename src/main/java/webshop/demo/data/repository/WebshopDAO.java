package webshop.demo.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import webshop.demo.data.mapper.ProductDescriptionMapper;
import webshop.demo.data.mapper.ProductMapper;
import webshop.demo.model.PictureLink;
import webshop.demo.model.Product;
import webshop.demo.model.ProductDescription;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebshopDAO {

    //Man burde nok lave det på seperate, det gør vi også normalt

    private final JdbcTemplate jdbcTemplate;
    private final ProductMapper productMapper = new ProductMapper();
    private final ProductDescriptionMapper productDescriptionMapper = new ProductDescriptionMapper();

    @Autowired
    public WebshopDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createProduct(Product product) {
        jdbcTemplate.update("INSERT into product (product_name, product_price) VALUES (?, ?)",
         product.getName(),
         product.getPrice()
        );
    }

        public void createDescription (ProductDescription productDescription) {
        jdbcTemplate.update("INSERT into product_description (product_description) VALUES (?)",
                productDescription.getDescription()
                );
        }

    public void createPictureLink (PictureLink pictureLink) {
        jdbcTemplate.update("INSERT into picture_link (picture_link) VALUES (?)",
                pictureLink.getLink()
        );
    }

    public Product getProduct(long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM product WHERE product_id = ?",
                productMapper,
                id
        );
    }

    public List<Product> getListOfProducts(){
        return jdbcTemplate.query(
                "SELECT * FROM product",
                productMapper
        );
    }

    public ProductDescription getProductDescription (long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM product_description WHERE product_description_id = ?",
                productDescriptionMapper
        );
    }

        public List<ProductDescription> getListOfProductDescription(){
            return jdbcTemplate.query("SELECT * FROM product_description",
                    productDescriptionMapper
            );
        }


    }









