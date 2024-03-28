package com.example.videostreamingplatform.entity;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "_monitoring")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Monitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monitoring_id", nullable = false)
    private Long id;

    @Column(name = "user_login", nullable = false, length = 500)
    private String userLogin;

    @Column(name = "use_date", nullable = false)
    private Timestamp useDate;

    @Column(name = "message_mon", nullable = false, length = 500)
    private String messageMon;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Monitoring that = (Monitoring) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}