package com.dianping.wizard.script;

import com.dianping.wizard.exception.WidgetException;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.io.File;
import java.util.Map;

/**
 * @author ltebean
 */
public class GroovyShellScriptEngine implements ScriptEngine{


    @Override
    public Object eval(String code, Map<String, Object> context) {
        Binding binding = new Binding();
        for(String key:context.keySet()){
            binding.setProperty(key,context.get(key));
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object eval(File file, Map<String, Object> context) {
        Binding binding = new Binding();
        for(String key:context.keySet()){
            binding.setProperty(key,context.get(key));
        }
        GroovyShell shell = new GroovyShell(binding);
        try {
            return shell.evaluate(file);
        } catch(Exception e) {
             throw new WidgetException("evaluation error",e);
        }

    }


}