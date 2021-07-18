package com.shaoteemo.service;

import javax.mail.internet.AddressException;

/**
 * 所属项目：spring_boot
 * 所属包：com.shaoteemo.service
 *
 * @author ShaoTeemo
 * @date 2021/7/18
 * @since 1.0
 */
public interface EmailService {

    boolean sendEmail(String subject , String msg , String ... address);

    boolean sendMimeEmail(String subject , String msg , String address) throws Exception;

    boolean sendMimeHelperHtmlEmail(String subject , String msg , String ... address);

}
