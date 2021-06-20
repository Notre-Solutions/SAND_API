package com.example.sand.repository;
import com.example.sand.model.BinanceCandlestick;
import com.example.sand.model.JobConfiguration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JobConfigurationRepository extends CrudRepository<JobConfiguration, Integer> {

    @Query(value="select * from job_configuration where active=TRUE", nativeQuery = true)
    List<JobConfiguration> getActiveJobConfigs();

    @Query(value="select * from job_configuration where name=?1", nativeQuery = true)
    List<JobConfiguration> getConfigByName(String name);

    @Modifying
    @Transactional
    @Query(value="update job_configuration set active = TRUE where name = ?1", nativeQuery = true)
    int setExistingConfigActive(String name);

    @Modifying
    @Transactional
    @Query(value="update job_configuration set active = FALSE where name = ?1", nativeQuery = true)
    int setExistingConfigNotActive(String name);

}
