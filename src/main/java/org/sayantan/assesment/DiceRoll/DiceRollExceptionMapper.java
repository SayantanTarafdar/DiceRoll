package org.sayantan.assesment.DiceRoll;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class DiceRollExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		// TODO Auto-generated method stub
		
		//StringBuilder message = new StringBuilder();
		ArrayList<String> errorMessage=new ArrayList<>();
	    Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
	    if (violations != null) {
	        violations.forEach((violation) -> {
	            //message.append(violation.getPropertyPath().toString()+":"+violation.getMessage()).append(".");
	        	if(violation.getPropertyPath().toString().contains("roll.arg0")) {
	        		errorMessage.add("Dices :"+violation.getMessage());
	        	}
	        	if(violation.getPropertyPath().toString().contains("roll.arg1")) {
	        		errorMessage.add("Sides :"+violation.getMessage());
	        	}
	        	if(violation.getPropertyPath().toString().contains("roll.arg2")) {
	        		errorMessage.add("Rolls :"+violation.getMessage());
	        	}
	            
	        });
	    }
		return Response.status(Response.Status.BAD_REQUEST)
				.header("Content-Type", "application/json")
				.entity(errorMessage).build();
	}

}
