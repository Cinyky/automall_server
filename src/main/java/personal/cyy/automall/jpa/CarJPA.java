package personal.cyy.automall.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import personal.cyy.automall.model.Car;

import java.io.Serializable;

/**
 * 车 JPA
 *
 * @Author Cinyky
 * @Date 19:41 2019-05-16
 */
@Repository
public interface CarJPA
        extends JpaRepository<Car, String>,
        JpaSpecificationExecutor<Car>,
        Serializable {

}
