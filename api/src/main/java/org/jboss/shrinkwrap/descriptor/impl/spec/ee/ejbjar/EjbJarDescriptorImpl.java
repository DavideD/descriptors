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

import java.util.List;

import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.DescriptionDescriptor;
import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.DisplayNameDescriptor;
import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.EjbJarDescriptor;
import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.EnterpriseBeansDescriptor;
import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.IconDescriptor;
import org.jboss.shrinkwrap.descriptor.impl.base.SchemaDescriptorImplBase;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.PathType;

/**
 * @author "Davide D'Alto"
 * @version $Revision: $
 */
public class EjbJarDescriptorImpl extends SchemaDescriptorImplBase<EjbJarModel> implements EjbJarDescriptor
{

   private final EjbJarModel ejbJarModel;

   public EjbJarDescriptorImpl()
   {
      this(new EjbJarModel());
   }

   public EjbJarDescriptorImpl(EjbJarModel ejbJarModel)
   {
      this.ejbJarModel = ejbJarModel;
   }

   org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String convertToXmlString(String value)
   {
//      if (value == null)
//         return null;
      
      org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String stringXml = new org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String();
      stringXml.setValue(value);
      return stringXml;
   }

   static <T> T getElement(List<T> elements, T value)
   {
      if (elements.contains(value))
      {
         for (T element : elements)
         {
            if (element.equals(value))
               return element;
         }
      }
      elements.add(value);
      return value;
   }
   
   PathType convertToPath(String path)
   {
      PathType pathType = new PathType();
      pathType.setValue(path);
      return pathType;
   }

   @Override
   public EjbJarModel getSchemaModel()
   {
      return ejbJarModel;
   }
   
   

   @Override
   public EjbJarDescriptor moduleName(String moduleName)
   {
      ejbJarModel.setModuleName(convertToXmlString(moduleName));
      return this;
   }

   @Override
   public IconDescriptor icon()
   {
      return new IconDescriptorImpl(getSchemaModel());
   }

   @Override
   public DisplayNameDescriptor displayName(String name)
   {
      return new DisplayNameDescriptorImpl(getSchemaModel(), name);
   }

   @Override
   public DescriptionDescriptor description(String description)
   {
     return new DescriptionDescriptorImpl(getSchemaModel(), description);
   }

   @Override
   public EjbJarDescriptor ejbClientJar(String path)
   {
      ejbJarModel.setEjbClientJar(convertToPath(path));
      return this;
   }

   @Override
   public EnterpriseBeansDescriptor enterpriseBeans()
   {     
      return new EnterpriseBeansDescriptorImpl(getSchemaModel());
   }

   @Override
   public EjbJarDescriptor idEjbJar(String id)
   {
      ejbJarModel.setId(id);
      return this;
   }

   @Override
   public EjbJarDescriptor metadataComplete()
   {
      ejbJarModel.setMetadataComplete(Boolean.TRUE);
      return this;
   }

   @Override
   public EjbJarDescriptor notMetaDataComplete()
   {
      ejbJarModel.setMetadataComplete(Boolean.FALSE);
      return this;
   }

   @Override
   public EjbJarDescriptor version(String version)
   {
      ejbJarModel.setVersion(version);
      return this;
   }
}
