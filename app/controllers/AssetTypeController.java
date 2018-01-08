package controllers;

import com.google.inject.Inject;
import id.openbox.sasset.models.AssetType;
import io.swagger.annotations.Api;

@Api(value = "Asset Type")
public class AssetTypeController extends ApplicationController {
    @Inject
    private AssetTypeController() {
        super(AssetType.class);
    }
}
