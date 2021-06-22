package com.AemSpa.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifeildModel {

    @ValueMapValue(name = "linkPath")
    private String linkPath;

    @ValueMapValue(name = "textData")
    private String textData;

}
