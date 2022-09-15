/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.tasks;

import org.gradle.api.internal.tasks.properties.PropertyValue;

import javax.annotation.Nullable;
import java.util.function.Function;

/**
 * A {@link PropertyValue} that resolves another using a {@link Function}.
 */
public class ResolvingPropertyValue implements PropertyValue {
    private final PropertyValue delegate;
    private final Function<Object, Object> resolver;

    public ResolvingPropertyValue(PropertyValue delegate, Function<Object, Object> resolver) {
        this.delegate = delegate;
        this.resolver = resolver;
    }

    @Override
    public TaskDependencyContainer getTaskDependencies() {
        return delegate.getTaskDependencies();
    }

    @Override
    public void maybeFinalizeValue() {
        delegate.maybeFinalizeValue();
    }

    @Nullable
    @Override
    public Object getValue() {
        return resolver.apply(delegate.getValue());
    }
}