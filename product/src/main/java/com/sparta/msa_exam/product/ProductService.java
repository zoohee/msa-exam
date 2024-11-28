package com.sparta.msa_exam.product;


import com.sparta.msa_exam.product.dto.request.AddProductRequest;
import com.sparta.msa_exam.product.dto.response.AddProductResponse;
import com.sparta.msa_exam.product.dto.response.GetProductResponse;
import com.sparta.msa_exam.product.dto.response.GetProductsResponse;
import com.sparta.msa_exam.product.entity.Product;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public AddProductResponse addProduct(AddProductRequest request) {
        Product product = productRepository.save(Product.create(request));
        return AddProductResponse.from(product);
    }


    public GetProductsResponse getProducts() {
        List<Product> products = productRepository.findAll();
        return GetProductsResponse.from(products);
    }

    public GetProductResponse getProduct(Long id) {
        return GetProductResponse.from(productRepository.getById(id));
    }
}
