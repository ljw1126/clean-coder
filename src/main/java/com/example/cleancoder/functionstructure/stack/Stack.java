package com.example.cleancoder.functionstructure.stack;

/**
 * Created with IntelliJ IDEA.
 * User: msbaek
 * Date: 13. 07. 12.금요일
 * Time: 오후 5:32
 * To change this template use File | Settings | File Templates.
 */
public interface Stack {
  boolean isEmpty();

  Integer getSize();

  void push(int element);

  int pop();

  Integer top();

  Integer find(int element);

  public class Empty extends RuntimeException {}
}
