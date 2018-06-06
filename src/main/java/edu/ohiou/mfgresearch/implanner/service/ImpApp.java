package edu.ohiou.mfgresearch.implanner.service;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Portable JAX-RS application.
 *
 * @author Arul Dhesiaseelan (aruld@acm.org)
 */
public class ImpApp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // register resources and features
        classes.add(MultiPartFeature.class);
        classes.add(FeatureMappingService.class);
        classes.add(LoggingFilter.class);
        return classes;
    }
}
