//package front;
//
//import java.sql.Date;
//
//
//
//public class DateValidator {
//	public Date validate(String value) {
//		int day=-1,month=-1,year=-1;
//	      String[] values = value.toString().split("[ /\\,:.]");
//	      if(values.length==3){
//	      try{
//	    	  day=Integer.parseInt(values[0]);
//	    	  month=Integer.parseInt(values[1]);
//	    	  year=Integer.parseInt(values[2]);
//	      }catch(NumberFormatException | NullPointerException e) {
//	    	  return Date.v  LocalDate
//	      }
//	      if(!(day<=31 && day >0 &&  month <=12 && month >0 && year <2010 && year >1850)) { FacesMessage msg =
//		            new FacesMessage("Wrong format!","Try dd/mm/yyyy");
//		         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//		         throw new ValidatorException(msg);}
//	      }
//	      else {FacesMessage msg =
//		            new FacesMessage("Wrong format!","Try dd/mm/yyyy");
//		         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//		         throw new ValidatorException(msg);}}
//
//}
