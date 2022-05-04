package com.appcent.todolist.repositories;

import com.appcent.todolist.entities.ToDoList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, UUID> {
    @Query(value = " Select list.* from user inner join list on list.user_id=user.id where user.username=:username",nativeQuery = true)
    List<ToDoList> getListsByUsername(@Param("username")String username);

    @Query(value="update list set list.complete=true where list.id=:id",nativeQuery = true)
    @Modifying
    void updateToDoList(@Param("id") UUID id);

}
