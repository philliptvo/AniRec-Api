package org.ani7.anirec;

import org.ani7.anirec.models.Snippets;
import org.ani7.anirec.repositories.SnippetsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SnippetsConfig {

    CommandLineRunner commandLineRunner(SnippetsRepository repository ) {
        return args -> {
            Snippets snip1 = new Snippets( "snippet1", "user1", 01);
            Snippets snip2 = new Snippets( "snippet2", "user2", 02);
            repository.saveAll(List.of(snip1,snip2));
        };
    }
}
