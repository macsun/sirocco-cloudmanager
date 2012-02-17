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

package org.ow2.sirocco.cloudmanager.provider.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.ow2.sirocco.cloudmanager.provider.api.entity.vo.CloudProviderAccountVO;

@Entity
public class CloudProviderAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String login;

    private String password;

    private Collection<Project> projects;

    private Collection<Machine> machines;

    private Collection<Volume> volumes;

    private List<MachineImage> images;

    private CloudProvider cloudProvider;

    public CloudProviderAccount() {
        this.projects = new ArrayList<Project>();
        this.machines = new ArrayList<Machine>();
        this.volumes = new ArrayList<Volume>();
        this.images = new ArrayList<MachineImage>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @ManyToMany(mappedBy = "cloudProviderAccounts")
    public Collection<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(final List<Project> projects) {
        this.projects = projects;
    }

    @OneToMany(mappedBy = "cloudProviderAccount", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Collection<Machine> getMachines() {
        return this.machines;
    }

    public void setMachines(final List<Machine> machines) {
        this.machines = machines;
    }

    @OneToMany(mappedBy = "cloudProviderAccount", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Collection<Volume> getVolumes() {
        return this.volumes;
    }

    public void setVolumes(final List<Volume> volumes) {
        this.volumes = volumes;
    }

    @OneToMany(mappedBy = "cloudProviderAccount")
    public Collection<MachineImage> getImages() {
        return this.images;
    }

    public void setImages(final List<MachineImage> images) {
        this.images = images;
    }

    @ManyToOne
    @JoinColumn(name = "CloudProvider_id")
    public CloudProvider getCloudProvider() {
        return this.cloudProvider;
    }

    public void setCloudProvider(final CloudProvider cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    @Override
    public String toString() {
        // In order to avoid a "loop" pb, project is not present in this
        // toString() method.
        String s = this.getClass().getSimpleName() + "=[id=" + this.getId() + ", login=" + this.getLogin() + ", password="
            + this.getPassword() + ", cloudProvider=" + this.getCloudProvider() + "]";
        return s;
    }

    public CloudProviderAccountVO toValueObject() {
        CloudProviderAccountVO result = new CloudProviderAccountVO();
        result.setId(this.getId().toString());
        result.setLogin(this.getLogin());
        result.setPassword(this.getPassword());
        result.setCloudProviderId(this.getCloudProvider().getId().toString());
        result.setCloudProviderType(this.getCloudProvider().getCloudProviderType());
        return result;
    }

}