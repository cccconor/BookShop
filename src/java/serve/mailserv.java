/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;



import java.security.Security;
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
//        try{
//        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
//            //设置邮件会话参数
//            Properties props = new Properties();
//            //邮箱的发送服务器地址
//            props.setProperty("mail.smtp.host", "smtp.163.com");
//            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
//            props.setProperty("mail.smtp.socketFactory.fallback", "false");
//            //邮箱发送服务器端口,这里设置为465端口
//            props.setProperty("mail.smtp.port", "465");
//            props.setProperty("mail.smtp.socketFactory.port", "465");
//            props.put("mail.smtp.auth", "true");
//            final String username = "zhujunxin01@163.com";
//            final String password = "**************";
//            //获取到邮箱会话,利用匿名内部类的方式,将发送者邮箱用户名和密码授权给jvm
//             session = Session.getInstance(props, new Authenticator() {
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(username, password);
//                }
//            });
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        to = null;
//        from ="zhujunxin01@163.com";
//        host = "smtp.163.com";
//        properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", host);
//        properties.put("mail.smtp.auth", "true");
//        session = Session.getDefaultInstance(properties,new Authenticator(){
//            public PasswordAuthentication getPasswordAuthentication()
//            {
//                return new PasswordAuthentication("zhujunxin01@163.com","zjx781354338");
//            }
//        });
        
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
        try{
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            //设置邮件会话参数
            Properties props = new Properties();
            //邮箱的发送服务器地址
            props.setProperty("mail.smtp.host", "smtp.163.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            //邮箱发送服务器端口,这里设置为465端口
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.auth", "true");
            final String username = "zhujunxin01@163.com";
            final String password = "zjx781354338";
            //获取到邮箱会话,利用匿名内部类的方式,将发送者邮箱用户名和密码授权给jvm
             session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("zhujunxin01@163.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
            message.setSubject("图书商城激活码在这里，还等什么，赶紧去激活");
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
