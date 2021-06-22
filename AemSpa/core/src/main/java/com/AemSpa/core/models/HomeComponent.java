package com.AemSpa.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import java.util.List;

public interface HomeComponent extends ComponentExporter {
    public String getLabel();

    public String getUrlPath();

    public List<MultifeildModel> getMultiPaths();

}
