# LockManager
[![Master](https://github.com/616slayer616/lockmanager/actions/workflows/master.yml/badge.svg)](https://github.com/616slayer616/lockmanager/actions/workflows/master.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=616slayer616_LockManager&metric=alert_status)](https://sonarcloud.io/dashboard?id=616slayer616_LockManager)

[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=616slayer616_LockManager&metric=bugs)](https://sonarcloud.io/dashboard?id=616slayer616_LockManager)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=616slayer616_LockManager&metric=code_smells)](https://sonarcloud.io/dashboard?id=616slayer616_LockManager)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=616slayer616_LockManager&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=616slayer616_LockManager)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=616slayer616_LockManager&metric=coverage)](https://sonarcloud.io/dashboard?id=616slayer616_LockManager)

## Usage

```
public static void main(String[] args) {
LockManager lockMap = new LockManager();

        synchronized (lockMap.getLock("str")) {
        }
    }
```