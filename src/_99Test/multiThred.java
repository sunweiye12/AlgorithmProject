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
      System.out.println("执行成功");
    } catch (Exception e) {
      System.out.println("任务超时,执行失败");
      future.cancel(true);
      System.out.println("取消线程: " + Thread.currentThread().getName());
    } finally {
      System.out.println("sink操作,清理资源。");
    }

    System.out.println("主线程继续执行: "+Thread.currentThread().getName());
  }


  public String DoSomeThing() {
    try {
      System.out.println("沉睡1秒");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("沉睡2秒");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("沉睡3秒");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("沉睡4秒");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("沉睡5秒");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("沉睡6秒");
    } catch (InterruptedException e) {
      System.out.println("任务被中断:" + Thread.currentThread().getName());
    }
    return "OK";
  }

//  @Test
//  public void test1(){
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        System.out.println("我是子线程");
//      }
//    }).start();
//    System.out.println("我是主线程");
//  }
//
//  @Test
//  public void test2(){
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        System.out.println("我是子线程");
//      }
//    }).start();
//    System.out.println("我是主线程");
//  }

}
