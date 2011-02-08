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
package org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar;

import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.SessionType;

/**
 * @author "Davide D'Alto"
 * @version $Revision: $
 *
 */
public interface SessionDescriptor extends EnterpriseBeansDescriptor
{

   SessionDescriptor ejbName(String name);

   SessionDescriptor mappedName(String name);

   SessionDescriptor home(Class<?> class1);

   SessionDescriptor remote(Class<?> class1);

   SessionDescriptor localHome(Class<?> class1);

   SessionDescriptor local(Class<?> class1);

   SessionDescriptor businnessRemote(Class<?>... classes);

   SessionDescriptor businnessLocal(Class<?>... classes);

   SessionDescriptor localBean();
   
   SessionDescriptor serviceEndpoint(Class<?> class1);

   SessionDescriptor ejbClass(Class<?> class1);

   SessionDescriptor sessionType(SessionType type);

   SessionDescriptor statefulTimeout(int value, String unit);

   SessionDescriptor timeoutMehod(String name, String... params);

   TimerDescriptor timer();
   
   TimerDescriptor timer(String id);

}
