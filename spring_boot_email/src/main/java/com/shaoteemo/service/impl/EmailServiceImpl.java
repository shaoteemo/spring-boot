package com.shaoteemo.service.impl;

import com.shaoteemo.constants.BaseConstant;
import com.shaoteemo.service.EmailService;
import com.shaoteemo.util.TemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 所属项目：spring_boot
 * 所属包：com.shaoteemo.service.impl
 * <p>
 * 下面两种邮件发送接口均为JavaMail扩展接口。
 * 其中{@link org.springframework.mail.javamail.JavaMailSender}为{@link org.springframework.mail.MailSender}的子接口,功能更加丰富。可包含附件发送等。
 * 邮件回话{@link javax.mail.Session}一些原始的参数信息也在该会话中设置。（PS：这些参数的说明目前还没在文档中有找到）
 * 提示：推荐使用异步发送邮件。
 *
 * @author ShaoTeemo
 * @date 2021/7/18
 * @since 1.3
 */
@Service
public class EmailServiceImpl implements EmailService {

    /*简单实现的发送邮件*/
    @Autowired
    private MailSender mailSender;

    /*更丰富的邮件内容发送*/
    @Autowired
    private JavaMailSender javaMailSender;

    /*发送人*/
    @Value("${spring.mail.username:XXX@XXX.com}")
    private String fromUser;

    @Autowired
    private TemplateUtil templateUtil;

    /**
     * 使用MimeMessage发送邮件
     *
     * @param subject
     * @param msg
     * @param address
     * @return
     * @throws Exception
     */
    @Override
    public boolean sendMimeEmail(String subject, String msg, String address) throws Exception {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
        mimeMessage.setFrom(this.fromUser);
        mimeMessage.setText(msg);
        mimeMessage.setSubject(subject);
        mimeMessage.setSentDate(new Date());
        try {
            this.javaMailSender.send(mimeMessage);
            return true;
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 使用MimeMessageHelper发送Thymeleaf模板Html邮件
     *
     * @param subject
     * @param msg
     * @param address
     * @return
     * @throws Exception
     */
    @Override
    public boolean sendMimeHelperHtmlEmail(String subject, String msg, String... address) throws Exception {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        /*创建支持替代文本、内联元素和附件的多部分消息*/
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        /*收件人*/
        mimeMessageHelper.setTo(address);
        /*发件人*/
        mimeMessageHelper.setFrom(this.fromUser);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setSentDate(new Date());
        mimeMessageHelper.setReplyTo(this.fromUser);
        /*模板填充的参数*/
        Map<String, Object> variables = new HashMap<>();
        variables.put("hello", msg);
        /*设置为Html文本*/
        mimeMessageHelper.setText(this.templateUtil.getThymeLeafTemplate(BaseConstant.SEND_EMAIL_TEMPLATE, variables), true);
        try {
            this.javaMailSender.send(mimeMessage);
            return true;
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通邮件发送
     *
     * @param subject
     * @param msg
     * @param address
     * @return
     */
    @Override
    public boolean sendEmail(String subject, String msg, String... address) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(this.fromUser);
        simpleMailMessage.setTo(address);
        simpleMailMessage.setText(msg);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setSentDate(new Date());
        try {
            this.mailSender.send(simpleMailMessage);
            return true;
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }
    }
}
