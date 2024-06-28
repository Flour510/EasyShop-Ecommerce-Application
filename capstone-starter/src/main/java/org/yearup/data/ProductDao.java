package org.yearup.data;

import org.yearup.models.Product;
import java.math.BigDecimal;
import java.util.List;

public interface ProductDao
{
    // method to search for products based on category ID, minimum price, maximum price, and color
    List<Product> search(Integer categoryId, BigDecimal minPrice, BigDecimal maxPrice, String color);

    // method to list all products by category ID
    List<Product> listByCategoryId(int categoryId);

    // method to get a product by its ID
    Product getById(int productId);

    // method to create a new product
    Product create(Product product);

    // method to update an existing product by its ID
    void update(int productId, Product product);

    // method to delete a product by its ID
    void delete(int productId);
}
