package org.ow2.sirocco.cloudmanager.model.cimi;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
// @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CloudEntryPoint extends CloudEntity implements Serializable {
    private static final long serialVersionUID = 1L;
}
