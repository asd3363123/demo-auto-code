package ${packageName};

<#list fields as field>
    <#if !field.type.name?contains("java.lang")>
        import ${field.type.name}
    </#if>
</#list>

/**
 * ${comment}
 *
 * @author lyf
 */
public class ${name} {

<#list fields as field>
   /**
    * ${field.comment}
    */
   private ${field.type.simpleName} ${field.name}
</#list>

<#list fields as field>
    public ${field.type.simpleName} get${field.name?cap_first}(){
        return ${field.name};
    }

    public void set${field.name?cap_first}(${field.type.simpleName} ${field.name}){
        this.${field.name} = ${field.name};
    }

</#list>

}
