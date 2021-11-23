package me.webhop.apollo.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResourceHelper {

    public static Boolean secureResource(Class<?> resourceClass, Method resourceMethod) {
        return true;
    }

    public static List<String> extractRoles() {
        return Collections.emptyList();
    }
}
