/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar;

import java.math.BigInteger;
import java.util.List;

import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.SessionDescriptor;
import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.TimerDescriptor;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.EjbClassType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.EjbNameType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.EmptyType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.FullyQualifiedClassType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.HomeType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.JavaTypeType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.LocalHomeType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.LocalType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.MethodParamsType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.NamedMethodType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.RemoteType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.SessionBeanType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.SessionTypeType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.StatefulTimeoutType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.TimeUnitTypeType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.XsdIntegerType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.XsdStringType;

/**
 * @author "Davide D'Alto"
 * @version $Revision: $
 *
 */
public class SessionDescriptorImpl extends EnterpriseBeansDescriptorImpl implements SessionDescriptor
{

   private final SessionBeanType sessionBean;

   public SessionDescriptorImpl(EjbJarModel model)
   {
      this(model, new SessionBeanType());
   }
   
   public SessionDescriptorImpl(EjbJarModel model, SessionBeanType sessionBean)
   {
      super(model);
      model.getEnterpriseBeans().getSessionOrEntityOrMessageDriven().add(sessionBean);
      this.sessionBean = sessionBean;
   }
   
   public SessionBeanType getSessionBean()
   {
      return sessionBean;
   }

   private FullyQualifiedClassType convertToFullyQualifiedClasType(Class<?> class1)
   {
      FullyQualifiedClassType classType = new FullyQualifiedClassType();
      classType.setValue(class1.getCanonicalName());
      return classType;
   }

   @Override
   public SessionDescriptor ejbName(String name)
   {
      EjbNameType ejbName = new EjbNameType();
      ejbName.setValue(name);
      this.sessionBean.setEjbName(ejbName);
      return this;
   }

   @Override
   public SessionDescriptor mappedName(String name)
   {
      XsdStringType xsdString = new XsdStringType();
      xsdString.setValue(name);
      this.sessionBean.setMappedName(xsdString);
      return this;
   }

   @Override
   public SessionDescriptor home(Class<?> class1)
   {
      HomeType homeType = new HomeType();
      homeType.setValue(class1.getCanonicalName());
      this.sessionBean.setHome(homeType);
      return this;
   }

   @Override
   public SessionDescriptor remote(Class<?> class1)
   {
      RemoteType remoteType = new RemoteType();
      remoteType.setValue(class1.getCanonicalName());
      this.sessionBean.setRemote(remoteType);
      return this;
   }

   @Override
   public SessionDescriptor localHome(Class<?> class1)
   {
      LocalHomeType localHomeType = new LocalHomeType();
      localHomeType.setValue(class1.getCanonicalName());
      this.sessionBean.setLocalHome(localHomeType);
      return this;
   }

   @Override
   public SessionDescriptor local(Class<?> class1)
   {
      LocalType localType = new LocalType();
      localType.setValue(class1.getCanonicalName());
      this.sessionBean.setLocal(localType);
      return this;
   }

   @Override
   public SessionDescriptor businnessLocal(Class<?>... classes)
   {
      List<FullyQualifiedClassType> businessLocals = this.sessionBean.getBusinessLocal();
      for (Class<?> class1 : classes)
      {
         businessLocals.add(convertToFullyQualifiedClasType(class1));
      }
      return this;
   }

   @Override
   public SessionDescriptor businnessRemote(Class<?>... classes)
   {
      List<FullyQualifiedClassType> businessRemotes = this.sessionBean.getBusinessRemote();
      for (Class<?> class1 : classes)
      {
         FullyQualifiedClassType classType = new FullyQualifiedClassType();
         classType.setValue(class1.getCanonicalName());
         businessRemotes.add(classType);
      }
      return this;
   }

   @Override
   public SessionDescriptor localBean()
   {
      this.sessionBean.setLocalBean(new EmptyType());
      return this;
   }

   @Override
   public SessionDescriptor serviceEndpoint(Class<?> class1)
   {
      this.sessionBean.setServiceEndpoint(convertToFullyQualifiedClasType(class1));
      return this;
   }

   @Override
   public SessionDescriptor ejbClass(Class<?> class1)
   {
      EjbClassType classType = new EjbClassType();
      classType.setValue(class1.getCanonicalName());
      this.sessionBean.setEjbClass(classType);
      return this;
   }

   @Override
   public SessionDescriptor sessionType(SessionType type)
   {
      SessionTypeType sessionType = new SessionTypeType();
      sessionType.setValue(type.getType());
      this.sessionBean.setSessionType(sessionType);
      return this;
   }

   @Override
   public SessionDescriptor statefulTimeout(int value, String unit)
   {
      XsdIntegerType timeout = new XsdIntegerType();
      timeout.setValue(new BigInteger(String.valueOf(value)));

      TimeUnitTypeType unitType = new TimeUnitTypeType();
      unitType.setValue(unit);

      StatefulTimeoutType timeouType = new StatefulTimeoutType();
      timeouType.setUnit(unitType);
      timeouType.setTimeout(timeout);

      this.sessionBean.setStatefulTimeout(timeouType);
      return this;
   }

   @Override
   public SessionDescriptor timeoutMehod(String name, String... params)
  {
      MethodParamsType paramsType = new MethodParamsType();
      for (String param : params)
      {
         JavaTypeType javaTypeType = new JavaTypeType();
         javaTypeType.setValue(param);
         paramsType.getMethodParam().add(javaTypeType);
      }

      NamedMethodType methodType = new NamedMethodType();
      methodType.setMethodName(convertToXmlString(name));
      methodType.setMethodParams(paramsType);
      
      this.sessionBean.setTimeoutMethod(methodType);
      return this;
   }

   @Override
   public TimerDescriptor timer()
   {
      return new TimerDescriptorImpl(getSchemaModel(), sessionBean);
   }

   @Override
   public TimerDescriptor timer(String id)
   {
      return new TimerDescriptorImpl(getSchemaModel(), sessionBean, id);
   }
}
