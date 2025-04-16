package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService  {


      @Autowired
    ProductRepo repo;
      @Autowired
      Product products;
    public List<Product> listAll() {
        return repo.findAll();
    }

    public void save(Product product) {

        products.setName(product.getName());
       products.setPrice(product.getPrice());
        repo.save(products);

    }

    public Product get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
