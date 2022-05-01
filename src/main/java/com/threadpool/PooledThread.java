package com.threadpool;

import java.util.List;

public class PooledThread extends Thread 
{
   private List<Task> taskQueue;

   public PooledThread(String name, List<Task> taskQueue) 
   {
      super(name);
      this.taskQueue = taskQueue;
   }

   public void run()
   {
      Task toExecute = null;
      while (true)
      {
         synchronized (taskQueue)
         {
            if (taskQueue.isEmpty())
            {
               try 
               {
                  taskQueue.wait();
               }
               catch (InterruptedException ex) 
               {
                  System.err.println("Thread was inetrrupted: " + getName());
               }
               continue;
            }
            else
            {
               toExecute = taskQueue.remove(0);
            }
         }
         //System.out.println(getName() + " got the job: "+ toExecute.getName());
         try 
         {
            toExecute.performWork();
         } 
         catch (InterruptedException e) 
         {
            e.printStackTrace();
         }
      }
   }
}