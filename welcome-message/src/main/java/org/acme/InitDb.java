package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class InitDb {
    
    @Transactional
    void onStart(@Observes StartupEvent event) {
        new Welcome("Hello").persist();
        new Welcome("Hola").persist();
        new Welcome("Bonjour").persist();
        new Welcome("Namaste").persist();
        new Welcome("Olá").persist();
    }
}
