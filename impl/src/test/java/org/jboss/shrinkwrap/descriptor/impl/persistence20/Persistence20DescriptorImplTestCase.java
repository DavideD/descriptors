/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat Middleware LLC, and individual contributors
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
package org.jboss.shrinkwrap.descriptor.impl.persistence20;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.persistence20.Persistence20Descriptor;
import org.jboss.shrinkwrap.descriptor.gen.TestDescriptorImpl;
import org.junit.Test;

public class Persistence20DescriptorImplTestCase
{
   @Test
   public void testNullArg() throws Exception
   {
      Persistence20Descriptor type = Descriptors.create(Persistence20Descriptor.class);
      TestDescriptorImpl.testNullArgs(type);
   }

   @Test
   public void testPersistenceUnit() throws Exception
   {
      Persistence20Descriptor type = Descriptors.create(Persistence20Descriptor.class);
      type.persistenceUnit().up();
      type.persistenceUnit().up();
      assertTrue(type.getPersistenceUnitList().size() == 2);
      type.removeAllPersistenceUnit();
      assertTrue(type.getPersistenceUnitList().size() == 0);
   }

   @Test
   public void testVersion() throws Exception
   {
      Persistence20Descriptor type = Descriptors.create(Persistence20Descriptor.class);
      type.setVersion("test");
      assertEquals(type.getVersion(), "test");
      type.removeVersion();
      assertNull(type.getVersion());
   }
}
