import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * Created by dkuzmich on 6/6/2017.
 */
@WebServlet("/UploadDownloadFileServlet")
@MultipartConfig(fileSizeThreshold = 1024*1024*1,
                 maxFileSize = 1024*1024*10,
                 maxRequestSize = 1024*1024*10)
public class UploadDownloadFileServlet extends HttpServlet {

    public String FilePatch=null;
    public static final String Upload_DIR="uploads";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get absolute path
        String applicationPath = req.getServletContext().getRealPath("");
        // construct path  of the directory to save uploaded file
        String uploadFilepath = applicationPath + File.separator + Upload_DIR;

        //create save dir if it is not exist

        File filesaveDir = new File(uploadFilepath);
        if (!filesaveDir.exists()) {
            filesaveDir.mkdirs();
        }

        System.out.println("Upload file Dir = " + filesaveDir.getAbsolutePath());
        FilePatch=filesaveDir.getAbsolutePath();

        String fileName = null;
        // Get all parts from request and write it to the file on server
        for (Part part : req.getParts()) {
          //  fileName = part.getName();
           fileName=extractFileName(part);
           fileName=new File(fileName).getName();
           part.write(FilePatch+File.separator+fileName);


        }

        req.setAttribute("message", fileName + " - File uploaded successfully");

        req.setAttribute("mFileInfo",FilePatch + File.separator+fileName  );



        getServletContext().getRequestDispatcher("/MyJSP.jsp").forward(req, resp);
    }
    private String extractFileName(Part part){
        String contentDisp=part.getHeader("content-disposition");
        String[] items=contentDisp.split(";");
        for(String s: items){
            if(s.trim().startsWith("filename")){
                return s.substring(s.indexOf("=")+2,s.length()-1);
            }
        }
        return "";
    }
/**
 * Utility method to get file name from HTTP header content-disposition
 */


    }

