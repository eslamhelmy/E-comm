package com.Commerce.doas;
import java.util.ArrayList;

import com.Commerce.bean.ProductBean;

public interface ProductInterface {
	
	ArrayList<ProductBean>getProductList();
	
	ProductBean getProductById (int id);
	
    void addProduct(ProductBean product);
    
    void editProduct(ProductBean product);
    
    void deleteProduct(ProductBean product);

}
