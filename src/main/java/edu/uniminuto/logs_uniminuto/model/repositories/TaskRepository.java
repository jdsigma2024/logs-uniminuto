package edu.uniminuto.logs_uniminuto.model.repositories;

import edu.uniminuto.logs_uniminuto.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {
}
