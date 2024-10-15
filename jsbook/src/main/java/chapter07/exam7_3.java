package chapter07;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/7_3")
public class exam7_3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("연결");
		req.getRequestDispatcher("chapter7/7_3.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		try {
			
			String FileUploadPath="D:\\HHJ\\JSP\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jsbook\\img";
			DiskFileUpload	upload=new DiskFileUpload();
			List items=upload.parseRequest(req);
			FileItem fileItem;
			Iterator params=items.iterator();
			while (params.hasNext()){
				fileItem=(FileItem) params.next();
				if(!fileItem.isFormField()) {
					String fileName=fileItem.getName();
					fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
					File file =new File(FileUploadPath+"/"+fileName);
					fileItem.write(file);
					req.setAttribute("aa", fileItem.getName());
				}
			}
			
			req.getRequestDispatcher("chapter7/7_3_1.jsp").forward(req, resp);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}
	
}
