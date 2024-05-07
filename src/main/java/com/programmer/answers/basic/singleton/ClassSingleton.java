package com.programmer.answers.basic.singleton;


public class ClassSingleton {

    /**
     * une instance statique pour stocker la première instance d'initialisation
     */
    private static ClassSingleton instance;

    /**
     * un constructeur privé pour empêcher la création d'une nouvelle instance en utilisant la
     * fonction new ClassSingleton()
     */
    private ClassSingleton() {
    }

    /**
     * une méthode statique publique getInstance() utilisée pour créer la nouvelle instance
     * singleton. Le mot-clé "synchronized" est utilisé pour rendre la classe thread safe.
     *
     * @return static instance
     */
    public static synchronized ClassSingleton getInstance() {
        if (instance == null) {
            instance = new ClassSingleton();
        }

        return instance;
    }
}
