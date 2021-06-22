package com.AemSpa.core.models.impl;

import com.AemSpa.core.models.HomeComponent;
import com.AemSpa.core.models.MultifeildModel;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.collections4.ListUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.List;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = { HomeComponent.class, ComponentExporter.class },
        resourceType = HomeComponentImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter( //Exporter annotation that serializes the modoel as JSON
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
        extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class HomeComponentImpl implements HomeComponent {

    @ValueMapValue
    private String label; //maps variable to jcr property named "label" persisted by Dialog

    @ValueMapValue
    private String urlPath; //maps variable to jcr property named "urlPath"

    @ChildResource(name = "multiPaths")
    List<MultifeildModel> multiPaths;

    @PostConstruct
    protected void init() {
        multiPaths = ListUtils.emptyIfNull(this.multiPaths);
    }
    // points to AEM component definition in ui.apps
    static final String RESOURCE_TYPE = "AemSpa/components/home";

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getUrlPath() {
        return urlPath;
    }

    @Override
    public List<MultifeildModel> getMultiPaths() {
        return multiPaths;
    }

    @Override
    public String getExportedType() {
        return HomeComponentImpl.RESOURCE_TYPE;
    }
}
