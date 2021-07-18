package com.shaoteemo.controller;

import com.shaoteemo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所属项目：spring_boot
 * 所属包：com.shaoteemo.controller
 *
 * @author ShaoTeemo
 * @date 2021/7/18
 * @since 1.0
 */
@RestController
public class MailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/simple/{sub}/{msg}/{address}")
    public Object sendEmail(@PathVariable String sub , @PathVariable String msg , @PathVariable String address){
        return this.emailService.sendEmail(sub, msg, address);
    }

    @GetMapping("/mime/{sub}/{msg}/{address}")
    public Object sendMimeEmail(@PathVariable String sub , @PathVariable String msg , @PathVariable String address) throws Exception {
        return this.emailService.sendMimeEmail(sub, msg, address);
    }

    @GetMapping("/mimeHtml/{sub}/{msg}/{address}")
    public Object sendMimeHelperHtmlEmail(@PathVariable String sub , @PathVariable String msg , @PathVariable String address) throws Exception {
        return this.emailService.sendMimeHelperHtmlEmail(sub, msg, address);
    }

}
