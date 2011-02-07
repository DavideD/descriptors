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

import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.DescriptionDescriptor;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.DescriptionType;

/**
 * @author "Davide D'Alto"
 * @version $Revision: $
 *
 */
public class DescriptionDescriptorImpl extends EjbJarDescriptorImpl implements DescriptionDescriptor
{

   private final DescriptionType description;

   public DescriptionDescriptorImpl(EjbJarModel model, String description)
   {
      super(model);
      DescriptionType descriptionType = new DescriptionType();
      EjbJarDescriptorImpl.getElement(model.getDescription(), descriptionType)
         .setValue(description);
      this.description = descriptionType;
   }

   @Override
   public DescriptionDescriptor id(String value)
   {
      getElement(getSchemaModel().getDescription(), description).setId(value);
      return this;
   }

   @Override
   public DescriptionDescriptor lang(String value)
   {
      getElement(getSchemaModel().getDescription(), description).setLang(value);
      return this;
   }

   

}
