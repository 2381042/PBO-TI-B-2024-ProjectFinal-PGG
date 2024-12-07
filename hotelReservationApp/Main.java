package hotelReservationApp;

import hotelReservationApp.config.Database;
import hotelReservationApp.repository.KamarRepository;
import hotelReservationApp.repository.KamarRepositoryMySQL;
import hotelReservationApp.repository.PemesananRepository;
import hotelReservationApp.repository.PemesananRepositoryMySQL;
import hotelReservationApp.services.AdminServiceImpl;
import hotelReservationApp.services.CustomerServiceImpl;
import hotelReservationApp.services.KamarServiceImpl;
import hotelReservationApp.services.PemesananServiceImpl;
import hotelReservationApp.views.AdminViewImpl;
import hotelReservationApp.views.CustomerViewImpl;
import hotelReservationApp.views.TerminalView;
import hotelReservationApp.views.TerminalViewImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericApplicationContextExtensionsKt;

import javax.swing.text.View;
import java.awt.*;

@ComponentScan(basePackages = "hotelReservationApp")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TerminalView terminalView = context.getBean(TerminalViewImpl.class);
        terminalView.run();

    }

    @Bean
    Database database (){
        Database database = new Database("hotel_management", "root", "", "localhost", "3306");
        database.setup();
        return database;
    }
}