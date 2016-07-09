package springboot.jawr;

import net.jawr.web.resource.bundle.generator.GeneratorContext;
import net.jawr.web.resource.bundle.generator.ResourceGenerator;
import net.jawr.web.resource.bundle.generator.TextResourceGenerator;
import net.jawr.web.resource.bundle.generator.resolver.PrefixedPathResolver;
import net.jawr.web.resource.bundle.generator.resolver.ResourceGeneratorResolver;
import springboot.utils.HtmlUtils;

import java.io.Reader;
import java.io.StringReader;

/**
 * Created by aurelijus on 16.7.9.
 */
public class CssAssetGenerator implements TextResourceGenerator {

    private ResourceGeneratorResolver resolver;

    public CssAssetGenerator(){
        this.resolver = new PrefixedPathResolver("cssasset");
    }

    public ResourceGeneratorResolver getResolver() {
        return resolver;
    }

    public String getDebugModeRequestPath() {
        return ResourceGenerator.JAVASCRIPT_DEBUGPATH;
    }

    @Override
    public Reader createResource(GeneratorContext context) {
        return new StringReader(HtmlUtils.cssWrite(new AssetInterpolator(context.getPath()).gather().getCssPath()));
    }


}
