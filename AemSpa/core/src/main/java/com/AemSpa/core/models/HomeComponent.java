package com.AemSpa.core.models;

import com.adobe.cq.export.json.ComponentExporter;

public interface HomeComponent extends ComponentExporter {
    public String getLabel();

    public String getUrlPath();

}
