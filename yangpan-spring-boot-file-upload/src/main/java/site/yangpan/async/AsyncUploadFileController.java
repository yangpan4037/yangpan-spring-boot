package site.yangpan.async;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异步上传文件处理
 * Created by yangpan on 2019-07-06 11:45.
 */
@RestController
@RequestMapping("/async")
public class AsyncUploadFileController {

    /**
     * 异步上传的页面
     * @return
     */
    @GetMapping("/page")
    public ModelAndView uploadPage(){
        ModelAndView mv = new ModelAndView("async.html");
        return mv;
    }

    /**
     * 单个上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity formUpload(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        if (file.isEmpty()) {
            result.put("success", false);
            result.put("message", "上传文件为空！");
        } else {
            result.put("success", true);
            result.put("message", "上传成功！"+file.getName()+file.getSize());
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 多个上传
     * @param files
     * @return
     */
    @PostMapping("/multiUpload")
    @ResponseBody
    public ResponseEntity multiUpload(@RequestParam("files") MultipartFile[] files) {
        Map<String, Object> result = new HashMap<>();
        String message = null;
        for(int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (file.isEmpty()) {
                message += "上传第" + (i++) + "个文件失败;";
            }
            String fileName = file.getOriginalFilename();
            try {
                message +=  "第" + (i + 1) + "个文件上传成功，文件名称：" + fileName;
                System.out.println("第" + (i + 1) + "个文件上传成功，文件名称：" + fileName);
            } catch (Exception e) {
                System.err.println(e.toString());
                message +=  "上传第" + (i++) + "个文件失败";
            }
        }
        result.put("success", true);
        result.put("message", message);
        return ResponseEntity.ok(result);
    }
}
