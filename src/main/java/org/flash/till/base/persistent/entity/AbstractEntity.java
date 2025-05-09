package org.flash.till.base.persistent.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public abstract class AbstractEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
