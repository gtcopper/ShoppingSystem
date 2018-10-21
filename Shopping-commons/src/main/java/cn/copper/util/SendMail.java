package cn.copper.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {
    //1、创建连接对象，连接到邮件服务器
    //2、创建邮件对象
    //3、发送邮件
    public static void sendMail(String to) throws Exception {
        //1、创建连接对象，连接到邮件服务器
        //设置一些信息 我们发送服务器的信息
        Properties props = new Properties();
//        props.setProperty("host","127.0.0.1");//主机--本地可以省略
        Session session = Session.getInstance(props, new Authenticator() {
            //认证信息
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //通过这个用户名密码登录到我们的邮箱服务器
                return new PasswordAuthentication("720491585@qq.com","");
            }
        });

        //2、创建邮件对象
        Message message = new MimeMessage(session);
        //2.1设置发件人
        message.setFrom(new InternetAddress("720491585@qq.com"));
        //2.2设置收件人
        //Message.RecipientType.TO 发送给谁，接收方
        //Message.RecipientType.CC 抄送
        //Message.RecipientType.BCC 暗送
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        //2.3设置邮件主题
        message.setSubject("来自XXX的激活邮件");
        //2.4设置邮件正文
        message.setContent("正文内容","text/html;charset=UTF-8");

        //3、发送邮件
        Transport.send(message);
    }
}
