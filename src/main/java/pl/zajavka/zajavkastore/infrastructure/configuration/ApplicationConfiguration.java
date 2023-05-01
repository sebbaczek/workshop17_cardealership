package pl.zajavka.zajavkastore.infrastructure.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.zajavka.zajavkastore.ZajavkaStoreApplication;

@Configuration
@ComponentScan(basePackageClasses = ZajavkaStoreApplication.class)
@Import(PersistenceJPAConfiguration.class)
public class ApplicationConfiguration {
}
