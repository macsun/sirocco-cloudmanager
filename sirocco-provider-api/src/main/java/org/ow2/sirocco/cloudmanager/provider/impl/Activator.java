/**
 *
 * SIROCCO
 * Copyright (C) 2011 France Telecom
 * Contact: sirocco@ow2.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 *
 *  $Id$
 *
 */

package org.ow2.sirocco.cloudmanager.provider.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.ow2.sirocco.cloudmanager.provider.api.service.ICloudProviderFactoryFinder;

public class Activator implements BundleActivator {
    private ServiceRegistration serviceRegistration;

    public void start(final BundleContext context) {
        Dictionary<String, String> props = new Hashtable<String, String>();
        props.put(Constants.SERVICE_PID, ICloudProviderFactoryFinder.class.getSimpleName());

        CloudProviderFactoryFinderImpl cloudProviderFactoriesManagerImpl = new CloudProviderFactoryFinderImpl(context);
        this.serviceRegistration = context.registerService(ICloudProviderFactoryFinder.class.getCanonicalName(),
            cloudProviderFactoriesManagerImpl, props);
    }

    public void stop(final BundleContext context) {
        context.ungetService(this.serviceRegistration.getReference());
    }

}