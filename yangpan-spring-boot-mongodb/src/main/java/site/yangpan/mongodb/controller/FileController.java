package site.yangpan.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import site.yangpan.mongodb.entity.FileEntity;
import site.yangpan.mongodb.repository.FileRepository;
import site.yangpan.mongodb.util.MD5Util;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)//允许所有域名访问
@Controller
public class FileController {

    @Autowired
    private FileRepository fileRepository;
    
    @Value("${server.address}")
    private String serverAddress;
    
    @Value("${server.port}")
    private String serverPort;

    
    @RequestMapping(value = "/")
    public String index(Model model) {
    	// 展示最新二十条数据
        Page<FileEntity> page;
        List<FileEntity> list;

        Sort sort = new Sort(Sort.Direction.DESC,"uploadDate");
        Pageable pageable = new PageRequest(0, 20, sort);
        page = fileRepository.findAll(pageable);
        list = page.getContent();

        model.addAttribute("files", list);
        return "index";
    }

    /**
     * 分页查询文件
     * @param pageIndex
     * @param pageSize
     * @return
     */
	@GetMapping("files/{pageIndex}/{pageSize}")
    @ResponseBody
	public List<FileEntity> listFilesByPage(@PathVariable int pageIndex, @PathVariable int pageSize){
        Page<FileEntity> page;
        Sort sort = new Sort(Sort.Direction.DESC,"uploadDate");
        Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
        page = fileRepository.findAll(pageable);
		return page.getContent();
	}
			
    /**
     * 获取文件片信息
     * @param id
     * @return
     */
    @GetMapping("files/{id}")
    @ResponseBody
    public ResponseEntity<Object> serveFile(@PathVariable String id) {
        FileEntity fileEntity = fileRepository.findById(id).get();
        if (fileEntity != null) {
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + fileEntity.getFileName() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream" )
                    .header(HttpHeaders.CONTENT_LENGTH, fileEntity.getSize()+"")
                    .header("Connection",  "close") 
                    .body( fileEntity.getContent());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FileEntity was not fount");
        }

    }
    
    /**
     * 在线显示文件
     * @param id
     * @return
     */
    @GetMapping("/view/{id}")
    @ResponseBody
    public ResponseEntity<Object> serveFileOnline(@PathVariable String id) {
        FileEntity fileEntity = fileRepository.findById(id).get();
        if (fileEntity != null) {
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + fileEntity.getFileName() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, fileEntity.getContentType() )
                    .header(HttpHeaders.CONTENT_LENGTH, fileEntity.getSize()+"")
                    .header("Connection",  "close") 
                    .body( fileEntity.getContent());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FileEntity was not fount");
        }

    }
    
    /**
     * 上传
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
        	FileEntity f = new FileEntity(file.getOriginalFilename(),  file.getContentType(), file.getSize(), file.getBytes());
        	f.setMd5( MD5Util.getMD5(file.getInputStream()) );
        	fileRepository.save(f);
        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Your " + file.getOriginalFilename() + " is wrong!");
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/";
    }
 
    /**
     * 上传接口
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
    	FileEntity returnFileEntity = null;
        try {
        	FileEntity f = new FileEntity(file.getOriginalFilename(),  file.getContentType(), file.getSize(),file.getBytes());
        	f.setMd5( MD5Util.getMD5(file.getInputStream()) );
        	returnFileEntity = fileRepository.save(f);
        	String path = "//"+ serverAddress + ":" + serverPort + "/view/"+ returnFileEntity.getFileId();
        	return ResponseEntity.status(HttpStatus.OK).body(path);
 
        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
 
    }
    
    /**
     * 删除文件
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteFile(@PathVariable String id) {
    	try {
            fileRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("DELETE Success!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
}
