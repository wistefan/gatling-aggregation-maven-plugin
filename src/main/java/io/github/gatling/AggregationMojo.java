package io.github.gatling;

import io.gatling.app.Gatling;
import lombok.extern.java.Log;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import java.io.File;

@Mojo(
        name = "aggregate",
        defaultPhase = LifecyclePhase.SITE,
        requiresDependencyCollection = ResolutionScope.COMPILE
)
@Log
public class AggregationMojo extends AbstractMojo {

    /**
     * Folder to search for reports to aggregate
     */
    @Parameter(property = "reportsFolder", defaultValue = "reports/")
    private String reportsFolder;

    /**
     * Should the plugin fail in case an empty reports folder is provided.
     */
    @Parameter(property = "failOnEmptyReports", defaultValue = "true")
    private Boolean failOnEmptyReports;

    /**
     * Aggregate the reports by calling gatling in reports-only mode
     */
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        File reports = new File(reportsFolder);
        try {
            Gatling.main(new String[]{"-ro", reportsFolder, "-rf"});
        } catch (IllegalArgumentException e) {
            if(failOnEmptyReports) {
                throw e;
            }
        }
    }
}
