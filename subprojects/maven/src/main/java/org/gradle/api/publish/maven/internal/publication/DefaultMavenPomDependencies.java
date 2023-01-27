/*
 * Copyright 2023 the original author or authors.
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

package org.gradle.api.publish.maven.internal.publication;

import org.gradle.api.publish.maven.internal.dependencies.MavenDependencyInternal;

import java.util.Set;

/**
 * Default implementation of {@link MavenPomDependencies}.
 */
public class DefaultMavenPomDependencies implements MavenPomDependencies {

    private final Set<MavenDependencyInternal> runtimeDependencies;
    private final Set<MavenDependencyInternal> apiDependencies;
    private final Set<MavenDependencyInternal> optionalDependencies;
    private final Set<MavenDependencyInternal> runtimeDependencyConstraints;
    private final Set<MavenDependencyInternal> apiDependencyConstraints;
    private final Set<MavenDependencyInternal> importDependencyConstraints;

    public DefaultMavenPomDependencies(
        Set<MavenDependencyInternal> runtimeDependencies,
        Set<MavenDependencyInternal> apiDependencies,
        Set<MavenDependencyInternal> optionalDependencies,
        Set<MavenDependencyInternal> runtimeDependencyConstraints,
        Set<MavenDependencyInternal> apiDependencyConstraints,
        Set<MavenDependencyInternal> importDependencyConstraints
    ) {
        this.runtimeDependencies = runtimeDependencies;
        this.apiDependencies = apiDependencies;
        this.optionalDependencies = optionalDependencies;
        this.runtimeDependencyConstraints = runtimeDependencyConstraints;
        this.apiDependencyConstraints = apiDependencyConstraints;
        this.importDependencyConstraints = importDependencyConstraints;
    }

    @Override
    public Set<MavenDependencyInternal> getRuntimeDependencies() {
        return runtimeDependencies;
    }

    @Override
    public Set<MavenDependencyInternal> getApiDependencies() {
        return apiDependencies;
    }

    @Override
    public Set<MavenDependencyInternal> getOptionalDependencies() {
        return optionalDependencies;
    }

    @Override
    public Set<MavenDependencyInternal> getRuntimeDependencyManagement() {
        return runtimeDependencyConstraints;
    }

    @Override
    public Set<MavenDependencyInternal> getApiDependencyManagement() {
        return apiDependencyConstraints;
    }

    @Override
    public Set<MavenDependencyInternal> getImportDependencyManagement() {
        return importDependencyConstraints;
    }
}
