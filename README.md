# distributed-redis
redis 分布式锁

分布式锁的产生是基于现在的分布式系统普遍存在，应用的集群部署，导致原有的lock和sync锁的不可用，这时候产生了分布式锁。
分布式锁的实现是基于锁的原理，这里具体参考ReentrantLock的实现。
