package _99Test;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.junit.Test;

public class multiThred {

  static ExecutorService executorService = Executors
      .newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

  @Test
  public void main1() {

    for (int i = 0 ; i < 100; i++){
      System.out.println("---------------");
//      test1();
    }
  }


  @Test
  public void test1() throws InterruptedException {
    CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(
        new Runnable() {
          @Override
          public void run() {
            DoSomeThing();
          }
        }, executorService);

    completableFuture
        .thenAccept((result) -> {
          System.out.println("success...");
        })
        .exceptionally((e) -> {
          e.printStackTrace();
          Throwable cause = e.getCause();
//          AuthenticationException exception = cause instanceof AuthenticationException ? ((AuthenticationException) cause) : null;
          System.out.println("failed...");
          return null;
        });

    System.out.println("over...");
    Thread.sleep(3000L);
  }

  @Test
  public void test2() {

    Future<String> future = executorService.submit(new Callable<String>() {
      @Override
      public String call() {
        return DoSomeThing();
      }
    });

    try {
      String result = future.get(3, TimeUnit.SECONDS);
//        System.out.println(future.isDone());
      System.out.println("ִ�гɹ�");
    } catch (Exception e) {
      System.out.println("����ʱ,ִ��ʧ��");
      future.cancel(true);
      System.out.println("ȡ���߳�: " + Thread.currentThread().getName());
    } finally {
      System.out.println("sink����,������Դ��");
    }

    System.out.println("���̼߳���ִ��: "+Thread.currentThread().getName());
  }


  public String DoSomeThing() {
    try {
      System.out.println("��˯1��");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("��˯2��");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("��˯3��");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("��˯4��");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("��˯5��");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("��˯6��");
    } catch (InterruptedException e) {
      System.out.println("�����ж�:" + Thread.currentThread().getName());
    }
    return "OK";
  }

//  @Test
//  public void test1(){
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        System.out.println("�������߳�");
//      }
//    }).start();
//    System.out.println("�������߳�");
//  }
//
//  @Test
//  public void test2(){
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        System.out.println("�������߳�");
//      }
//    }).start();
//    System.out.println("�������߳�");
//  }

}
