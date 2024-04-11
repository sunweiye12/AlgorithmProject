package _00��������;

import org.junit.Test;

import java.util.BitSet;



public class _08��¡���� {

    @Test
    public void main() {
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        _08��¡���� filter = new _08��¡����();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
    }


    /**
     * λ����Ĵ�С
     */
    private static final int DEFAULT_SIZE = 2 << 24;
    /**
     * ͨ�����������Դ��� 6 ����ͬ�Ĺ�ϣ����
     */
    private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

    /**
     * λ���顣�����е�Ԫ��ֻ���� 0 ���� 1
     */
    private BitSet bits = new BitSet(DEFAULT_SIZE);

    /**
     * ��Ű��� hash �������������
     */
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    /**
     * ��ʼ��������� hash ������������飬ÿ�����е� hash ��������һ��
     */
    public _08��¡����() {
        // ��ʼ�������ͬ�� Hash ����
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    /**
     * ���Ԫ�ص�λ����
     */
    public void add(Object value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    /**
     * �ж�ָ��Ԫ���Ƿ������λ����
     */
    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    /**
     * ��̬�ڲ��ࡣ���� hash ������
     */
    public static class SimpleHash {

        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        /**
         * ���� hash ֵ
         */
        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }

    }
}