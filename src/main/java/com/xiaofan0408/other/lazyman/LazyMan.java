package com.xiaofan0408.other.lazyman;

import java.util.LinkedList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author xuzefan  2020/1/21 17:01
 */
public class LazyMan {
    private LinkedList<Event> events;

    public LazyMan(String message) {
        events = new LinkedList<>();
        sayHello(message);
        TimeUtil.run(() -> {
            eventLoop();
        },0, TimeUnit.SECONDS);
    }

    private void eventLoop() {
        while (this.events.size() > 0){
            process();
            break;
        }
    }

    private void sayHello(String message){
        this.events.add(new Event() {
            @Override
            public void run() {
                System.out.println(" Hi! This is " + message);
                process();
            }
        });
    }

    private LazyMan sleep(int i) {
       this.events.add(new Event() {
           @Override
           public void run() {
               ScheduledFuture scheduledFuture = TimeUtil.run(() -> {
                   System.out.println("Wake up after " + i);
                   process();
               },i, TimeUnit.SECONDS);
               while (!scheduledFuture.isDone()){
                   try {
                       TimeUnit.MILLISECONDS.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       });
        return this;
    }

    private LazyMan eat(String message) {
        this.events.add(new Event() {
            @Override
            public void run() {
                System.out.println("Eat " + message);
                process();
            }
        });
        return this;
    }

    private LazyMan sleepFirst(int i) {
        this.events.addFirst(new Event() {
            @Override
            public void run() {
                ScheduledFuture scheduledFuture = TimeUtil.run(() -> {
                    System.out.println("Wake up after " + i);
                    process();
                },i, TimeUnit.SECONDS);
                while (!scheduledFuture.isDone()){
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return this;
    }

    private void process() {
        if (this.events.size() > 0) {
//            System.out.println(events);
            Event event = this.events.pop();
            event.run();
        }
    }
    public static void main(String[] args) {
//         new LazyMan("Hank");
        // Hi! This is Hank!

//         new LazyMan("Hank").sleep(4).eat("dinner");
        // Hi! This is Hank!
        //等待10秒..
        // Wake up after 10
        // Eat dinner~
//        new LazyMan("Hank").eat("dinner").eat("supper");
        // Hi This is Hank!
        // Eat dinner~
        // Eat supper~

         new LazyMan("Hank").sleepFirst(5).eat("supper");
        //等待5秒
        // Wake up after 5
        // Hi This is Hank!
        // Eat supper
    }




}
