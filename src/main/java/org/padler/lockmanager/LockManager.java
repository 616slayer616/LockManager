package org.padler.lockmanager;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class LockManager {

    private final WeakHashMap<Lock, WeakReference<Lock>> map = new WeakHashMap<>();

    public synchronized Object getLock(String key) {
        if (key==null) {
            throw new NullPointerException();
        }
        Lock newLock = new Lock(key);

        return map.computeIfAbsent(newLock, k -> new WeakReference<>(newLock)).get();
    }

    synchronized int size() {
        return map.size();
    }

    private static class Lock {
        private final String key;
        private final int hashCode;

        public Lock(String key) {
            this.key = key;
            hashCode = key.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj==this) {
                return true;
            }
            if (obj instanceof Lock lock) {
                return lock.key.equals(key);
            }
            return false;
        }

        public int hashCode() {
            return hashCode;
        }
    }

}