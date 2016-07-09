package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import springboot.jawr.AssetInterpolator;

@SpringBootApplication(exclude = SessionAutoConfiguration.class)
public class BootApplication {

  public static void main(String[] args) {
    addAssetProps();
    SpringApplication.run(BootApplication.class, args);
  }

  private static void addAssetProps(){
    AssetInterpolator assetInterpolator = new AssetInterpolator().gather();
    if (assetInterpolator.isActive()){
      System.setProperty("prod_js", assetInterpolator.getJsPath());
      System.setProperty("prod_css", assetInterpolator.getCssPath());
    }
  }

}
