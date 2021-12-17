package com.glcxw.avatar.common.utils;

/**
 * chengyangbing special annotation
 *
 * @Package:      com.cmb.hbx.common.util
 * @FileName:     NumberUtils.java
 * @ClassName:    NumberUtils
 * @Description:  流水号生成工具类
 * @Author:       chengyangbing
 * @CreateDate:   2019/10/22 7:01 PM
 * @UpdateUser:   chengyangbing
 * @UpdateDate:   2019/10/22 7:01 PM
 * @UpdateRemark: 说明本次修改内容
 * @Version:      v1.0
 */
public abstract class NumberUtils {

    private static SnowflakeId snowflakeId = new SnowflakeId(0, 0);

    /**
     * chengyangbing special annotation
     * @param
     * @return v
     * @throws
     * @Title:
     * @Description: 生产唯一编号
     */
    public static String generator() {
        long id = snowflakeId.nextId();
        if (0 > id) {
            return String.valueOf(snowflakeId.nextId()).substring(1);
        }
        return String.valueOf(snowflakeId.nextId());
    }

    /**
     * chengyangbing special annotation
     *
     * @Package:        com.gree.ngstore.tool.utils
     * @FileName:       SnowflakeUtils.java
     * @ClassName:      SnowflakeUtils
     * @Description:    Twitter_Snowflake 算法
     * @Author:         chengyangbing
     * @CreateDate:     2019/3/22 5:37 PM
     * @UpdateUser:     chengyangbing
     * @UpdateDate:     2019/3/22 5:37 PM
     * @UpdateRemark:   说明本次修改内容
     * @Version:        v1.0
     */
    public static class SnowflakeId {

        /**
         * 开始时间截 (2015-01-01)
         */
        private final long twepoch = 1420041600000L;

        /**
         * 机器id所占的位数
         */
        private final long workerIdBits = 5L;

        /**
         * 数据标识id所占的位数
         */
        private final long datacenterIdBits = 5L;

        /**
         * 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
         */
        private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

        /**
         * 支持的最大数据标识id，结果是31
         */
        private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

        /**
         * 序列在id中占的位数
         */
        private final long sequenceBits = 12L;

        /**
         * 机器ID向左移12位
         */
        private final long workerIdShift = sequenceBits;

        /**
         * 数据标识id向左移17位(12+5)
         */
        private final long datacenterIdShift = sequenceBits + workerIdBits;

        /**
         * 时间截向左移22位(5+5+12)
         */
        private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

        /**
         * 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
         */
        private final long sequenceMask = -1L ^ (-1L << sequenceBits);

        /**
         * 工作机器ID(0~31)
         */
        private long workerId;

        /**
         * 数据中心ID(0~31)
         */
        private long datacenterId;

        /**
         * 毫秒内序列(0~4095)
         */
        private long sequence = 0L;

        /**
         * 上次生成ID的时间截
         */
        private long lastTimestamp = -1L;

        /**
         * 构造函数
         *
         * @param workerId     工作ID (0~31)
         * @param datacenterId 数据中心ID (0~31)
         */
        public SnowflakeId(long workerId, long datacenterId) {
            if (workerId > maxWorkerId || workerId < 0) {
                throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
            }
            if (datacenterId > maxDatacenterId || datacenterId < 0) {
                throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
            }
            this.workerId = workerId;
            this.datacenterId = datacenterId;
        }

        private long tilNextMillis(long lastTimestamp) {
            long timestamp = timeGen();
            while (timestamp <= lastTimestamp) {
                timestamp = timeGen();
            }
            return timestamp;
        }

        private long timeGen() {
            return System.nanoTime();
        }

        public synchronized long nextId() {
            long timestamp = timeGen();
            if (timestamp < lastTimestamp) {
                throw new RuntimeException(
                        String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
            }

            if (lastTimestamp == timestamp) {
                sequence = (sequence + 1) & sequenceMask;
                if (sequence == 0) {
                    timestamp = tilNextMillis(lastTimestamp);
                }
            } else {
                sequence = 0L;
            }
            lastTimestamp = timestamp;
            long number = ((timestamp - twepoch) << timestampLeftShift)
                    | (datacenterId << datacenterIdShift)
                    | (workerId << workerIdShift)
                    | sequence;
            return number;
        }

    }

}
