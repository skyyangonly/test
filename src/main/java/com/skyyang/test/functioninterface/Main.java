package com.skyyang.test.functioninterface;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @ClassName Test
 * @Description desc
 * @Author tiancheng.yang
 * @Date 2019/9/3 13:49
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception{

        test(Plate::fire);

//        PlateMirror<Plate> plate =  Plate::new;
//        PlateMirror<String> mirror1 = plate.convert()::boom;
//        System.out.println(mirror1.convert());
//        mirror1 = plate.convert()::fly;
//        System.out.println(mirror1.convert());
//
//        PlateMirror2<String> mirror2 = Plate::fire;
//        System.out.println(mirror2.convert("aobama"));
//
//        PlateMirror3<String, Plate> mirror3 = Plate::new;
//        System.out.println(((Plate)mirror3.convert("kkk")).boom());

//        List<String> list = Arrays.asList(new String[]{"a", "b", "c", "d", "e"});
//        System.out.println("no order:");
//        list.parallelStream().forEach((e)->{
//            System.out.println(Thread.currentThread().getName() + ":" + e);
//        });
//        System.out.println("ordered:");
//        list.parallelStream().forEachOrdered((e)->{
//            System.out.println(Thread.currentThread().getName() + ":" + e);
//        });

//        long n = 100000;
//        forCalculator(n);
//        forkJoinCalculator(n);
//        parallelStreamCalculator(n);

        System.out.println();

    }

    static void forCalculator(long n){
        System.out.println("for循环计算 ...");
        Instant it1 = Instant.now();
        long t1 = System.currentTimeMillis();
        long sum = 0;
        for(int i = 0; i <= n; i ++){
            sum += i;
        }
        long t2 = System.currentTimeMillis();
        Instant it2 = Instant.now();
        System.out.println("for循环计算["+n+"]耗时:" + (Duration.between(it1, it2).toMillis()) + "ms, 结果：" + sum);
    }

    static void forkJoinCalculator(long n){
        System.out.println("forkJoin计算 ...");
        ForkJoinCalculateTask cal = new ForkJoinCalculateTask(1, n);
        ForkJoinPool pool = new ForkJoinPool();
        long t1 = System.currentTimeMillis();
        long sum = pool.invoke(cal);
        long t2 = System.currentTimeMillis();
        System.out.println("forkJoin计算["+n+"]耗时:" + (t2-t1) + "ms, 结果：" + sum);
    }

    static class ForkJoinCalculateTask extends RecursiveTask<Long>{
        long start;
        long end;

        public ForkJoinCalculateTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long diff = end - start;
            if( diff <= 1000){
                long sum = 0;
                for(long i = start; i <=end; i ++){
                    sum += i;
                }
                return sum;
            }

            long middle = start + diff/2;

            ForkJoinCalculateTask left = new ForkJoinCalculateTask(start, middle);
            left.fork();

            ForkJoinCalculateTask right = new ForkJoinCalculateTask(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }

    static void parallelStreamCalculator(long n){
        long t1 = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0, n).parallel().reduce(0, Long::sum);
        long t2 = System.currentTimeMillis();
        Instant it2 = Instant.now();
        System.out.println("parallelStream计算["+n+"]耗时:" + (t2-t1) + "ms, 结果：" + sum);
    }

    static void test (FunctionalInterfaceTest f){
        System.out.println(f.parseName("a"));
    }

    public void method1(String age, String sex){
        System.out.println(age + ", " + sex);
    }

}
