# Gatling Aggregation Maven Plugin

Tiny maven plugin to aggregate multiple gatling reports into one. 
 
## Usage
```
<plugin>
    <groupId>org.wistefan</groupId>
    <artifactId>gatling-aggregation-maven-plugin</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <configuration>
        <!-- folder that holds you reports, the aggregated report will also end up here. -->
        <reportsFolder>${project.basedir}/reports</reportsFolder>
    </configuration>
</plugin>
```