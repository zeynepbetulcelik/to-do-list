package com.appcent.todolist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ApiModel(value = "List dto Api model documentation", description = "Model")
public class ListResponseModel implements Serializable {
    @ApiModelProperty(value = "Unique id field of todolist dto object (required for delete and update)")
    private UUID id;
    @ApiModelProperty(value = "category field of todolist dto object")
    private String category;
    @ApiModelProperty(value = "name field of todolist dto object")
    private String name;
    @ApiModelProperty(value = "complete field of todolist dto object it means todolist completed or not")
    private boolean complete;

    public ListResponseModel(String category, String name, boolean complete, UUID id) {
        this.id=id;
        this.category=category;
        this.name=name;
        this.complete=complete;
    }

    public ListResponseModel() {

    }
}
