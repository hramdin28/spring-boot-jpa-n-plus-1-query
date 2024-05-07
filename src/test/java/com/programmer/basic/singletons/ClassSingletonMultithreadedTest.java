package com.programmer.basic.singletons;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class ClassSingletonMultithreadedTest {

    private static final AtomicInteger HASH_CODE = new AtomicInteger(0);

    @Rule
    public ConcurrentRule concurrently = new ConcurrentRule();
    @Rule
    public RepeatingRule rule = new RepeatingRule();


    /**
     * Dans un environment multithreading assurez-vous qu'une seule instance sera créée.
     * <p>
     * Corriger ce test
     */
    @Test
    @Concurrent(count = 30)
    @Repeating(repetition = 200)
    public void should_both_instance_hashcodes_match() {

        var classSingleton = ClassSingleton.getInstance();
        var hash = classSingleton.hashCode();

        if (HASH_CODE.get() > 0) {
            Assert.assertEquals(HASH_CODE.get(), hash);
        }

        HASH_CODE.set(hash);
    }
}
