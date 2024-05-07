package com.programmer.basic.ioc;


public class ParentController {

    private ParentService parentService;
    private ParentComponent parentComponent;


    public String doHelloAndGreetings() {
        return parentService.hello() + " and " + parentComponent.greetings();
    }

}
