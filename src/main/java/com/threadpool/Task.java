package com.threadpool;

public interface Task 
{
   //String getName();
   public void performWork() throws InterruptedException;
}