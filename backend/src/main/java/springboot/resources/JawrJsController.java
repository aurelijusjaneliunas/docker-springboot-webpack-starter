package springboot.resources;

import net.jawr.web.JawrConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aurelijus on 16.6.11.
 */
@Controller
public class JawrJsController extends AbstractJawrController {


    @Autowired
    private ServletContext servletContext;

    /**
     */
    public JawrJsController() {
        super(JawrConstant.JS_TYPE);
    }

    /* (non-Javadoc)
     * @see net.jawr.web.servlet.JawrSpringController#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        setServletContext(servletContext);
        super.afterPropertiesSet();
    }

    /* (non-Javadoc)
     * @see net.jawr.web.servlet.JawrSpringController#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    @RequestMapping(value = "/**/**.js", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        return super.handleRequest(request, response);
    }

}
