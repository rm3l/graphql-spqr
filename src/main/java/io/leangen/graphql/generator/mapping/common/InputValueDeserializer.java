package io.leangen.graphql.generator.mapping.common;

import java.lang.reflect.AnnotatedType;

import io.leangen.graphql.execution.ResolutionEnvironment;
import io.leangen.graphql.generator.mapping.ArgumentInjector;

/**
 * @author Bojan Tomic (kaqqao)
 */
public class InputValueDeserializer implements ArgumentInjector {
    
    @Override
    public Object getArgumentValue(Object input, AnnotatedType type, ResolutionEnvironment resolutionEnvironment) {
        if (input == null) {
            return null;
        }
        AnnotatedType argValueType = resolutionEnvironment.getMappableType(type);
        return resolutionEnvironment.valueMapper.fromInput(input, argValueType);
    }

    @Override
    public boolean supports(AnnotatedType type) {
        return true;
    }
}
