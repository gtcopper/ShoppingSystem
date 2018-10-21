package cn.copper.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 文件上传工具类
 * @author haojie
 * @date 2018/07/20
 */
public class FileUploadUtil {
    /**
     * @param request HttpServletRequest对象
     * @return文件名称及路径的map集合
     */
    public static Map<String,String> getMultipartFile(HttpServletRequest request){
        Map<String,String> fileMap = new HashMap<>();
        long  startTime = System.currentTimeMillis();
        //上传的路径位置
        String path = "E:/springUpload";
        String tempPath = "E:/springUpload";
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext()
        );
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iterator = multiRequest.getFileNames();
            while (iterator.hasNext()){
                String fileName = iterator.next().toString();
                MultipartFile file = multiRequest.getFile(fileName);
                if (file != null){
                    path += file.getOriginalFilename();
                    fileMap.put(fileName,path);
                    try {
                        file.transferTo(new File(path));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    path = tempPath;
                }
            }
        }
        return  fileMap;
    }
}
