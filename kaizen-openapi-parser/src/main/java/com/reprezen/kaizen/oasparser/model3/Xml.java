package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import java.util.Map;

public interface Xml extends IPropertiesOverlay<Xml>, IModelPart<OpenApi3, Xml> {

    // Name
    @Generated("com.reprezen.gen.CodeGenerator")
    String getName();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getName(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setName(String name);

    // Namespace
    @Generated("com.reprezen.gen.CodeGenerator")
    String getNamespace();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getNamespace(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setNamespace(String namespace);

    // Prefix
    @Generated("com.reprezen.gen.CodeGenerator")
    String getPrefix();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getPrefix(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setPrefix(String prefix);

    // Attribute
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getAttribute();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getAttribute(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isAttribute();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setAttribute(Boolean attribute);

    // Wrapped
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getWrapped();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getWrapped(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isWrapped();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setWrapped(Boolean wrapped);

    // Extension
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getExtensions(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeExtension(String name);
}
