package com.example.product_invetory.service;
import com.example.product_invetory.model.Product;
import com.example.product_invetory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product createProduct(Product product){
       return  repository.save(product);
    }

    @Override
    public Product getProductById(Long id){
       return repository.findById(id).orElse(null);

    }


    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedProduct.getName());
            existing.setDescription(updatedProduct.getDescription());
            existing.setQuantity(updatedProduct.getQuantity());
            existing.setPrice(updatedProduct.getPrice());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void  deleteProduct(Long id){
        repository.deleteById(id);
    }






}
