package com.Commerce.doas;

import com.Commerce.bean.UserBean;
import com.Commerce.dtos.LoginReq;

public interface UserInterface {

	int save(UserBean userBean);
	boolean LoginValidate(LoginReq loginrequest);
	
}
