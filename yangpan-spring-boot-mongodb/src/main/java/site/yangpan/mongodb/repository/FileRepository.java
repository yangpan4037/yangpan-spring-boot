package site.yangpan.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import site.yangpan.mongodb.entity.FileEntity;


/**
 * FileEntity 存储库.
 * Created by yangpan on 2019-07-18 23:53.
 */
public interface FileRepository extends MongoRepository<FileEntity, String> {
}
