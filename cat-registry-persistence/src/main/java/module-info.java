module cat.registry.persistence {
    requires java.persistence;
    requires dropwizard.hibernate;
    requires com.google.guice;
    requires org.hibernate.orm.core;
    requires cat.registry.model;
}