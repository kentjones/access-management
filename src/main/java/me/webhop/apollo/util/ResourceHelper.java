package me.webhop.apollo.util;

import me.webhop.apollo.security.PermissionsRequestFilter;
import me.webhop.apollo.security.SecureResource;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResourceHelper {
    private static Logger logger = LoggerFactory.getLogger(ResourceHelper.class);

    public static Boolean secureResource(Class<?> resourceClass, Method resourceMethod) {

        boolean classIsSecure = resourceClass == null ? false :  resourceClass.isAnnotationPresent(SecureResource.class);
        if (classIsSecure == true) { logger.info("Class {} is Secure", resourceClass.getName()); };

        boolean methodIsSecure = resourceMethod == null ? false : resourceMethod.isAnnotationPresent(SecureResource.class);
        if (methodIsSecure == true) { logger.info("Method {}.{} is Secure",resourceClass.getName(), resourceMethod.getName()); };

        return methodIsSecure ||classIsSecure;
    }

    public static List<Annotation> getAnnotations(Method resourceMethod) {
        return Arrays.asList(resourceMethod.getAnnotations());
    }
}
