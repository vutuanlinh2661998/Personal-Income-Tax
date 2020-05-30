/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author BVCN 88
 */
public class SendEmailActivation {
    
  

    
    public static void sendEmail (String recepient,String activationCode) throws MessagingException{
     Properties properties = new Properties();
     properties.put("mail.smtp.auth","true");
     properties.put("mail.smtp.starttls.enable","true");
     properties.put("mail.smtp.host","smtp.gmail.com");
     properties.put("mail.smtp.port","587");
     
     String myAccount = "vutuanlinh99@gmail.com";
     String password = "namdinh123";
     
     Session session = Session.getDefaultInstance(properties, new Authenticator() {
         @Override
          protected PasswordAuthentication  getPasswordAuthentication (){
              return new PasswordAuthentication(myAccount, password);
          }
         
});
   Message message = prepareMessage(session, myAccount,recepient,activationCode);     
   Transport.send(message);

    }

     //compose the message  
      
    public static void main(String[] args) throws MessagingException {
        SendEmailActivation.sendEmail("vandung815@gmail.com","34nhuo3333dd");
        System.out.println("message sent successfully....");
    }

    private static Message prepareMessage(Session session, String email,String recepient,String activationCode) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Hello!");
            message.setText("Your activation code: "+ activationCode );
            return  message;
            
        } catch (Exception e) {
        }
        return  null;
    }
        
  }

