package site.yangpan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.yangpan.entity.CronEntity;

/**
 * CronRepository
 * Created by yangpan on 2019-06-28 16:52.
 */
public interface CronRepository extends JpaRepository<CronEntity, String> {
}
