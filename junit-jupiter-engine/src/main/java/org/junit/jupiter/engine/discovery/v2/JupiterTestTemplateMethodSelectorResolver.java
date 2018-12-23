package org.junit.jupiter.engine.discovery.v2;

import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.descriptor.TestTemplateInvocationTestDescriptor;
import org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor;
import org.junit.jupiter.engine.discovery.predicates.IsTestTemplateMethod;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;

import java.lang.reflect.Method;
import java.util.Arrays;

import static java.util.Collections.singleton;

public class JupiterTestTemplateMethodSelectorResolver extends JupiterMethodSelectorResolver {

    public JupiterTestTemplateMethodSelectorResolver(JupiterConfiguration configuration) {
        super(configuration, new IsTestTemplateMethod(), "test-template", TestTemplateInvocationTestDescriptor.SEGMENT_TYPE);
    }

    @Override
    protected TestDescriptor createTestDescriptor(UniqueId uniqueId, Class<?> testClass, Method method) {
        return new TestTemplateTestDescriptor(uniqueId, testClass, method, configuration);
    }

}
