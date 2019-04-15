package com.lyf.autocode.dto;

import java.util.List;

public class ClassDTO {
    private String packageName;
    private String name;
    private String comment;
    private List<FieldDTO> fields;

    public ClassDTO() {
    }

    public ClassDTO(String packageName, String name, String comment, List<FieldDTO> fields) {
        this.packageName = packageName;
        this.name = name;
        this.comment = comment;
        this.fields = fields;
    }

    public String getPackageName() {
        return packageName;
    }

    public void ListPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void ListName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void ListComment(String comment) {
        this.comment = comment;
    }

    public List<FieldDTO> getFields() {
        return fields;
    }

    public void ListFields(List<FieldDTO> fields) {
        this.fields = fields;
    }
}
