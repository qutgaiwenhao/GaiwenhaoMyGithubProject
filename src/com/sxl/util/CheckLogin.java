package com.sxl.util;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;

public class CheckLogin {
	
	public static boolean check(String host,String email,String password){
		Session session = null;
		Transport ts = null;
		Properties prop = new Properties();
        prop.setProperty("mail.host", host);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!1!!!!!!!!!!!!!!!");
        session = Session.getInstance(prop);
        session.setDebug(true);
        try {
			ts = session.getTransport();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			return false;
		}
        try{
        	ts.connect(host, email, password);
        }catch(Exception e){
        	e.printStackTrace();
        	return false;
        }finally{
        	try {
				ts.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
        }
        return true;
	}
}
