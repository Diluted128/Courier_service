package com.delly.delly.domains.pack;

import com.delly.delly.domains.courier.Courier;
import com.delly.delly.domains.order.Orders;
import com.delly.delly.domains.packlocker.PackLocker;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "deliver_id")
    private Courier courier;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "packLocker_id")
    private PackLocker packLocker;

    public Pack(Orders orders, Courier courier, PackLocker packLocker) {
        this.orders = orders;
        this.courier = courier;
        this.packLocker = packLocker;
    }
}
