package com.Commerce.doas;

import java.util.ArrayList;

import com.Commerce.bean.OrderBean;

public interface OrderInterface {
	int addOrder(OrderBean order);
	public ArrayList<OrderBean> getOrder();
}
