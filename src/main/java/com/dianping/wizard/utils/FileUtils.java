package com.dianping.wizard.utils;

import com.dianping.wizard.exception.WizardExeption;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.regex.Pattern;

/**
 * @author ltebean
 */
public class FileUtils {

    public static String readFileOnClassPath(final String fileName,final String extensions){
        String pattern=".*"+fileName+"."+extensions;
        try {
            Collection<String> paths=ResourceList.getResources(Pattern.compile(pattern));
            if(paths.size()>1){
                throw new WizardExeption("no distinct file: "+pattern);
            }
            if(paths.size()==0){
                return "";
            }
            File file = new File(paths.iterator().next());
            String result=org.apache.commons.io.FileUtils.readFileToString(file,"UTF-8");
            return result;
        } catch (IOException e) {
            throw new WizardExeption("reading file error: " + pattern ,e);
        }
    }

    public static String readFileOnClassPath(final String fileName, final String extensions, final String defaultValue){
        try {
            return readFileOnClassPath(fileName,extensions);
        } catch(Exception e) {
            return defaultValue;
        }
    }
}
