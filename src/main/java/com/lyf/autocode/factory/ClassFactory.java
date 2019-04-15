package com.lyf.autocode.factory;

import com.lyf.autocode.dto.ClassDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class ClassFactory {
    public static void writeClass(Configuration cf, Writer writer, List<String> templateNames, ClassDTO dto) {
        assert cf != null && writer != null && templateNames != null && dto != null && !templateNames.isEmpty();
        templateNames.forEach(templateName -> {
            System.out.println("-------------正在写入模板 " + templateName + "---------------");
            boolean flag = true;
            try {
                Template template = cf.getTemplate(templateName);
                template.process(dto, writer);
            } catch (IOException | TemplateException ignored) {
                flag = false;
            }
            System.out.println("-------------模板 " + templateName + (flag ? "成功" : "失败") + "---------------");
        });
    }
}
