package com.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

public class SolutionScanner {

    public static final List<String> packages;

    static{
        packages = new ArrayList<String>();
        packages.add("com.topic.array");
    }

    public static void scan(String pkg) throws IOException, ClassNotFoundException {

        Set<Class<?>> classSet = new HashSet<Class<?>>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String pkgPath =  pkg.replace('.', '/');
        Enumeration<URL> urlEs = classLoader.getResources(pkgPath);
        while (urlEs.hasMoreElements()) {
            URL url = urlEs.nextElement();
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                findAndAddClassesInPackageByFile(pkg, filePath, classLoader, classSet);
            }
        }

        for(Class clz: classSet){
            answer(clz);
        }

    }

    public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, ClassLoader classLoader, Set<Class<?>> classes) throws ClassNotFoundException {

        File dir = new File(packagePath);

        File[] dirfiles = dir.listFiles(new FileFilter() {

            public boolean accept(File file) {
                return (file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });

        for(File f : dirfiles){
            String className = f.getName().substring(0, f.getName().length() - 6);
            classes.add(classLoader.loadClass(packageName + '.' + className));
        }
    }


    public static void answer(Class clz){

        Question question = (Question)clz.getAnnotation(Question.class);

        System.out.println("id: " + question.id());
        System.out.println("title: " + question.title());
        System.out.println("hint: " + question.hint());

        for(Method method : clz.getDeclaredMethods()){

            Best best = method.getAnnotation(Best.class);

            if(best != null) {
                System.out.println("[Best] complexity: " + best.complexity() + ", thought: " + best.thought());
            }

            Self self = method.getAnnotation(Self.class);

            if(self != null) {
                System.out.println("[Self] complexity: " + self.complexity() + ", thought: " + self.thought());
            }

        }

        System.out.println();

    }

    public static void main(String[] args) throws Exception {
        for(String pkg: packages){
            scan(pkg);
        }
    }
}
