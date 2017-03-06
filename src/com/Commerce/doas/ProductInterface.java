package com.Commerce.doas;
import java.util.ArrayList;
import java.util.List;

import com.Commerce.bean.ProductBean;

public interface ProductInterface {
	
	List<ProductBean>getProductList();
	
	ProductBean getProductById (int id);
	
    int addProduct(ProductBean product);
    
    void editProduct(ProductBean product);
    
    int deleteProduct(int id);

}
