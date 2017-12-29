package sec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.MessageBoardMessage;

public interface MessageBoardRepository extends JpaRepository<MessageBoardMessage, Long> {

}
