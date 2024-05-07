package com.programmer.basic.singletons;

import org.junit.Assert;
import org.junit.Test;

public class ClassSingletonTest {

    /**
     * Assurez-vous qu'une seule instance sera créée.
     * <p>
     * Corriger ce test
     */
    @Test
    public void should_both_instance_hashcodes_match() {

        var classSingleton = ClassSingleton.getInstance();
        var hash = classSingleton.hashCode();

        var classSingleton2 = ClassSingleton.getInstance();
        var hash2 = classSingleton2.hashCode();

        Assert.assertEquals(hash, hash2);
    }
}
