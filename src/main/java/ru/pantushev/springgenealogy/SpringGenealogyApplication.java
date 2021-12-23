package ru.pantushev.springgenealogy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.pantushev.springgenealogy.domains.Person;

@SpringBootApplication
public class SpringGenealogyApplication {

    public static void main(String[] args) {
        ApplicationContext c = SpringApplication.run(SpringGenealogyApplication.class, args);

        Person pa = c.getBean("alexandrPantushev", Person.class);
        Person pl = c.getBean("lidiaPantusheva", Person.class);
        Person pd = c.getBean("denisPantushev", Person.class);
        Person pj = c.getBean("juriyPantushev", Person.class);

        System.out.println(pd.toString());
        System.out.println(pa.toString());
        System.out.println(pl.toString());

        System.out.println();

        System.out.println("question:");
        System.out.println(pa.getName());
        System.out.println("is parent of ");
        System.out.println(pd.getName());
        System.out.println("?");
        System.out.println(pa.isParent(pd));
        System.out.println();

        System.out.println("question:");
        System.out.println(pa.getName());
        System.out.println("is parent of ");
        System.out.println(pl.getName());
        System.out.println("?");
        System.out.println(pa.isParent(pl));
        System.out.println();

        System.out.println("question:");
        System.out.println(pj.getName());
        System.out.println("is descendant of ");
        System.out.println(pa.getName());
        System.out.println("?");
        System.out.println(pj.isDescendant(pa));
        System.out.println();


    }

}
