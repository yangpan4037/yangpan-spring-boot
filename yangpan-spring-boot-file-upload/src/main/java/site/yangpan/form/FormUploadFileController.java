package site.yangpan.form;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 表单上传文件处理controller
 * Created by yangpan on 2019-07-06 11:43.
 */
@Controller
@RequestMapping("/form")
public class FormUploadFileController {

    /**
     * 表单上传页面
     * @return
     */
    @GetMapping("/page")
    public String uploadPage() {
        return "form.html";
    }

    /**
     * 处理表单上传
     * 如果需要重定向到其他页面：去掉@ResponseBody，并return "redirect:/xxx";
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity formUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("上传文件为空", HttpStatus.FAILED_DEPENDENCY);
        } else {
            return ResponseEntity.ok("上传成功！" + file.getName() + file.getSize());
        }
    }

    /**
     * 多个文件上传
     * @param files
     * @return
     */
    @PostMapping("/multiUpload")
    @ResponseBody
    public String multiUpload(@RequestParam("files") MultipartFile[] files) {
        for(int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }
            String fileName = file.getOriginalFilename();
            try {
                System.out.println("第" + (i + 1) + "个文件上传成功，文件名称：" + fileName);
            } catch (Exception e) {
                System.err.println(e.toString());
                return "上传第" + (i++) + "个文件失败";
            }
        }
        return "上传成功";
    }

}
