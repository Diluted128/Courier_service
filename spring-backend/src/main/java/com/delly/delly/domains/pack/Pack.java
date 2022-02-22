package com.delly.delly.domains.pack;

import com.delly.delly.domains.courier.Deliver;
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
    private Deliver deliver;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "packLocker_id")
    private PackLocker packLocker;

    public Pack(Orders orders, Deliver deliver, PackLocker packLocker) {
        this.orders = orders;
        this.deliver = deliver;
        this.packLocker = packLocker;
    }
}
