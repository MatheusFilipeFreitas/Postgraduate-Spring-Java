package com.mathffreitas.spring.service.common.factory;

import com.mathffreitas.spring.utils.versioning.version.ApiVersions;

public interface VersionServiceFactory<TService> {
    TService forVersion(ApiVersions version);
}
