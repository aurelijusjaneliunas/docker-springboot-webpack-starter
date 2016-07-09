package springboot.jawr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by aurelijus on 16.7.9.
 */
public class AssetInterpolator {

    private final static String DEFAULT_ASSET_PATH = "/app/assets.json";

    private String assetPath;
    private Map assetMap;
    private Boolean active = Boolean.FALSE;

    public AssetInterpolator(){
        this.assetPath = DEFAULT_ASSET_PATH;
    }

    public AssetInterpolator(String assetPath){
        this.assetPath = assetPath;
    }

    public AssetInterpolator gather(){
        this.assetMap = new GsonBuilder().create().fromJson(getJsonString(), Map.class);
        return this;
    }

    private String getJsonString(){
        if (StringUtils.isEmpty(assetPath) && new File(assetPath).exists()){
            return null;
        }
        InputStream assetContent = null;
        String assetContentStr = null;
        try {
            assetContent = new FileInputStream(assetPath);
            assetContentStr = IOUtils.toString(assetContent, Charset.defaultCharset());
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        } finally {
            if (assetContent != null){
                IOUtils.closeQuietly(assetContent);
            }
        }
        if (StringUtils.isNoneEmpty(assetContentStr)){
            active = Boolean.TRUE;
        }
        return assetContentStr;
    }

    public Boolean isActive(){
        return active;
    }

    public String getJsPath(){
        if (assetMap == null){
            return null;
        }
        return (String)((Map)assetMap.get("main")).get("js");
    }

    public String getCssPath(){
        if (assetMap == null){
            return null;
        }
        return (String)((Map)assetMap.get("main")).get("css");
    }


}
