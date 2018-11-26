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
	//��������Ʒ���ϴ�������
	@RequestMapping("uploadPic")
	public void uploadPic(HttpServletRequest request,String fileName,PrintWriter out){
		System.out.println("**********************");
		//request���ڵõ�����filename�û���ȡ�ļ�����PrintWriter ���ڻ�д����
		//��requestת���ɶಿ�����ļ��ϴ�
		MultipartRequest mr = (MultipartRequest) request;
		//�����ļ�����ȡ�ļ�����
		CommonsMultipartFile cmf =    (CommonsMultipartFile) mr.getFile(fileName);
		//��ȡ�ļ�����
		byte[] buf= cmf.getBytes();
		//Ϊ�˷�ֹ�ļ����ڷ����������ظ�
		String newFileName ="";
		//����һ��ʱ���ʽ
		SimpleDateFormat sdf  =new SimpleDateFormat("yyyyMMddhhmmssSSS");
		newFileName =  newFileName+sdf.format(new Date());
		//�ټ���һ��
		Random r = new Random();
		for(int i=0;i<3;i++){
			newFileName = newFileName+r.nextInt(10);
		}
		//��ȡ�ļ���չ��
		String extsion = cmf.getOriginalFilename();
		String suffix  =  extsion.substring(extsion.lastIndexOf('.'));
		//����jesy������
		Client client = Client.create();
		//���ļ�������Զ�̷�����
		WebResource resource = client.resource(Commons.PIC_Host+"/upload/"+newFileName+suffix);
		//���ļ��ϴ���������
		resource.put(String.class,buf);
		//ajax�ص�Ҳ��ҪͼƬ�����·���;���·��
		String fullPath = Commons.PIC_Host+"/upload/"+newFileName+suffix;
		//���·��
		String relativePath  = "/upload/"+newFileName+suffix;
		//������ƴ��json��ʽ���ַ���
		String result="{\"fullPath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\"}";
		out.print(result);
	}
	
}
