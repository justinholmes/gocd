package com.thoughtworks.go.server.dao.accessors;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;
import com.thoughtworks.go.domain.User;
import com.thoughtworks.go.server.dao.PipelineCassandraData;
import org.springframework.stereotype.Component;

@Accessor
public interface PipelineAccessor {


    @Query("SELECT * FROM gocd.pipelines WHERE pipelinename = ?")
    public PipelineCassandraData getPipelineByName(@Param("pipelinename") String name);

}
