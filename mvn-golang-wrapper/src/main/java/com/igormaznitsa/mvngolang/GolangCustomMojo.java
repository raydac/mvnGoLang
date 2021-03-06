/*
 * Copyright 2016 Igor Maznitsa.
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

package com.igormaznitsa.mvngolang;

import com.igormaznitsa.meta.common.utils.GetUtils;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * The Mojo allows to process commands which are not covered by MOJOs of the
 * plug-in.
 */
@Mojo(name = "custom", defaultPhase = LifecyclePhase.PACKAGE, threadSafe = true, requiresDependencyResolution = ResolutionScope.NONE)
public class GolangCustomMojo extends AbstractGoPackageAndDependencyAwareMojo {

  /**
   * Command for Go tool to be executed
   */
  @Parameter(name = "customCommand", required = true)
  private String customCommand;

  @Nullable
  @Override
  protected String getSkipMojoPropertySuffix() {
    return "clean";
  }

  @Override
  @Nonnull
  public String getGoCommand() {
    return GetUtils.ensureNonNull(this.customCommand, "");
  }

  @Override
  public boolean isEnforcePrintOutput() {
    return true;
  }
}
