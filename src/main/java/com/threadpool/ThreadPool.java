package com.threadpool;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreadPool 
{
   private List<Task> taskQueue = new LinkedList<>();
   private Set<PooledThread> availableThreads = new HashSet<>();

   public void addTask(Task task)
   {
      synchronized(taskQueue)
      {
         taskQueue.add(task);
         taskQueue.notify();
      }
   }

   public ThreadPool(int numThreads) 
   {
      for (int i = 0; i < numThreads; ++i)
      {
         availableThreads.add(new PooledThread("Performer #" + i, taskQueue));
      }
      for (PooledThread availableThread : availableThreads)
      {
         availableThread.start();
      }
   }
}