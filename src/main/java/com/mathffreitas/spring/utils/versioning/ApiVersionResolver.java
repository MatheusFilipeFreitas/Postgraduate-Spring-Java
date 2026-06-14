package com.mathffreitas.spring.utils.versioning;

import com.mathffreitas.spring.utils.versioning.version.ApiVersions;
import jakarta.servlet.http.HttpServletRequest;

public interface ApiVersionResolver {
    ApiVersions resolve(HttpServletRequest request);
}
