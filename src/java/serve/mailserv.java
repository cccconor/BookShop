/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;



import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;



/**
 *
 * @author ZJX
 */
public class mailserv {
    
    private String to;
    private String from;
    private String host;
    private Properties properties;
    private Session session;
    private String content;
    
    
    public mailserv()
    {
        to = null;
        from ="zhujunxin01@163.com";
        host = "smtp.163.com";
        properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("zhujunxin01@163.com","***********");
            }
        });
        
    }
    public void setto(String s)
    {
        this.to=s;
    }
    public String getto()
    {
        return to;
    }
    public void setcontent(String s)
    {
        this.content=s;
    }
    
    
    public boolean send()
    {
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("zheshiyifengyoujian");
            message.setContent(content, "text/html;charset=utf-8");
            Transport.send(message);
            System.out.println("massage successfully send!");
            return true;
        } catch (AddressException ex) {
            Logger.getLogger(mailserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(mailserv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
