package com.lovo.servlet;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.Enumeration;  
import java.util.HashMap;  
import java.util.Map;  
  
import javax.servlet.ServletException;  
import javax.servlet.ServletOutputStream;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import com.lovo.util.WordGenerator;

@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public myServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");  
        Map<String, Object> map = new HashMap<String, Object>();  
        Enumeration<String> paramNames = req.getParameterNames();  
        // ͨ��ѭ���������������ֵ��ӳ����  
        while(paramNames.hasMoreElements()) {  
            String key = paramNames.nextElement();  
            String value = req.getParameter(key);  
            map.put(key, value);  
        }  
      
        // ��ʾ���ڵ��ù���������Word�ĵ�֮ǰӦ����������ֶ��Ƿ�����  
        // ����Freemarker��ģ�������ڴ���ʱ���ܻ���Ϊ�Ҳ���ֵ������ ������ʱ�������������  
        File file = null;  
        InputStream fin = null;  
        ServletOutputStream out = null;  
        try {  
            // ���ù�����WordGenerator��createDoc��������Word�ĵ�  
            file = WordGenerator.createDoc(map, "resume");  
            fin = new FileInputStream(file);  
              
            resp.setCharacterEncoding("utf-8");  
            resp.setContentType("application/msword");  
            // ��������������صķ�ʽ������ļ�Ĭ����Ϊresume.doc  
            resp.addHeader("Content-Disposition", "attachment;filename=resume.doc");  
              
            out = resp.getOutputStream();  
            byte[] buffer = new byte[512];  // ������  
            int bytesToRead = -1;  
            int i = 0;
            // ͨ��ѭ���������Word�ļ�������������������  
            while((bytesToRead = fin.read(buffer)) != -1) {  
            	System.out.println(i+"��"+bytesToRead);
            	i++;
                out.write(buffer, 0, bytesToRead);  
            }  
        } finally {  
            if(fin != null) fin.close();  
            if(out != null) out.close();  
            if(file != null) file.delete(); // ɾ����ʱ�ļ�  
        }  
    }  
}
