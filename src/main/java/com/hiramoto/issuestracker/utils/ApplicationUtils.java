package com.hiramoto.issuestracker.utils;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ApplicationUtils {

    public String getVersion() {
        String version = null;

        try {
            Properties properties = new Properties();
            InputStream is = getClass().getResourceAsStream("/META-INF/maven/com.hiramoto/issues-tracker/pom.properties");
            if (is != null) {
                properties.load(is);
                version = properties.getProperty("version");
            }
        } catch (Exception ex) {}

        Package myPkg = getClass().getPackage();
        if (myPkg != null) {
            version = myPkg.getImplementationVersion();
            if (version == null) {
                version = myPkg.getSpecificationVersion();
            }
        }

        if (version == null) {
            version = "";
        }

        return version;
    }

    public String getName() {
        String name = null;

        Package myPkg = getClass().getPackage();
        if (myPkg != null) {
            name = myPkg.getImplementationTitle();
        }

        if (name == null) {
            name = "";
        }
        return name;
    }
    
}
