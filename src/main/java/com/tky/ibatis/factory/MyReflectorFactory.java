package com.tky.ibatis.factory;

import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.ReflectorFactory;

public class MyReflectorFactory implements ReflectorFactory{

  public boolean isClassCacheEnabled() {
    // TODO Auto-generated method stub
    return false;
  }

  public void setClassCacheEnabled(boolean classCacheEnabled) {
    // TODO Auto-generated method stub
    
  }

  public Reflector findForClass(Class<?> type) {
    // TODO Auto-generated method stub
    return null;
  }

}
