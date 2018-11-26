package com.ssm.controller;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssm.util.Commons;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
@RequestMapping("/upload")
public class uploadController {
	//这里是商品的上传控制器
	@RequestMapping("uploadPic")
	public void uploadPic(HttpServletRequest request,String fileName,PrintWriter out){
		System.out.println("**********************");
		//request用于得到请求，filename用户获取文件名，PrintWriter 用于回写数据
		//把request转换成多部件的文件上传
		MultipartRequest mr = (MultipartRequest) request;
		//根据文件名获取文件对象
		CommonsMultipartFile cmf =    (CommonsMultipartFile) mr.getFile(fileName);
		//获取文件对象
		byte[] buf= cmf.getBytes();
		//为了防止文件名在服务器中有重复
		String newFileName ="";
		//创建一个时间格式
		SimpleDateFormat sdf  =new SimpleDateFormat("yyyyMMddhhmmssSSS");
		newFileName =  newFileName+sdf.format(new Date());
		//再加密一层
		Random r = new Random();
		for(int i=0;i<3;i++){
			newFileName = newFileName+r.nextInt(10);
		}
		//获取文件拓展名
		String extsion = cmf.getOriginalFilename();
		String suffix  =  extsion.substring(extsion.lastIndexOf('.'));
		//创建jesy服务器
		Client client = Client.create();
		//把文件关联到远程服务器
		WebResource resource = client.resource(Commons.PIC_Host+"/upload/"+newFileName+suffix);
		//把文件上传到服务器
		resource.put(String.class,buf);
		//ajax回调也需要图片的相对路径和绝对路径
		String fullPath = Commons.PIC_Host+"/upload/"+newFileName+suffix;
		//相对路径
		String relativePath  = "/upload/"+newFileName+suffix;
		//把数据拼成json格式的字符串
		String result="{\"fullPath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\"}";
		out.print(result);
	}
	
}
