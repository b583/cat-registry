module cat.registry.persistence {
    requires java.persistence;
    requires com.google.guice;
    requires cat.registry.model;
    requires org.apache.commons.lang3;
    exports com.github.b583.catregistry.persistence;
}