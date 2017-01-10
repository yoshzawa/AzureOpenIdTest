package com.gmail.yoshzawa.h28jk3aopenidtest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MicrosoftRedirectServlet extends HttpServlet implements AzureConstant{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		String id_token = req.getParameter("id_token");
		String state = req.getParameter("state");
		String error = req.getParameter("error");
		String error_description = req.getParameter("error_description");
		
		resp.getWriter().println("id_token = " + id_token);
		resp.getWriter().println("state = " + state);
		resp.getWriter().println("error = " + error);
		resp.getWriter().println("error_description = " + error_description);
		
		
		
		
		
	}
}
