package site.yangpan.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import site.yangpan.mail.service.MailService;

/**
 * 测试邮件发送controller
 * Created by yangpan on 2019-07-03 22:29.
 */
@RestController
@RequestMapping("/mail")
public class MailController {


    @Autowired
    private MailService mailService;

    @Autowired
    private SpringTemplateEngine templateEngine;

    /**
     * 发送简单纯文本邮件
     */
    @GetMapping("/sendSimpleMail")
    public String sendSimpleMail() {
        mailService.sendSimpleMail("792187705@qq.com", "发送邮件测试", "大家好，这是我用springboot进行发送邮件测试");
        return "成功发送简单纯文本邮件！";
    }

    /**
     * 发送HTML邮件
     */
    @GetMapping("/sendHtmlMail")
    public String sendHtmlMail() {
        String content = "<html><body><h3><font color=\"red\">" + "大家好，这是springboot发送的HTML邮件" + "</font></h3></body></html>";
        mailService.sendHtmlMail("792187705@qq.com", "发送邮件测试", content);
        return "成功发送HTML邮件！";
    }

    /**
     * 发送带附件的邮件
     */
    @GetMapping("/sendAttachmentMail")
    public String sendAttachmentMail() {
        String content = "<html><body><h3><font color=\"red\">" + "大家好，这是springboot发送的HTML邮件，有附件哦" + "</font></h3></body></html>";
        String filePath = "classpath:templates/hello.txt";
        mailService.sendAttachmentMail("792187705@qq.com", "发送邮件测试", content, filePath);
        return "成功发送带附件的邮件！";
    }

    /**
     * 发送带图片的邮件
     */
    @GetMapping("/sendInlineResourceMail")
    public String sendInlineResourceMail() {
        String rscPath = "classpath:templates/hello.png";
        String rscId = "skill001";
        String content = "<html><body><h3><font color=\"red\">" + "大家好，这是springboot发送的HTML邮件，有图片哦" + "</font></h3>"
                + "<img src=\'cid:" + rscId + "\'></body></html>";
        mailService.sendInlineResourceMail("792187705@qq.com", "发送邮件测试", content, rscPath, rscId);
        return "成功发送带图片的邮件！";
    }

    /**
     * 指定模板发送邮件
     */
    @GetMapping("/testTemplateMail")
    public String testTemplateMail() {
        // 向Thymeleaf模板传值，并解析成字符串
        Context context = new Context();
        context.setVariable("id", "001");
        String emailContent = templateEngine.process("emailTemplate.html", context);
        mailService.sendHtmlMail("792187705@qq.com", "这是一个模板文件", emailContent);
        return "成功发送指定模板发送邮件！";
    }
}
