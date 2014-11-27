package edu.utcn.ds.lab1.webservice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeZoneServlet  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	  protected void doGet(final HttpServletRequest req,
	    final HttpServletResponse resp) throws ServletException,
	    IOException {

	    PrintWriter out = resp.getWriter();
	    String response=
	    calculateResult(req.getParameter("x"));
	     out.write(response);
	  }


	public static String calculateResult(String x) {
		
	   
	    if(x!=null) {
	    double X=Double.parseDouble(x);
	    Integer respon=(((int)X)%360)/15-12;
	    StringBuilder response=new StringBuilder();
	    response.append(respon.toString());
	   return response.toString();}
	    
	    else  return "null";
	}

	
	  @Override
	  protected void doPost(final HttpServletRequest req,
	    final HttpServletResponse resp) throws ServletException,
	    IOException {

	    this.doGet(req, resp);
	  }
	
}
