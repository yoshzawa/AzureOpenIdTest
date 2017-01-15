package com.gmail.yoshzawa.h28jk3aopenidtest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.*;

import org.apache.geronimo.mail.util.Base64;

import com.gmail.yoshzawa.h28jk3aopenidtest.jwt.OpenIdHeader;
import com.gmail.yoshzawa.h28jk3aopenidtest.jwt.OpenIdPayload;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class MicrosoftRedirectServlet extends HttpServlet implements
		AzureConstant {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");

		String id_token = req.getParameter("id_token");
		String state = req.getParameter("state");
		String error = req.getParameter("error");
		String error_description = req.getParameter("error_description");

		String[] tokens = id_token.split("\\.");
		resp.getWriter().println("split = " + tokens.length);

		resp.getWriter().println("id_token = " + id_token);
		resp.getWriter().println("state = " + state);
		resp.getWriter().println("error = " + error);
		resp.getWriter().println("error_description = " + error_description);

		String head = new String(Base64.decode(tokens[0]));
		resp.getWriter().println("head = " + head);
		Gson gson = new Gson();
		try {
			OpenIdHeader header = gson.fromJson(head, OpenIdHeader.class);
			resp.getWriter().println("typ = " + header.getTyp());
			resp.getWriter().println("alg = " + header.getAlg());
			resp.getWriter().println("kid = " + header.getKid());
		} catch (Exception e) {
		}

		try {
			String s = tokens[1];
			switch (s.length() % 4) {
			case 0:
				break;
			case 1:
				s += "===";
				break;
			case 2:
				s += "==";
				break;
			case 3:
				s += "=";
				break;
			}

			String payload = new String(Base64.decode(s));
			resp.getWriter().println("payload = " + payload);
			OpenIdPayload body = gson.fromJson(payload + "",
					OpenIdPayload.class);
			resp.getWriter().println("aud = " + body.getAud());
			resp.getWriter().println("iss = " + body.getIss());
			resp.getWriter().println("iat = " + body.getIat());
			resp.getWriter().println("nbf = " + body.getNbf());
			resp.getWriter().println("name = " + body.getName());
			resp.getWriter().println("exp = " + body.getExp());
			resp.getWriter().println("nonce = " + body.getNonce());
			resp.getWriter().println("oid = " + body.getOid());
			resp.getWriter().println(
					"preferred_username = " + body.getPreferredUsername());
			resp.getWriter().println("sub = " + body.getSub());
			resp.getWriter().println("tid = " + body.getTid());
			resp.getWriter().println("ver = " + body.getVer());
		} catch (Exception e) {
		}

	}
}
