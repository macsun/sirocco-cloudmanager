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
import java.util.List;

import javax.persistence.Entity;


import org.hibernate.annotations.CollectionOfElements;

@Entity
public class MachineConfiguration extends CloudEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private	Cpu			cpu;
	private Memory			memory;
	private List<DiskTemplate>	disks;	

	public Cpu	getCpu() {
	    return this.cpu;
	}

	public void setCpu(Cpu cpu) {
	    this.cpu = cpu;
	}

	public Memory getMemory() {
	    return this.memory;
	}

	public void setMemory(Memory memory) {
	    memory = this.memory;
	}

	@CollectionOfElements
	public List<DiskTemplate> getDiskTemplates() {
	    return this.disks;
	}

	public void setDiskTemplates(List<DiskTemplate> disks) {
	    this.disks = disks;
	}
}