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

import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.SessionDescriptor;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.EjbNameType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.HomeType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.LocalHomeType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.LocalType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.RemoteType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.SessionBeanType;
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
      super(model);
      SessionBeanType sessionBean = new SessionBeanType();
      model.getEnterpriseBeans().getSessionOrEntityOrMessageDriven().add(sessionBean);
      this.sessionBean = sessionBean;
      
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
      homeType.setValue(class1.getName());
      this.sessionBean.setHome(homeType);
      return this;
   }
   
   @Override
   public SessionDescriptor remote(Class<?> class1)
   {
      RemoteType remoteType = new RemoteType();
      remoteType.setValue(class1.getName());
      this.sessionBean.setRemote(remoteType);
      return this;
   }

   @Override
   public SessionDescriptor localHome(Class<?> class1)
   {
      LocalHomeType localHomeType = new LocalHomeType();
      localHomeType.setValue(class1.getName());
      this.sessionBean.setLocalHome(localHomeType);
      return this;
   }

   @Override
   public SessionDescriptor local(Class<?> class1)
   {
      LocalType localType = new LocalType();
      localType.setValue(class1.getName());
      this.sessionBean.setLocal(localType);
      return this;
   }

}
