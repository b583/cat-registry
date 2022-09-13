module cat.registry.service {
    requires cat.registry.model;
    requires org.apache.commons.lang3;
    requires cat.registry.persistence;
    requires java.validation;
    requires com.fasterxml.jackson.annotation;
    requires com.google.guice;
    exports com.github.b583.catregistry.service;
}