package config;

import utils.CopyImage;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.awt.datatransfer.FlavorEvent;
import java.io.*;
import java.util.Properties;

//@WebFilter(filterName = "loadImages")
public class LoadImages implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        File productWebPath = new File(servletContext.getRealPath("/") + PathProperties.getINSTANCE().getPathProductWeb());
        System.out.println(productWebPath);
        if (!productWebPath.exists()) {
//            Copy file from path to path
            File productLocal = new File(PathProperties.getINSTANCE().getPathProductLocal());
            CopyImage.loadImage(productLocal, productWebPath);
        }
        chain.doFilter(request, response);
    }




}
 
