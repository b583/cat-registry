module cat.registry.api {
    requires jsr305;
    requires java.validation;
    requires cat.registry.model;
    requires com.google.guice;
    requires dropwizard.hibernate;
    requires java.ws.rs;
    requires cat.registry.service;
    exports com.github.b583.catregistry.api;
}