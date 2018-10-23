package com.tdtk.springcloud.controller;

import com.tdtk.springcloud.utils.FastDFSClient;
import com.tdtk.springcloud.utils.FastDFSFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/upload")
public class UploadController {
    private static Logger logger = LoggerFactory.getLogger(UploadController.class);

    /**
     * 上传入口页面
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "upload";
    }

    /**
     * 文件上传接口
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/upload") //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/upload/uploadStatus";
        }
        try {
            // Get the file and save it somewhere
            String path=this.saveFile(file);//调用上传的通用方法

            //将返回的url放到域对象，展示到页面，通过${}方式获取
            redirectAttributes.addFlashAttribute("message","You successfully uploaded '" + file.getOriginalFilename() + "'");
            redirectAttributes.addFlashAttribute("path", path );
        } catch (Exception e) {
            logger.error("upload file failed",e);
        }
        return "redirect:/upload/uploadStatus";//重定向到  /upload/uploadStatus 方法
    }

    //跳转到上传状态展示页面
    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    /**
     * 执行上传的save方法
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public String saveFile(MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath={};
        String fileName=multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream=multipartFile.getInputStream();
        if(inputStream!=null){
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
        try {
            fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
        } catch (Exception e) {
            logger.error("upload file Exception!",e);
        }
        if (fileAbsolutePath==null) {
            logger.error("upload file failed,please upload again!");
        }

        // IP:8888/group1/M00/00/00/rBGTU1vM5T-AUdO-AAYADVuGXqo996.jpg
//        String path=FastDFSClient.getTrackerUrl()+":8888"+File.separator +fileAbsolutePath[0]+ File.separator +fileAbsolutePath[1];
        String path=FastDFSClient.getTrackerUrl()+fileAbsolutePath[0]+ "/" +fileAbsolutePath[1];
        return path;
    }
}