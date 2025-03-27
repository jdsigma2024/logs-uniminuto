package edu.uniminuto.logs_uniminuto.conf;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConf {
    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8880");
        devServer.setDescription("Dev environment");

        Contact contact = new Contact();
        contact.setEmail("jsnchezt@uniminuto.edu.co");
        contact.setName("José Sánchez");
        contact.setUrl("https://www.uniminuto.edu");

        License mitLicense = new License().name("MIT License").url("https://www.uniminuto.edu");

        Info info = new Info()
                .title("Análisis de logs como estrategia de tomas de decisiones en sistemas de información")
                .version("1.0")
                .contact(contact)
                .description("El presente trabajo pretende mostrar la importancia de las fases de monitoreo, como parte del desarrollo íntegro de las aplicaciones informáticas a través de la ilustración de algunas herramientas informáticas que permitan facilitar la toma de decisiones en una compañía por medio del análisis de logs. ").
                termsOfService("https://www.uniminuto.edu")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
