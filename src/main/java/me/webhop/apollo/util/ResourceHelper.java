package me.webhop.apollo.util;

import me.webhop.apollo.security.SecureResource;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResourceHelper {

    public static Boolean secureResource(Class<?> resourceClass, Method resourceMethod) {

        boolean methodIsSecure = resourceMethod.getAnnotation(SecureResource.class) != null;
        boolean classIsSecure = resourceClass.getAnnotation(SecureResource.class) != null;

        return methodIsSecure ||classIsSecure;
    }

    public static List<String> extractRoles() {
        return Collections.emptyList();
    }
}
