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

import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.EnterpriseBeansDescriptor;
import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.EntityDescriptor;
import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.MessageDrivenDescriptor;
import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.SessionDescriptor;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.EnterpriseBeansType;

/**
 * @author "Davide D'Alto"
 * @version $Revision: $
 *
 */
public class EnterpriseBeansDescriptorImpl extends EjbJarDescriptorImpl implements EnterpriseBeansDescriptor
{

   private final EnterpriseBeansType enterpriseBean;

   public EnterpriseBeansDescriptorImpl(EjbJarModel model)
   {
      super(model);
      EnterpriseBeansType enterpriseBean = new EnterpriseBeansType();
      model.setEnterpriseBeans(enterpriseBean);
      this.enterpriseBean = enterpriseBean;
   }

   @Override
   public SessionDescriptor session()
   {
      return new SessionDescriptorImpl(getSchemaModel());
   }

   @Override
   public MessageDrivenDescriptor messageDriven()
   {
      return new MessageDrivernDescriptorImpl(getSchemaModel());
   }

   @Override
   public EntityDescriptor entity()
   {
      return new EntityDescriptorImpl(getSchemaModel());
   }

   @Override
   public EnterpriseBeansDescriptor id(String id)
   {
      this.enterpriseBean.setId(id);
      return this;
   }

}
