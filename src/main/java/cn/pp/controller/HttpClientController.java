/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.pp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author zhangjinci
 * @version 2016/9/13 9:50
 * @function
 */
@RestController
public class HttpClientController {


    @RequestMapping(value = "http/get.html", method = RequestMethod.GET)
    public String get(@RequestParam("id") String id, @RequestParam("name") String name) {
        System.out.println("id==>" + id);
        System.out.println("name==>" + name);
        return "success";
    }

    @RequestMapping(value = "http/post.html", method = RequestMethod.POST)
    public String post(@RequestParam("id") String id, @RequestParam("name") String name) {
        System.out.println("id==>" + id);
        System.out.println("name==>" + name);
        return "success";
    }

    @RequestMapping(value = "http/multi.html", method = RequestMethod.POST)
    public String multi(@RequestParam(value = "id",required = false) String id, @RequestParam(value = "name",required = false) String name, HttpServletRequest request) {
        System.out.println("id==>" + id);
        System.out.println("name==>" + name);
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iterator = multiRequest.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile file = multiRequest.getFile(iterator.next());
                if (file != null) {
                    String fileName = file.getOriginalFilename();
                    if (fileName != null && !"".equals(fileName.trim())) {
                        System.out.println("上传的文件名:==>" + fileName);
                        String finalName = "uploadDemo//" + fileName;
                        String path = "D://" + finalName;
                        File localFile = new File(path);
                        if (!localFile.exists()) {
                            localFile.mkdirs();
                        }
                        try {
                            file.transferTo(localFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "success";
    }
}
