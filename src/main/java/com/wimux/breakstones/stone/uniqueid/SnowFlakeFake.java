package com.wimux.breakstones.stone.uniqueid;


/**
 * SnowFlake算法
 * <p>
 * SnowFlake的结构如下(每部分用-分开):<br>
 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
 * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
 * 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
 * 得到的值），这里的的开始时间截，一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
 * 10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId<br>
 * 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
 * 加起来刚好64位，为一个Long型。<br>
 * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，并且效率较高，经测试，SnowFlake每秒能够产生26万ID左右。
 *
 * @Author siqigang
 * @Date 2019-01-02 00:47
 */
public class SnowFlakeFake {
    /**
     * 起始的时间戳 2019-01-01 00:00:00
     */
    private final static long START_STMP = 1546272000000L;

    /**
     * 每一部分占用的位数
     * 数据中心占用的位数：5
     * 机器标识占用的位数：5
     * 序列号占用的位数：12
     */
    private final static long DATACENTER_BIT = 5L;
    private final static long MACHINE_BIT = 5L;
    private final static long SEQUENCE_BIT = 12L;

    /**
     * 每一部分最大值
     */
    private static final long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
    private static final long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private static final long MAX_SEQUNCE_NUM = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    /**
     * 机器标识ID向左移12位
     */
    private static final long MACHINE_LEFT = SEQUENCE_BIT;
    /**
     * 数据中心ID向左移17位(12+5)
     */
    private static final long DATACENTER_LEFT = MACHINE_LEFT + MACHINE_BIT;
    /**
     * 时间戳向左移22位(12+5+5)
     */
    private static final long TIMESTAMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    /**
     * 数据中心（0-31）
     */
    private long datacenterId;

    /**
     * 机器标识（0-31）
     */
    private long machineId;

    /**
     * 序列号（0-4095）
     */
    private long sequenceId = 0L;

    /**
     * 上一次时间戳
     */
    private long lastTimestamp = -1L;


    public SnowFlakeFake(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized long nextId() {
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }
        if (currentTimestamp == lastTimestamp) {
            //if条件里表示当前调用和上一次调用落在了相同毫秒内，只能通过第三部分，序列号自增来判断为唯一，所以+1.
            sequenceId = (sequenceId + 1) & MAX_SEQUNCE_NUM;
            //同一毫秒的序列数已经达到最大，只能等待下一个毫秒
            if (sequenceId == 0L) {
                currentTimestamp = getNextMillis();
            }
        } else {
            //不同毫秒内，序列号置为0
            //执行到这个分支的前提是currTimestamp > lastTimestamp，说明本次调用跟上次调用对比，已经不再同一个毫秒内了，这个时候序号可以重新回置0了。
            sequenceId = 0L;
        }
        lastTimestamp = currentTimestamp;

        //就是用相对毫秒数、机器ID和自增序号拼接
        return (currentTimestamp - START_STMP) << TIMESTAMP_LEFT
                | datacenterId << DATACENTER_BIT
                | machineId << MACHINE_BIT
                | sequenceId;
    }


    /**
     * 获取下一个毫秒
     *
     * @return
     */
    private long getNextMillis() {
        long nextMillis = System.currentTimeMillis();
        // TODO 为什么不直接+1？？
        // 阻塞到下一个毫秒,获得新的时间戳
        while (nextMillis <= lastTimestamp) {
            nextMillis = System.currentTimeMillis();
        }
        return nextMillis;
    }


    public static void main(String[] args) {
        // 构造方法设置机器码：第9个机房的第20台机器
        SnowFlakeFake snowFlake = new SnowFlakeFake(9, 20);
        for (int i = 0; i < (1 << 12); i++) {
            System.out.println(snowFlake.nextId());
        }
    }

}
