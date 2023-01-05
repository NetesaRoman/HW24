package com.example.hw24.repositories;

import com.example.hw24.model.Product;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author Roman Netesa
 *
 */
@Value
public class ProductRepository {
    @Autowired
    List<Product> products = new ArrayList<>();

    public void showAll(){
        products.stream().forEach(Product::showInfo);
    }

    public Product getByID(int id){
        Product result = null;
        for(Product p: products){
            if(id == p.getId()){
                result = p;
            }
        }
        return result;
    }
}
