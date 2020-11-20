package org.wistefan.gatling;

import io.gatling.app.Gatling;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

@Mojo(
        name = "aggregate",
        defaultPhase = LifecyclePhase.SITE,
        requiresDependencyCollection = ResolutionScope.COMPILE
)
public class AggregationMojo extends AbstractMojo {

    /**
     * Folder to search for reports to aggregate
     */
    @Parameter(property = "reportsFolder", defaultValue = "reports/")
    private String reportsFolder;

    /**
     * Aggregate the reports by calling gatling in reports-only mode
     */
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Gatling.main(new String[]{"-ro", reportsFolder, "-rf"});
    }

}
