package com.delly.delly.dao;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer ID;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "deliver_id")
    private Deliver deliver;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "packLocker_id")
    private PackLocker packLocker;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Orders getOrder() {
        return orders;
    }

    public void setOrder(Orders orders) {
        this.orders = orders;
    }

    public Deliver getDeliver() {
        return deliver;
    }

    public void setDeliver(Deliver deliver) {
        this.deliver = deliver;
    }

    public PackLocker getPackLocker() {
        return packLocker;
    }

    public void setPackLocker(PackLocker packLocker) {
        this.packLocker = packLocker;
    }
}
