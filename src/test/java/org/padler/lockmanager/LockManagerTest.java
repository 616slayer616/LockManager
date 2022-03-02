package org.padler.lockmanager;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LockManagerTest {
    private final LockManager lockManager = new LockManager();

    Object lock1 = lockManager.getLock("1");
    Object lock2 = lockManager.getLock("2");

    @Test
    void differentLocks() {
        LockManager lockManager = new LockManager();

        Object lock1 = lockManager.getLock("1");
        Object lock2 = lockManager.getLock("2");

        assertThat(lock1).isNotEqualTo(lock2);
        assertThat(lockManager.size()).isEqualTo(2);
    }

    @Test
    void equalLocks() {
        LockManager lockManager = new LockManager();

        Object lock1a = lockManager.getLock("1");
        Object lock1b = lockManager.getLock("1");
        assertThat(lock1a).isEqualTo(lock1b);
        assertThat(lockManager.size()).isEqualTo(1);
    }

    @Test
    void twoLocks() {
        LockManager lockManager = new LockManager();

        Object lock1a = lockManager.getLock("1");
        Object lock1b = lockManager.getLock("1");
        Object lock2 = lockManager.getLock("2");
        assertThat(lock1a).isEqualTo(lock1b).isNotEqualTo(lock2);
        assertThat(lockManager.size()).isEqualTo(2);
    }

    @Test
    void garbageCollection() throws Exception {
        for (int i = 0; i < 10000000; i++) {
            lockManager.getLock(String.valueOf(i));
        }
        System.gc();
        Thread.sleep(1000);

        assertThat(lockManager.size()).isEqualTo(2);
    }
}