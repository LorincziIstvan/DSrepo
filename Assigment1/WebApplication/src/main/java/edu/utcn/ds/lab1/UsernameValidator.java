package edu.utcn.ds.lab1;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import edu.utcn.ds.lab1.backend.Persistence;


@FacesValidator("edu.utcn.ds.lab1.usernamevalidator")
public class UsernameValidator implements Validator {


	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
	      String username = value.toString();
	      
	      Persistence connection=new Persistence();
	      if(connection.exists(username)) { FacesMessage msg =
		            new FacesMessage("user already exists","taken");
		         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		         throw new ValidatorException(msg);}
	      }
}

