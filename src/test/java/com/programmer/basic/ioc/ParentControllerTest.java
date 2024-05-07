package com.programmer.basic.ioc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Cette classe de test est utilisée pour tester les dépendances entre ParentController,
 * ParentService et ParentComponent. Cependant, le test ne fonctionne pas. Pouvez-vous y remédier ?
 */
@SpringBootTest
class ParentControllerTest {

    @Autowired
    private ParentController parentController;

    @Test
    void should_get_hello_and_greetings() {
        var helloAndGreetings = parentController.doHelloAndGreetings();
        Assertions.assertThat(helloAndGreetings)
              .isEqualTo("Hello ParentService and Hello from ParentComponent");
    }

}
