package com.thoughtworks.go.server.dao;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.thoughtworks.go.domain.Pipeline;

import java.util.Objects;

@Table(keyspace = "gocd", name = "pipelines")
public class PipelineCassandraData {
    @PartitionKey
    private String pipelineName;
    private Integer counter;

    public String getPipelineName() {
        return pipelineName;
    }

    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public PipelineCassandraData() {
    }

    public Integer getCounter() {
        return counter;
    }

    public PipelineCassandraData(Pipeline pipeline) {
        this.pipelineName = pipeline.getName();
        this.counter = pipeline.getCounter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PipelineCassandraData that = (PipelineCassandraData) o;
        return Objects.equals(pipelineName, that.pipelineName) &&
                Objects.equals(counter, that.counter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pipelineName, counter);
    }
}

