/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.weld.serialization;

import java.io.Serializable;

import org.jboss.weld.Container;
import org.jboss.weld.introspector.WeldClass;
import org.jboss.weld.resources.ClassTransformer;

public abstract class AbstractWeldAnnotatedHolder<X> implements Serializable {

    private static final long serialVersionUID = -5682348068976786225L;

    private Class<X> declaringClass;

    protected AbstractWeldAnnotatedHolder(Class<X> declaringClass) {
        this.declaringClass = declaringClass;
    }

    protected WeldClass<X> getDeclaringWeldClass() {
        return Container.instance().services().get(ClassTransformer.class).loadClass(declaringClass);
    }
}