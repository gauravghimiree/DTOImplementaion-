package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repo.ProductRepo;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService  {


      @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public void save(Product product) {

        repo.save(product);

    }

    public Product getById(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public String updateProduct(Product product,Integer id) throws Exception {
        if(repo.findById(id).isPresent()) {
            product.setId(product.getId());
            repo.save(product);
            return"success";

        }
        else {

            throw new Exception("Product with ID " + id + " not found");

        }

    }

}
