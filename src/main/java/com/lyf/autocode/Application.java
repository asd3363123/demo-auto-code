package com.lyf.autocode;

import com.lyf.autocode.dto.ClassDTO;
import com.lyf.autocode.dto.FieldDTO;
import com.lyf.autocode.factory.ClassFactory;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.Collections;
import java.util.Objects;

public class Application {

    /**
     * 模板文件夹的名称
     */
    private final static String TEMPLATE_DIR_NAME = "template";

    /**
     * 模板文件夹的路径
     * 一个是jar包时使用的，一个是项目运行时使用
     */
//    private final static String TEMPLATE_DIR_PATH = Paths.get(TEMPLATE_DIR_NAME).toFile().getAbsolutePath();
//    private final static String TEMPLATE_DIR_PATH = Thread.currentThread().getContextClassLoader().getResource(TEMPLATE_DIR_NAME).getFile();
    private static Configuration freeMakerInit() throws IOException {
        System.out.println("---------------初始化开始----------------");
        String TEMPLATE_DIR_PATH = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(TEMPLATE_DIR_NAME)).getFile();
        System.out.println("初始值： name = " + TEMPLATE_DIR_NAME + " , path = " + TEMPLATE_DIR_PATH);

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_DIR_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }


    public static void main(String[] args) throws IOException, TemplateException {
        Configuration cfg = freeMakerInit();
        Writer out = new FileWriter(new File("test.txt"));
        ClassDTO dto = new ClassDTO("com.lyf", "Test", "一个测试类",
                Collections.singletonList(new FieldDTO("id", String.class, "ID"))
        );

        ClassFactory.writeClass(cfg, out, Collections.singletonList("Entity.ftl"), dto);
    }
}
