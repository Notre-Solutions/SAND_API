package com.example.sand.repository;
import com.example.sand.model.BinanceCandlestick;
import com.example.sand.model.JobConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobConfigurationRepository extends CrudRepository<JobConfiguration, Integer> {

    @Query(value="select * from job_configuration where active=TRUE", nativeQuery = true)
    List<JobConfiguration> getActiveJobCofigs();

}
