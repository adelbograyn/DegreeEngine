module degree {
    requires javafx.controls;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires com.jfoenix;

    exports org.softwareengine;
    exports org.softwareengine.core.controller;
    exports org.softwareengine.core.model;
    exports org.softwareengine.core.view;
    exports org.softwareengine.core.repositories;
}