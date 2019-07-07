package site.yangpan.download;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

/**
 * 根据模板下载controller
 * Created by yangpan on 2019-07-06 14:20.
 */
@Controller
@RequestMapping("/template")
public class TemplateDownController {

    @GetMapping("/word")
    public void export2(HttpServletResponse response) throws Exception{
        String filename = new String("测试".getBytes("GBK"), "ISO-8859-1");
        response.setHeader("Content-disposition", "attachment; filename=" + filename + ".docx");
        File file = ResourceUtils.getFile("classpath:download/hello.docx");
        FileInputStream in = new FileInputStream(file);
        ServletOutputStream out = response.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        while((len = in.read(b)) != -1){
            out.write(b, 0, len);
        }
        out.close();
        in.close();
    }
}