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

package org.gradle.operations.execution;

import org.gradle.internal.operations.BuildOperationType;

import javax.annotation.Nullable;

public final class ExecuteWorkBuildOperationType implements BuildOperationType<ExecuteWorkBuildOperationType.Details, ExecuteWorkBuildOperationType.Result> {

    public interface Details {
        String getWorkType();
        String getWorkspaceId();
    }

    public interface Result {
        @Nullable
        String getSkipMessage();

        @Nullable
        Throwable getFailure();

        @Nullable
        String getOriginBuildInvocationId();

        @Nullable
        Long getOriginExecutionTime();

        @Nullable
        String getCachingDisabledReasonMessage();

        @Nullable
        String getCachingDisabledReasonCategory();
    }
}
