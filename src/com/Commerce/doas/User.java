package com.Commerce.doas;

import com.Commerce.dtos.LoginRes;
import com.Commerce.interfaces.UserF;
import com.Commerce.dtos.*;

public class User implements UserF{
	
	public LoginRes login(LoginReq lr){
		return new LoginRes();
	}
	public RegisterRes register(RegisterReq rr){
		
		return new RegisterRes();
	}
	
}
