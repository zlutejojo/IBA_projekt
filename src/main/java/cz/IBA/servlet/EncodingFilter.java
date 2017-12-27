package cz.IBA.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * nastavení kódování pro diakritiku (použito v zobrazení výstupu formuláře v studentResult.jsp)
 * zdroj: https://stackoverflow.com/questions/33941751/html-form-does-not-send-utf-8-format-inputs/
 */

public class EncodingFilter implements Filter {
    private String encoding = "UTF-8";
    private boolean forceEncoding = false;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        if(forceEncoding){ //If force encoding is set then it means that set response stream encoding as well ...
            response.setCharacterEncoding(encoding);
        }
        filterChain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingParam = filterConfig.getInitParameter("encoding");
        String forceEncoding = filterConfig.getInitParameter("forceEncoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }
        if (forceEncoding != null) {
            this.forceEncoding = Boolean.valueOf(forceEncoding);
        }
    }


    public void destroy() {
        // TODO Auto-generated method stub

    }
}
