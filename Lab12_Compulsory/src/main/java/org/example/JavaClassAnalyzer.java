package org.example;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import org.testng.annotations.Test;

public class JavaClassAnalyzer {
    private static void processClass(File file) {
        try {
            String filePath = file.getAbsolutePath();
            URL url = file.getParentFile().toURI().toURL();
            URLClassLoader loader = URLClassLoader.newInstance(new URL[]{url});

            String className = filePath.substring(filePath.indexOf("target\\classes") + 15, filePath.length())
                    .replace(".class", "").replace("\\", ".");

            Class<?> cls = Class.forName(className, true, loader);

            System.out.println("Class Name: " + cls.getName());
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method Name: " + method.getName());
                System.out.println("Return Type: " + method.getReturnType().getName());
                System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
                System.out.println("Parameters: " + Arrays.toString(method.getParameterTypes()));
                System.out.println("Annotations: " + Arrays.toString(method.getAnnotations()));

                if (Modifier.isStatic(method.getModifiers())
                        && method.getAnnotation(Test.class) != null
                        && method.getParameterCount() == 0) {
                    method.setAccessible(true);
                    method.invoke(null);
                }
            }

            loader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File input = new File(args[0]);
        if (input.isFile() && input.getName().endsWith(".class")) {
            processClass(input);
        }
    }
}
