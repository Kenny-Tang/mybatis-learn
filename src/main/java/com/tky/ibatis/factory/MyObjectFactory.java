package com.tky.ibatis.factory;

import java.util.List;

import org.apache.ibatis.reflection.factory.ObjectFactory;

import com.tky.ibatis.model.User;

public class MyObjectFactory implements ObjectFactory {
  
  public <T> T create(Class<T> type) {
    // TODO Auto-generated method stub
    return null;
  }

  public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes,
      List<Object> constructorArgs) {
    // TODO Auto-generated method stub
    return null;
  }

  public <T> boolean isCollection(Class<T> type) {
    // TODO Auto-generated method stub
    return false;
  }
}
