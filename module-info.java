module hotelReservationApp {
    requires spring.context;
    requires spring.beans;
    requires java.sql;
    requires org.slf4j;
    requires java.desktop;

    opens hotelReservationApp;
    opens hotelReservationApp.config;
    opens hotelReservationApp.entities;
    opens hotelReservationApp.repository;
    opens hotelReservationApp.services;
    opens hotelReservationApp.views;
}