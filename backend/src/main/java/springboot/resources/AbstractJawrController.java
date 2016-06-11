package springboot.resources;

import net.jawr.web.servlet.JawrSpringController;

/**
 * Created by aurelijus on 16.6.11.
 */
public class AbstractJawrController extends JawrSpringController {

    /**
     * Constructor
     */
    public AbstractJawrController(String type) {
        setConfigLocation("jawr.properties");
        setType(type);
    }

}
