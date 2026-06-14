package com.mathffreitas.spring.utils.versioning.implementation;

import com.mathffreitas.spring.model.error.UnsupportedApiVersionException;
import com.mathffreitas.spring.utils.versioning.ApiVersionResolver;
import com.mathffreitas.spring.utils.versioning.version.ApiVersions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ApiVersionResolverImpl implements ApiVersionResolver {

    public ApiVersions resolve(HttpServletRequest request) {
        String path = request.getRequestURI();
        ApiVersions versionFromPath = fromPath(path);
        return versionFromPath;
    }

    private ApiVersions fromPath(String path) {
        return extractVersionFromPath(path);
    }

    private ApiVersions extractVersionFromPath(String path) {
        Pattern regex = Pattern.compile("/(v\\d+)/");
        Matcher matcher = regex.matcher(path);

        if (matcher.find()) {
            String apiVersion = matcher.group(1).toUpperCase();

            try {
                return ApiVersions.valueOf(apiVersion);
            } catch (IllegalArgumentException e) {
                throw new UnsupportedApiVersionException("Invalid api version: " + apiVersion);
            }
        }

        throw new UnsupportedApiVersionException("Invalid path: " + path);
    }
}
