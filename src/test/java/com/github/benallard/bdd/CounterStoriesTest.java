package com.github.benallard.bdd;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JupiterStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class CounterStoriesTest extends JupiterStories {
 
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
          .useStoryLoader(new LoadFromClasspath(this.getClass()))
          .useStoryReporterBuilder(new StoryReporterBuilder()
            .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
            .withFormats(Format.CONSOLE));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new CounterSteps());
    }

    @Override
    public List<String> storyPaths() {
        //return Arrays.asList("stories/increase.story");
        return new StoryFinder().findPaths(
            CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
                "**/stories/*.story", null);
    }

   
}
