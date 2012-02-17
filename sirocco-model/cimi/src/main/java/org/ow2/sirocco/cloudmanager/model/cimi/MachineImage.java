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

package org.ow2.sirocco.cloudmanager.model.cimi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class MachineImage extends CloudEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    public static enum State {
        CREATING, AVAILABLE, DELETING, ERROR
    }

    public static enum Type {
		IMAGE, SNAPSHOT, PARTIAL_SNAPSHOT
    }

	private State		state;
	private Type		type;

	private MachineImage	relatedImage;
	
	private CloudProviderAccount cloudProviderAccount;
	

	@Enumerated(EnumType.STRING)
	public State getState() {
		return this.state;
	}

	public void setState(final State state) {
        this.state = state;
    }

	@Enumerated(EnumType.STRING)
	public Type getType() {
		return this.type;
	}

	public void setType(final Type type) {
        this.type = type;
    }

	@OneToOne
	public MachineImage getRelatedImage() {
		return relatedImage;
	}

	public void setRelatedImage(MachineImage relatedImage) {
		this.relatedImage = relatedImage;
	}

	@ManyToOne
	public CloudProviderAccount getCloudProviderAccount() {
		return cloudProviderAccount;
	}

	public void setCloudProviderAccount(CloudProviderAccount cloudProviderAccount) {
		this.cloudProviderAccount = cloudProviderAccount;
	}
}



