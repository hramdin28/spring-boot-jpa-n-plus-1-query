package com.programmer.answers.basic.ioc;

/**
 * Vous devez ajouter l'annotation @RestController
 */
//@RestController
public class ParentController {

    private final ParentService parentService;
    private final ParentComponent parentComponent;

    /**
     * Utiliser l'injection par le constructeur
     *
     * @param parentService   Mettre l'attribut comme final pour le rendre immuable
     * @param parentComponent Mettre l'attribut comme final pour le rendre immuable
     */
    public ParentController(ParentService parentService, ParentComponent parentComponent) {
        this.parentService = parentService;
        this.parentComponent = parentComponent;
    }

    public String doHelloAndGreetings() {
        return parentService.hello() + " and " + parentComponent.greetings();
    }

}
