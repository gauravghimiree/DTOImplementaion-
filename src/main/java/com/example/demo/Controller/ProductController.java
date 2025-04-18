package com.example.demo.Controller;


import com.example.demo.DTO.ProductDTO;
import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RestController
public class ProductController {

   @Autowired
   ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String saveProduct(@RequestBody ProductDTO product) {
       Product p= modelMapper.map(product, Product.class);
       productService.save(p);
        return "success";
    }
    @GetMapping("/lists")
    public List<ProductDTO> getProducts() {
      List < Product> products = productService.getAllProducts();
      return products
              .stream()
              .map(p->modelMapper.map(p,ProductDTO.class))
              .collect(Collectors.toList());

    }
    @GetMapping("list/{id}")
    public ProductDTO getProduct(@PathVariable int id) {
        Product product= productService.getById(id);
        return modelMapper.map(product,ProductDTO.class);
    }
  @PutMapping("/update/{id}")
    public String updateProduct(@RequestBody ProductDTO product , @PathVariable int id) throws Exception {
        Product p= modelMapper.map(product, Product.class);
        productService.updateProduct(p,id);
        return "success";

  }

    }

