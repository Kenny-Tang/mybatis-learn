package com.tky.ibatis.factory;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

public class MyObjectWrapperFactory implements ObjectWrapperFactory{

  public boolean hasWrapperFor(Object object) {
    // TODO Auto-generated method stub
    return false;
  }

  public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
    // TODO Auto-generated method stub
    return null;
  }

}
