package ru.pantushev.springgenealogy.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.pantushev.springgenealogy.domains.Person;

@Configuration
public class AppConfig {
    @Bean public Person lidiaPantusheva() { return new Person("Lidia", "Pantusheva", null, null); }
    @Bean public Person alexandrPantushev() { return new Person("Alexandr", "Pantushev", null, null); }
    @Bean public Person denisPantushev(Person alexandrPantushev, Person lidiaPantusheva) { return new Person("Denis", "Pantushev", alexandrPantushev, lidiaPantusheva); }
    @Bean public Person olgaProhorova() { return new Person("Olga", "Prohorova", null, null); }
    @Bean public Person juriyPantushev(Person denisPantushev, Person olgaProhorova) { return new Person("Juriy", "Pantushev", denisPantushev, olgaProhorova); }
}
