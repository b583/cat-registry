module cat.registry.persistence {
    requires java.persistence;
    requires com.google.guice;
    requires cat.registry.model;
    exports com.github.b583.catregistry.persistence;
}