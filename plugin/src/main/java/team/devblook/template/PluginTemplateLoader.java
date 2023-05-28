package team.devblook.template;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;
import io.papermc.paper.plugin.loader.library.impl.MavenLibraryResolver;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.repository.RemoteRepository;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"unused", "UnstableApiUsage"})
public class PluginTemplateLoader implements PluginLoader {

    @Override
    public void classloader(@NotNull PluginClasspathBuilder classpathBuilder) {
        final var mavenResolver = new MavenLibraryResolver();
        final var repository = new RemoteRepository
                .Builder("central", "default", "https://repo1.maven.org/maven2/")
                .build();
        final var dependency = new Dependency(
                new DefaultArtifact("io.github.miniplaceholders:miniplaceholders-api:2.1.0"),
                null
        );

        mavenResolver.addRepository(repository);
        mavenResolver.addDependency(dependency);
        classpathBuilder.addLibrary(mavenResolver);
    }
}
