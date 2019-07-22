package personal.cyy.automall.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import personal.cyy.automall.model.Shop;

import java.io.Serializable;

/**
 * 商家 JPA
 *
 * @Author Cinyky
 * @Date 14:50 2019-07-13
 */
@Repository
public interface ShopJPA
        extends JpaRepository<Shop, String>,
        JpaSpecificationExecutor<Shop>,
        Serializable {
}
