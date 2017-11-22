package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Call;
import com.example.demo.model.Dispatcher;
import com.example.demo.model.ResultInfo;
import com.example.demo.model.User;

/**
 * Servicios rest disponibles para consumir contra el dispatcher
 * @author martin
 *
 */
@RestController
public class CallDispatchController {

	
	@RequestMapping(value = "/incomeCall", method = RequestMethod.POST )
	public ResponseEntity<String> resolveCallPost(HttpSession session,@RequestBody User user) {
  	
		String id = (session.getId()+user.getName());
    	Call call = new Call(id,user);
		return resolve(call);
    }
    
	@RequestMapping(value = "/incomeCall/{userName}", method = { RequestMethod.GET, RequestMethod.POST } )
	public ResponseEntity<String> resolveCallGet(HttpSession session,@PathVariable String userName) {
  	
    	String id = (session.getId()+userName);
    	User user = new User(userName);
    	Call call = new Call(id,user);
    	return resolve(call);
    }
	
	
	private ResponseEntity<String> resolve(Call call){
    	
	  	Dispatcher d = new Dispatcher();
	  	ResultInfo rI = d.dispatchCall(call);
	  	if (rI.isResult()){
	  		return new ResponseEntity<String>(rI.getMessage(), HttpStatus.OK);
	  	}
	  	return new ResponseEntity<String>(rI.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);	

	}

}
