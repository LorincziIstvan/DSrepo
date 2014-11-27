package edu.utcn.ds.lab1;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;



@FacesValidator("edu.utcn.ds.lab1.datevalidator")
public class DateValidator implements Validator {


	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		int day=-1,month=-1,year=-1;
	      String[] values = value.toString().split("[ /\\,:.]");
	      if(values.length==3){
	      try{
	    	  day=Integer.parseInt(values[0]);
	    	  month=Integer.parseInt(values[1]);
	    	  year=Integer.parseInt(values[2]);
	      }catch(NumberFormatException | NullPointerException e) {
	    	   FacesMessage msg =
			            new FacesMessage("Wrong format!","Try dd/mm/yyyy");
			         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			         throw new ValidatorException(msg);
	      }
	      if(!(day<=31 && day >0 &&  month <=12 && month >0 && year <2010 && year >1850)) { FacesMessage msg =
		            new FacesMessage("Wrong format!","Try dd/mm/yyyy");
		         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		         throw new ValidatorException(msg);}
	      }
	      else {FacesMessage msg =
		            new FacesMessage("Wrong format!","Try dd/mm/yyyy");
		         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		         throw new ValidatorException(msg);}}
	
}

