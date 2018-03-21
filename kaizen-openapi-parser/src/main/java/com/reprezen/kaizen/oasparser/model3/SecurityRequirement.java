package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import java.util.Map;
import com.reprezen.kaizen.oasparser.model3.SecurityParameter;

public interface SecurityRequirement extends IPropertiesOverlay<SecurityRequirement>, IModelPart<OpenApi3, SecurityRequirement> {

    // Requirement
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, SecurityParameter> getRequirements();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, SecurityParameter> getRequirements(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasRequirement(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    SecurityParameter getRequirement(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setRequirements(Map<String, SecurityParameter> requirements);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setRequirement(String name, SecurityParameter requirement);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeRequirement(String name);
}
