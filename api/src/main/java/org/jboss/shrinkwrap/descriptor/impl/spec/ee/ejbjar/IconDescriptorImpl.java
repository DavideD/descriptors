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

import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.IconDescriptor;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.IconType;

/**
 * @author "Davide D'Alto"
 * @version $Revision: $
 *
 */
public class IconDescriptorImpl extends EjbJarDescriptorImpl implements IconDescriptor
{
   private final IconType icon = new IconType();
   private final List<IconType> icons;
   
   public IconDescriptorImpl(EjbJarModel model)
   {
      super(model);
      this.icons = model.getIcon();
   }

   @Override
   public IconDescriptor id(String value)
   {
      getElement(icons, icon).setId(value);
      return this;
   }

   @Override
   public IconDescriptor lang(String value)
   {
      getElement(icons, icon).setLang(value);
      return this;
   }

   @Override
   public IconDescriptor smallIcon(String path)
   {
      getElement(icons, icon).setSmallIcon(convertToPath(path));
      return this;
   }

   @Override
   public IconDescriptor largeIcon(String path)
   {
      getElement(icons, icon).setLargeIcon(convertToPath(path));
      return this;
   }

}
